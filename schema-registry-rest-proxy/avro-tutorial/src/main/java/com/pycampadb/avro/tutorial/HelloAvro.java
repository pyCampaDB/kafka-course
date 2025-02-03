package com.pycampadb.avro;

import com.course.avro.data.Hello;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class HelloAvro {
    private static final Logger log = LoggerFactory.getLogger(HelloAvro.class);

    public static void main(String[] args) {
        var data = Hello.newBuilder().setMyIntField(ThreadLocalRandom.current().nextInt())
                .setMyStringField("The time is " + LocalTime.now()).build();

        var datumWriter = new SpecificDatumWriter<>(Hello.class);

        try(var dataWriter = new DataFileWriter<>(datumWriter)) {
            var file = new File("helloAvro.avro");
            dataWriter.create(data.getSchema(), file);
            dataWriter.append(data);

            System.out.println("Written: " + data);
        } catch (IOException e){
            log.error(e.getMessage());
        }
    }
}
