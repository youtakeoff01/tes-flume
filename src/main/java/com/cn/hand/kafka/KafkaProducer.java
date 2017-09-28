/*
package com.cn.hand.kafka;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;


public class KafkaProducer {
    private static final String TOPIC = "Topicflume01"; //kafka创建的topic
    private static final String BROKER_LIST = "hadoop004.edcs.org:6667"; //broker的地址和端口
    private static final String SERIALIZER_CLASS = "kafka.serializer.StringEncoder"; // 序列化类

    public static void producer(String str, int index) {
        Properties props = new Properties();
        props.put("serializer.class", SERIALIZER_CLASS);
        props.put("metadata.broker.list", BROKER_LIST);

        ProducerConfig config = new ProducerConfig(props);
        Producer<String, String> producer = new Producer<String, String>(config);

        for (int i = 0; i < index; i++) {
            KeyedMessage<String, String> message =
                    new KeyedMessage<String, String>(TOPIC, str);
            producer.send(message);
        }
    }
}
*/
