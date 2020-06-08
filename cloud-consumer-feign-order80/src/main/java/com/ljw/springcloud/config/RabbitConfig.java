package com.ljw.springcloud.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/5/26.
 */
@Configuration
@PropertySource("classpath:rabbitMqConfig.properties")
public class RabbitConfig {

    @Value("${com.ljw.firstqueue}")
    private String firstQueue;

    @Value("${com.ljw.secondqueue}")
    private String secondQueue;

    @Value("${com.ljw.thirdqueue}")
    private String thirdQueue;

    @Value("${com.ljw.fourthqueue}")
    private String fourthQueue;

    @Value("${com.ljw.directexchange}")
    private String directExchange;

    @Value("${com.ljw.topicexchange}")
    private String topicExchange;

    @Value("${com.ljw.fanoutexchange}")
    private String fanoutExchange;

    //创建队列
    @Bean("vipFirstQueue")
    public Queue getFirstQueue(){
        return new Queue(firstQueue);
    };

    @Bean("vipSecondQueue")
    public Queue getSecondQueue(){
        return new Queue(secondQueue);
    }

    @Bean("vipThirdQueue")
    public  Queue getThirdQueue(){
        return  new Queue(thirdQueue);
    }

    @Bean("vipFourthQueue")
    public  Queue getFourthQueue(){
        return  new Queue(fourthQueue);
    }

    // 创建三个交换机
    @Bean("vipDirectExchange")
    public DirectExchange getDirectExchange(){
        return new DirectExchange(directExchange);
    }

    @Bean("vipTopicExchange")
    public TopicExchange getTopicExchange(){
        return new TopicExchange(topicExchange);
    }

    @Bean("vipFanoutExchange")
    public FanoutExchange getFanoutExchange(){
        return new FanoutExchange(fanoutExchange);
    }

    // 定义四个绑定关系
//    @Bean
//    public Binding bindFirst(@Qualifier("vipFirstQueue") Queue queue, @Qualifier("vipDirectExchange") DirectExchange exchange){
//        return BindingBuilder.bind(queue).to(exchange).with("gupao.best");
//    }

    @Bean
    public Binding bindFirst(@Qualifier("vipFirstQueue") Queue queue, @Qualifier("vipTopicExchange") TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("gupao.best");
    }

    @Bean
    public Binding bindSecond(@Qualifier("vipSecondQueue") Queue queue, @Qualifier("vipTopicExchange") TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("*.gupao.*");
    }

    @Bean
    public Binding bindThird(@Qualifier("vipThirdQueue") Queue queue, @Qualifier("vipTopicExchange") TopicExchange exchange){
//        return BindingBuilder.bind(queue).to(exchange);
        return BindingBuilder.bind(queue).to(exchange).with("*.gupao.*");
    }

    public Binding bindFourth(@Qualifier("vipFourthQueue") Queue queue,@Qualifier("vipTopicExchange") FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }

    /**
     * 在消费端转换JSON消息
     * 监听类都要加上containerFactory属性
     * @param connectionFactory
     * @return
     */
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        factory.setAutoStartup(true);
        return factory;
    }

}
