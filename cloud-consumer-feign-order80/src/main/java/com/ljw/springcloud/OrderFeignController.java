package com.ljw.springcloud;

import com.ljw.springcloud.entity.*;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/4/10.
 */
@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @Resource
    private IpfCcmOriginPageFeignService ipfCcmOriginPageFeignService;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        CommonResult<Payment> paymentById = paymentFeignService.getPaymentById(id);
        return paymentById;
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //open-feign-ribbon,客户端默认等待一秒钟
        return paymentFeignService.paymentFeignTimeout();
    }

    @GetMapping(value = "/consumer/ipfCcmOriginPage/get")
    public IpfCcmOriginPage getIpfCcmOriginPage(@RequestBody String json) {
        //获取服务中的实例列表
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");


//        JSONObject jsonObject = JSONUtil.parseObj(json);
//        String id = (String) jsonObject.get("id");

        IpfCcmOriginPage ipfCcmOriginPage = paymentFeignService.getPage(json);
        return ipfCcmOriginPage;
    }

    @GetMapping(value = "/consumer/ipfCcmOriginPageLayout/get")
    public IpfCcmOriginPageLayout getIpfCcmOriginPageLayout(@RequestBody String json) {
        //获取服务中的实例列表
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");


//        JSONObject jsonObject = JSONUtil.parseObj(json);
//        String id = (String) jsonObject.get("id");

        IpfCcmOriginPageLayout ipfCcmOriginPageLayout = paymentFeignService.getPageLayout(json);
        return ipfCcmOriginPageLayout;
    }

    @GetMapping(value = "/consumer/ipfCcmOriginPgLoEle/get")
    public IpfCcmOriginPgLoEle getIpfCcmOriginPgLoEle(@RequestBody String json) {
        //获取服务中的实例列表
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");


//        JSONObject jsonObject = JSONUtil.parseObj(json);
//        String id = (String) jsonObject.get("id");

        IpfCcmOriginPgLoEle ipfCcmOriginPgLoEle = paymentFeignService.getPageLayoutElement(json);
        return ipfCcmOriginPgLoEle;
    }
}
