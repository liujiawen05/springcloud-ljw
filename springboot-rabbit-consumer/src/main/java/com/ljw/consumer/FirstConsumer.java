package com.ljw.consumer;

import com.ljw.entity.Merchant;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: ljw
 * @Date: 2020/7/25 17:04
 * @Description:
 */
@Component
@PropertySource("classpath:rabbitMqInfo.properties")
@RabbitListener(queues = "${com.ljw.firstqueue}", containerFactory="rabbitListenerContainerFactory")
public class FirstConsumer {

    @RabbitHandler
    public void process(@Payload Merchant merchant, Channel channel,@Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("First Queue received msg : " + merchant.getName());
        channel.basicAck(tag,false);
    }

}
