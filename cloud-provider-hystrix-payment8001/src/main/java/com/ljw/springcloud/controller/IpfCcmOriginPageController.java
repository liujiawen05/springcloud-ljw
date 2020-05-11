package com.ljw.springcloud.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ljw.springcloud.entity.IpfCcmOriginPage;
import com.ljw.springcloud.service.IpfCcmOriginPageService;
import com.ljw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/5/2.
 */
@RestController
@Slf4j
public class IpfCcmOriginPageController {

    @Resource
    private IpfCcmOriginPageService ipfCcmOriginPageService;

    @Resource
    private PaymentService paymentService;

    @RequestMapping(value = "/ipfCcmOriginPage/get")
    public IpfCcmOriginPage getPage(@RequestBody String json){
        JSONObject jsonObject = JSONUtil.parseObj(json);
        String id = (String) jsonObject.get("id");

        return ipfCcmOriginPageService.getPaymentById(id);
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix1/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*****result:" + result);
        return result;

    }


}
