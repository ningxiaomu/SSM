package com.luo.kafka.producer;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class producerSample {
    public static void main(String[] args) {
        send();
//        sendWithCallBackAndPartition();

    }

    private final static String name="kafka1-topic";

    /**
     * 异步发送演示
     */
    public static void send(){

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.241.129:9092");
        properties.put(ProducerConfig.ACKS_CONFIG,"all");
        properties.put(ProducerConfig.RETRIES_CONFIG,"0");
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG,"16384");
        properties.put(ProducerConfig.LINGER_MS_CONFIG,"1");
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG,"33554432");

        //序列化和反序列化
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"com.luo.kafka.producer.PartitionSample");

        //producer的主对象
        Producer<String,String> producer = new KafkaProducer<String, String>(properties);

        for (int i = 0; i <100 ; i++) {
            ProducerRecord<String,String> record = new ProducerRecord<>(name,"key-"+i,"value-"+i);
            producer.send(record);
        }
        //关闭通道
        producer.close();
    }
    public static void sendWithCallBackAndPartition(){

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.241.129:9092");
        properties.put(ProducerConfig.ACKS_CONFIG,"all");
        properties.put(ProducerConfig.RETRIES_CONFIG,"0");
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG,"16384");
        properties.put(ProducerConfig.LINGER_MS_CONFIG,"1");
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG,"33554432");

        //序列化和反序列化
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"com.luo.kafka.producer.PartitionSample");

        //producer的主对象
        Producer<String,String> producer = new KafkaProducer<String, String>(properties);

        for (int i = 0; i <100 ; i++) {
            ProducerRecord<String,String> record = new ProducerRecord<>(name,"key-"+i,"value-"+i);
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    System.out.println("partition : "+recordMetadata.partition()+" , offset : "+recordMetadata.offset());
                }
            });
        }
        //关闭通道
//        producer.close();
    }
}
