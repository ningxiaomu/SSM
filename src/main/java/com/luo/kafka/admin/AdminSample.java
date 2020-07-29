package com.luo.kafka.admin;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.kafka.clients.admin.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class AdminSample {
    public final static String TOPIC_NAME="luobo";
    public static void main(String[] args) throws Exception {
        AdminClient adminClient = AdminSample.adminClient();
        System.out.println("adminClient:"+adminClient);
        creatTopic();
        topicsList();
    }
    /**
     *创建topic
     */
    public  static void creatTopic(){
        AdminClient adminClient = adminClient();
        short rs =1;
        NewTopic newTopic =  new NewTopic(TOPIC_NAME,1,rs);
        CreateTopicsResult topic = adminClient.createTopics(Arrays.asList(newTopic));
        System.out.println("CreateTopicsResult:"+topic);

    }
    /**
     * 创建adminClient
     * @return
     */
    public static AdminClient adminClient(){
        Properties properties = new Properties();
        properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.241.128:9092");
        AdminClient adminClient = AdminClient.create(properties);
        return adminClient;
    }
    /**
     * 获取topic
     */
    public static void topicsList() throws Exception {
        AdminClient adminClient = adminClient();
        ListTopicsResult result = adminClient.listTopics();
        Set<String> names = result.names().get();
        names.stream().forEach(System.out::println);
    }
}
