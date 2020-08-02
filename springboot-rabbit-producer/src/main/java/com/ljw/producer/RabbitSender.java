package com.ljw.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljw.entity.Merchant;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: ljw
 * @Date: 2020/7/25 16:52
 * @Description:
 */
@Component
@PropertySource("classpath:rabbitMqInfo.properties")
public class RabbitSender {

    @Value("${com.ljw.directexchange}")
    private String directExchange;

    @Value("${com.ljw.topicexchange}")
    private String topicExchange;

    @Value("${com.ljw.fanoutexchange}")
    private String fanoutExchange;

    @Value("${com.ljw.directroutingkey}")
    private String directRoutingKey;

    @Value("${com.ljw.topicroutingkey1}")
    private String topicRoutingKey1;

    @Value("${com.ljw.topicroutingkey2}")
    private String topicRoutingKey2;


    // 自定义的模板，所有的消息都会转换成JSON发送
    @Autowired
    AmqpTemplate rabbitAmqpTemplate;

    public void send() throws JsonProcessingException {
        Merchant merchant =  new Merchant(1001,"a direct msg : 岳麓区","岳麓大道");
        rabbitAmqpTemplate.convertAndSend(directExchange,directRoutingKey, merchant);

        rabbitAmqpTemplate.convertAndSend(topicExchange,topicRoutingKey1, "a topic msg : 中电软件园,routingKey:"+topicRoutingKey1);
        rabbitAmqpTemplate.convertAndSend(topicExchange,topicRoutingKey2, "a topic msg : 梅溪湖,routingKey:"+topicRoutingKey2);

        rabbitAmqpTemplate.convertAndSend(fanoutExchange,"", "尖山湖");

        System.out.println("------------------------------");
    }


}
