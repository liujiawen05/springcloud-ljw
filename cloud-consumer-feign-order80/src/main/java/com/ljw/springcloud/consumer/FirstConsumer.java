package com.ljw.springcloud.consumer;

import com.ljw.springcloud.entity.IpfCcmOriginPage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @Author: qingshan
 * @Date: 2018/10/20 17:04
 * @Description: 咕泡学院，只为更好的你
 */
@Component
@PropertySource("classpath:rabbitMqConfig.properties")
@RabbitListener(queues = "${com.ljw.firstqueue}", containerFactory="rabbitListenerContainerFactory")
public class FirstConsumer {

//    @RabbitHandler
//    public void process(@Payload IpfCcmOriginPage ipfCcmOriginPage){
//        System.out.println("First Queue received msg : " + ipfCcmOriginPage.getPageName());
//    }

    @RabbitHandler
    public void process(@Payload String s){
        System.out.println("First Queue received msg : " );
    }

}
