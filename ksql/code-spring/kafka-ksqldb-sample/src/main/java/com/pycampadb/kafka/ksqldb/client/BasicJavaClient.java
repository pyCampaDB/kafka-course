package com.pycampadb.kafka.ksqldb.client;

import io.confluent.ksql.api.client.Client;
import io.confluent.ksql.api.client.ClientOptions;
import io.confluent.ksql.api.client.InsertsPublisher;
import io.confluent.ksql.api.client.KsqlObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class BasicJavaClient {
    private static final String ERROR ="An error occurred: ";
    private static final String STREAM = "`s-java-client`";
    private static final ClientOptions CLIENT_OPTIONS = ClientOptions.create()
            .setHost("localhost")
            .setPort(8088);
    private static final Logger log = LoggerFactory.getLogger(BasicJavaClient.class);

    public void createStream() throws InterruptedException{
        try (var client = Client.create(CLIENT_OPTIONS);) {
            var statement = "DROP STREAM IF EXISTS `s-java-client` DELETE TOPIC;";

            var result = client.executeStatement(statement).get();
            log.info("Stream execution result: {}", result);

            statement = """
                    CREATE OR REPLACE STREAM `s-java-client` (
                        `fieldOne` VARCHAR,
                        `fieldTwo` INT,
                        `fieldThree` BOOLEAN
                    ) WITH (
                        KAFKA_TOPIC = 't-java-client',
                        PARTITIONS = 2,
                        VALUE_FORMAT = 'JSON'
                    );
                    """;

            result = client.executeStatement(statement).get();
            log.info("Stream execution result: {}", result);

        } catch (ExecutionException e) {
            log.error("An error occurred:  {}", e.getMessage(), e);
        }

    }

    public void describeStream() throws InterruptedException{
        try (var client = Client.create(CLIENT_OPTIONS)){
            var description = client.describeSource(STREAM).get();

            log.info("{} {} has the following fields : {}", description.type(), description.name(), description.fields());
        } catch (ExecutionException e){
            log.error("{}{}",ERROR ,e.getMessage(), e);
        }
    }

    public void listObjects() throws InterruptedException{
        try (var client = Client.create(CLIENT_OPTIONS)){
            //listamos los tópicos
            log.info("KAFKA TOPICS: ");
            client.listTopics().get().forEach(
                    t -> log.info(
                            "topic {} has {} partitions", t.getName(), t.getPartitions()
                    )
            );
            log.info("\n\n");
            log.info("KAFKA STREAMS");
            //listamos los streams
            client.listStreams().get().forEach(
                    s -> log.info("Stream {} is coming from topic {}", s.getName(), s.getTopic())
            );

            //listamos las tablas
            log.info("\n\n");
            log.info("KAFKA TABLES");
            client.listTables().get()
                    .forEach(tbl -> log.info("Table {} is coming from topic {}", tbl.getName(), tbl.getTopic()));

        } catch (ExecutionException e){
            log.error("{}{}",ERROR ,e.getMessage(), e);
        }
    }

    public void insertSingle() throws InterruptedException{
        try (var client = Client.create(CLIENT_OPTIONS)){
            var newRow = generateNewRow();
            client.insertInto(STREAM, newRow).get();
        } catch (ExecutionException e){
            log.error("{}{}",ERROR ,e.getMessage(), e);
        }
    }

    public void insertStream (int rows) throws InterruptedException {
        try (var client = Client.create(CLIENT_OPTIONS)){
            var insertsPublisher = new InsertsPublisher();
            var acksPublisher = client.streamInserts(STREAM, insertsPublisher);

            for (int i = 0; i < rows; i++){
                insertsPublisher.accept(generateNewRow());
            }

            insertsPublisher.complete();

            acksPublisher.get();
        } catch (ExecutionException e){
            log.error("{}{}",ERROR ,e.getMessage(), e);
        }
    }

    public void pullQuery () throws InterruptedException{
        try (var client = Client.create(CLIENT_OPTIONS)){
            var pullQueryResult = client.executeQuery(
                    "SELECT * FROM `s-java-client` LIMIT 20;"
            ).get();

            pullQueryResult.forEach(row -> log.info("Row : {}", row));

        }catch (ExecutionException e){
            log.error("{}{}",ERROR ,e.getMessage(), e);
        }
    }

    public void pushQuerySync() throws InterruptedException{
        try (var client = Client.create(CLIENT_OPTIONS)){
            var pushQueryResult = client.streamQuery(
                    "SELECT * FROM `s-java-client` EMIT CHANGES;"
            ).get();

            while (true){
                var row = pushQueryResult.poll();
                log.info("Row : {}", row);
            }
        }catch (ExecutionException e){
            log.error("{}{}",ERROR ,e.getMessage(), e);
        }
    }

    public void pushQueryAsync() {
        try (var client = Client.create(CLIENT_OPTIONS)) {
            client.streamQuery(
                    "SELECT * FROM `s-java-client` EMIT CHANGES;"
            ).thenAccept(
                    pushQueryResult -> {
                        var subscriber = new LogRowSubscriber();
                        pushQueryResult.subscribe(subscriber);
                    }
            ).exceptionally(e -> {
                log.error("Error: {}", e.getMessage(), e);
                return  null;
            });
        }
    }

    private KsqlObject generateNewRow () {
        return new KsqlObject().put("`fieldOne`", "Now is " + LocalTime.now())
                .put("`fieldTwo`", ThreadLocalRandom.current().nextInt())
                .put("`fieldThree`", ThreadLocalRandom.current().nextBoolean());
    }
}
