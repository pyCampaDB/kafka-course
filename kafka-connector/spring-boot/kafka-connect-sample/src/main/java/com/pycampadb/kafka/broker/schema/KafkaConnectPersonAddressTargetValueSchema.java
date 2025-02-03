package com.pycampadb.kafka.broker.schema;

import com.pycampadb.kafka.broker.message.kafkaconnect.KafkaConnectSchema;

import java.util.ArrayList;

public class KafkaConnectPersonAddressTargetValueSchema {
    private static KafkaConnectSchema instance;

    static {
        instance = new KafkaConnectSchema();
        var fields = new ArrayList<KafkaConnectSchema>();
        fields.add(new KafkaConnectSchema(KafkaConnectSchema.Type.INT_32.toString(), false, "person_id", null));
        fields.add(new KafkaConnectSchema(KafkaConnectSchema.Type.STRING.toString(), true, "id_card_number", null));
        fields.add(new KafkaConnectSchema(KafkaConnectSchema.Type.STRING.toString(), true, "full_name", null));
        fields.add(new KafkaConnectSchema(KafkaConnectSchema.Type.STRING.toString(), true, "email", null));
        fields.add(new KafkaConnectSchema(KafkaConnectSchema.Type.INT_32.toString(), false, "address_id", null));
        fields.add(new KafkaConnectSchema(KafkaConnectSchema.Type.STRING.toString(), true, "address", null));
        fields.add(new KafkaConnectSchema(KafkaConnectSchema.Type.STRING.toString(), true, "city", null));
        fields.add(new KafkaConnectSchema(KafkaConnectSchema.Type.STRING.toString(), true, "postal_code", null));

        instance.setType(KafkaConnectSchema.Type.STRUCT.toString());
        instance.setOptional(false);
        instance.setFields(fields);
    }

    private KafkaConnectPersonAddressTargetValueSchema(){

    }

    public static KafkaConnectSchema instance() {
        return instance;
    }
}
