package com.ljw.springcloud.service;

import com.ljw.springcloud.entity.IpfCcmOriginPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/5/11.
 */
@Component
@FeignClient(value = "cloud-provider-hystrix-payment")
public interface IpfCcmOriginPageFeignService {

//    @RequestMapping(value = "/ipfCcmOriginPage/get")
//    public IpfCcmOriginPage getPage(@RequestBody String json);

}
