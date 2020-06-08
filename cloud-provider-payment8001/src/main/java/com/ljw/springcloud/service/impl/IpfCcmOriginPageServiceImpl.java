package com.ljw.springcloud.service.impl;

import com.ljw.springcloud.dao.IpfCcmOriginPageMapper;
import com.ljw.springcloud.entity.IpfCcmOriginPage;
import com.ljw.springcloud.service.IpfCcmOriginPageService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/5/2.
 */
@Service
public class IpfCcmOriginPageServiceImpl implements IpfCcmOriginPageService {

    @Value("${com.ljw.topicexchange}")
    private String topicExchange;

    @Value("${com.ljw.topicroutingkey1}")
    private String topicRoutingKey;

    @Resource
    private IpfCcmOriginPageMapper ipfCcmOriginPageMapper;

//    @Autowired
//    AmqpTemplate rabbitTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;


    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler1")
    public IpfCcmOriginPage getPaymentById(String id) {
        int timeNumber = 3;
//        try {
//            TimeUnit.SECONDS.sleep(timeNumber);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("111");

        for(int i =0;i<10;i++){
            rabbitTemplate.convertAndSend(topicExchange,topicRoutingKey, "title.toJSONString()----"+i);
        }

        return ipfCcmOriginPageMapper.selectByPrimaryKey(id);
    }

    public IpfCcmOriginPage paymentInfo_TimeOutHandler1(String id){
        String str = "线程池:" + Thread.currentThread().getName() + " 8001系统繁忙请稍后再试！！,id:" + id + "\t"+"我哭了！！";
        System.out.println(str);
        return null;
    }

    @Override
    public void insert(IpfCcmOriginPage ipfCcmOriginPage) {
        ipfCcmOriginPageMapper.insert(ipfCcmOriginPage);
    }

    @Override
    public void delete(String id) {
        ipfCcmOriginPageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(IpfCcmOriginPage ipfCcmOriginPage) {
        ipfCcmOriginPageMapper.updateByPrimaryKey(ipfCcmOriginPage);
    }
}
