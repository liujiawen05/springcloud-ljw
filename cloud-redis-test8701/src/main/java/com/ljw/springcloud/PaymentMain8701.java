package com.ljw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/5/13.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8701 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8701.class);
    }
}
