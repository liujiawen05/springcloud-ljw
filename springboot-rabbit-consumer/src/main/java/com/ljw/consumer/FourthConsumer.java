package com.ljw.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: ljw
 * @Date: 2020/7/25 17:04
 * @Description:
 */
@Component
@PropertySource("classpath:rabbitMqInfo.properties")
@RabbitListener(queues = "${com.ljw.fourthqueue}", containerFactory="rabbitListenerContainerFactory")
public class FourthConsumer {
    @RabbitHandler
    public void process(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {

        System.out.println("Fourth Queue received msg : " + message);
        channel.basicAck(tag,false);
    }
}
