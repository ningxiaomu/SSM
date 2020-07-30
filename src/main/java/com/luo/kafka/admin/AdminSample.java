package com.luo.kafka.admin;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.config.ConfigResource;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class AdminSample {
    public static void main(String[] args) throws Exception {
//        adminClient();
//        System.out.println("连接kafka成功==========");
//        creatTopic();
//        delTopic();
//        getTopics();
//        desTopic();
//        descConfig();
//        alterConfig();
        addPartitions(2);
        desTopic();

    }

    /**
     * 创建adminClient
     * @return
     */
   public static AdminClient adminClient(){
       Properties properties = new Properties();
       properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.241.129:9092");

       AdminClient adminClient = AdminClient.create(properties);
       return adminClient;
   }

    /**
     * 创建topic
     */

    public static void creatTopic(){
        AdminClient adminClient = adminClient();
        Short rs =1;
        NewTopic newTopic = new NewTopic("luobo2",1,rs);

        CreateTopicsResult topics = adminClient.createTopics(Arrays.asList(newTopic));
        System.out.println("所创建的topics:"+topics);
    }
    /**
     * 获取topics
     */
    public static void getTopics() throws Exception {
        AdminClient adminClient = adminClient();
        // 是否查看internal选项
        ListTopicsOptions options = new ListTopicsOptions();
        options.listInternal(true);
//        ListTopicsResult listTopicsResult = adminClient.listTopics();
        ListTopicsResult listTopicsResult = adminClient.listTopics(options);
        Set<String> names = listTopicsResult.names().get();
        Collection<TopicListing> topicListings = listTopicsResult.listings().get();
        KafkaFuture<Map<String, TopicListing>> mapKafkaFuture = listTopicsResult.namesToListings();
        // 打印names
        names.stream().forEach(System.out::println);
        // 打印topicListings
        topicListings.stream().forEach((topicList)->{
            System.out.println(topicList);
        });
    }

    /**
     * 删除topic
     */
    public static void delTopic() throws Exception {

        AdminClient adminClient = adminClient();
        DeleteTopicsResult result = adminClient.deleteTopics(Arrays.asList("luobo2"));
        result.all().get();

    }

    /**
     * topic描述
     */

    public static void desTopic() throws Exception {
        AdminClient adminClient = adminClient();
        DescribeTopicsResult result = adminClient.describeTopics(Arrays.asList("kafka1-topic"));
        Map<String, TopicDescription> map = result.all().get();
        Set<Map.Entry<String, TopicDescription>> entries = map.entrySet();
        entries.stream().forEach((entry)->{
            System.out.println("name:"+entry.getKey()+"; desc:"+entry.getValue());
        });
    }

    /**
     * topic配置信息查看
     */
    public static void descConfig() throws Exception{

        AdminClient adminClient = adminClient();
        ConfigResource configResource = new ConfigResource(ConfigResource.Type.TOPIC,"kafka1-topic");
        DescribeConfigsResult describeConfigsResult = adminClient.describeConfigs(Arrays.asList(configResource));
        Map<ConfigResource, Config> configResourceConfigMap = describeConfigsResult.all().get();
        configResourceConfigMap.entrySet().stream().forEach((entry)->{
            System.out.println("configResource : "+entry.getKey()+" , Config : "+entry.getValue());
        });


    }

    /**
     * 修改config
     */
    public static void alterConfig() throws Exception{
        AdminClient adminClient = adminClient();
        Map<ConfigResource,Config> map = new HashMap<>();
        ConfigResource configResource = new ConfigResource(ConfigResource.Type.TOPIC,"kafka1-topic");
        Config config = new Config(Arrays.asList(new ConfigEntry("preallocate","true")));
        map.put(configResource,config);
        adminClient.alterConfigs(map);
        System.out.println("修改成功");
    }

    /**
     * 修改partiptions-->只能增加，没有减少
     */

    public static void addPartitions(int num) throws Exception{

        AdminClient adminClient =  adminClient();
        Map<String,NewPartitions> partitionsMap = new HashMap<>();
        NewPartitions newPartitions = NewPartitions.increaseTo(num);
        partitionsMap.put("kafka1-topic",newPartitions);
        CreatePartitionsResult partitions = adminClient.createPartitions(partitionsMap);
        partitions.all().get();

    }
}

