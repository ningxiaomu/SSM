package com.luo.kafka.consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerSample {
    private final static String name="kafka1-topic";
    public static void main(String[] args) throws Exception{
        helloword();

    }

    private static void helloword() throws Exception{

        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "192.168.241.129:9092");
        props.setProperty("group.id", "test");
        props.setProperty("enable.auto.commit", "false");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String,String> consumer = new KafkaConsumer(props);
        // 消费订阅哪一个Topic或者几个Topic
        consumer.subscribe(Arrays.asList(name));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10000));
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("patition = %d , offset = %d, key = %s, value = %s%n",
                        record.partition(),record.offset(), record.key(), record.value());
            consumer.commitAsync();
        }

    }
}
