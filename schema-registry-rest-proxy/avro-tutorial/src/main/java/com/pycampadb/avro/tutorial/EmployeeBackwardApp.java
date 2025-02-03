package com.pycampadb.avro;

import com.course.avro.data.EmployeeBackwardV1;
import com.course.avro.data.EmployeeBackwardV2;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;

public class EmployeeBackwardApp {
    public static void main(String[] args) {
        var file = new File("employeeBackwardV1.avro");
        writeUsingV1(file);
        System.out.println("");
        readUsingV2(file);
    }

    private static void readUsingV2(File fromFile) {
        var datumReader = new SpecificDatumReader<>(EmployeeBackwardV2.class);

        try (var dataReader = new DataFileReader<>(fromFile, datumReader)){
            dataReader.forEach(System.out::println);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void writeUsingV1(File toFile) {
        var data = EmployeeBackwardV1.newBuilder()
                .setFirstName("Zaraki")
                .setLastName("Kenpachi")
                .build();
        var datumWriter = new SpecificDatumWriter<>(EmployeeBackwardV1.class);

        try (var dataWriter = new DataFileWriter<>(datumWriter)){
            dataWriter.create(data.getSchema(), toFile);
            dataWriter.append(data);

            System.out.println("Writing");
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
