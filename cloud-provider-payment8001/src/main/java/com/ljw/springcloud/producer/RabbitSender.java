package com.ljw.springcloud.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: qingshan
 * @Date: 2018/10/20 16:52
 * @Description: 咕泡学院，只为更好的你
 */
@Component
@PropertySource("classpath:rabbitMqConfig.properties")
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
    RabbitTemplate rabbitTemplate;

    public void send() throws JsonProcessingException {
//        Merchant merchant =  new Merchant(1001,"a direct msg : 中原镖局","汉中省解放路266号");
//        gupaoTemplate.convertAndSend(directExchange,directRoutingKey, merchant);

        rabbitTemplate.convertAndSend(topicExchange,topicRoutingKey1, "a topic msg : shanghai.gupao.teacher");
        rabbitTemplate.convertAndSend(topicExchange,topicRoutingKey2, "a topic msg : changsha.gupao.student");

        // 发送JSON字符串
        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(merchant);
        System.out.println("json");
        rabbitTemplate.convertAndSend(fanoutExchange,"", "json");
    }


}
