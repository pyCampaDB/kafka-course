package com.pycampadb.avro;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecordBuilder;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class HelloAvroGeneric {
    public static void main(String[] args) {
        var schemaString = """
                {
                    "type": "record",
                    "namespace": "com.course.avro.data",
                    "name": "Hello",
                    "doc": "Hello world avro",
                    "fields": [
                        {
                            "name": "MyStringField",
                            "type": "string",
                            "doc": "Just a string"
                        },
                        {
                            "name": "MyIntField",
                            "type": "int",
                            "doc": "Just an int"
                        }
                    ]
                }
                """;

        var schema = new Schema.Parser().parse(schemaString);

        var dataBuilder = new GenericRecordBuilder(schema);
        dataBuilder.set("myStringField", "No is " + LocalTime.now());
        dataBuilder.set("myIntField", ThreadLocalRandom.current().nextInt());

        var data = dataBuilder.build();
        var datumWriter = new GenericDatumWriter<>();

        try(var dataWriter = new DataFileWriter<>(datumWriter)) {
            var file = new File("helloAvroGeneric.avro");
            dataWriter.create(data.getSchema(), file);
            dataWriter.append(data);

            System.out.println("Written: " + data);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
