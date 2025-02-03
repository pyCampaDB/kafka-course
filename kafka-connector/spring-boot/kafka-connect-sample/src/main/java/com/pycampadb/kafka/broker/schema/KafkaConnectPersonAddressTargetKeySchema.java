package com.pycampadb.kafka.broker.schema;

import com.pycampadb.kafka.broker.message.kafkaconnect.KafkaConnectSchema;

public class KafkaConnectPersonAddressTargetKeySchema {
    private static KafkaConnectSchema instance;

    static {
        instance = new KafkaConnectSchema(KafkaConnectSchema.Type.INT_32.toString(), false, null, null);
    }

    private KafkaConnectPersonAddressTargetKeySchema(){}

    public static KafkaConnectSchema instance() {
        return instance;
    }
}
