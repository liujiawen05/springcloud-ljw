package com.ljw.springcloud.service;

import com.ljw.springcloud.entity.CommonResult;
import com.ljw.springcloud.entity.IpfCcmOriginPage;
import com.ljw.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/4/10.
 */
@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();

    @RequestMapping(value = "/ipfCcmOriginPage/get")
    public IpfCcmOriginPage getPage(@RequestBody String json);

}
