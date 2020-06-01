package com.ljw.springcloud.service.impl;

import com.ljw.springcloud.dao.IpfCcmOriginPageMapper;
import com.ljw.springcloud.entity.IpfCcmOriginPage;
import com.ljw.springcloud.service.IpfCcmOriginPageService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/5/2.
 */
@Service
public class IpfCcmOriginPageServiceImpl implements IpfCcmOriginPageService {

    @Resource
    private IpfCcmOriginPageMapper ipfCcmOriginPageMapper;

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enable",value = "true"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    public IpfCcmOriginPage getPaymentById(String id) {
//        int timeNumber = 3;
//        try {
//            TimeUnit.SECONDS.sleep(timeNumber);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("222");
        return ipfCcmOriginPageMapper.selectByPrimaryKey(id);
    }

    public IpfCcmOriginPage paymentInfo_TimeOutHandler(String id){
        String str = "线程池:" + Thread.currentThread().getName() + " 8002系统繁忙请稍后再试！！,id:" + id + "\t"+"。。。！！";
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
