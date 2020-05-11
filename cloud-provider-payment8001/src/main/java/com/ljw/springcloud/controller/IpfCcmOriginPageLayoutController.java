package com.ljw.springcloud.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ljw.springcloud.entity.IpfCcmOriginPage;
import com.ljw.springcloud.entity.IpfCcmOriginPageLayout;
import com.ljw.springcloud.service.IpfCcmOriginPageLayoutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/5/2.
 */
@RestController
@Slf4j
public class IpfCcmOriginPageLayoutController {

    @Resource
    private IpfCcmOriginPageLayoutService ipfCcmOriginPageLayoutService;

    @Value("${server.port}")
    private String port;


    @RequestMapping(value = "/ipfCcmOriginPageLayout/get")
    public IpfCcmOriginPageLayout getPage(@RequestBody String json){

        JSONObject jsonObject = JSONUtil.parseObj(json);
        String id = (String) jsonObject.get("id");

        System.out.println("当前端口号是:"+port);

        return ipfCcmOriginPageLayoutService.getPaymentById(id);
    }

    @RequestMapping(value = "/ipfCcmOriginPageLayout/save")
    public void save(@RequestBody String json){

        JSONObject jsonObject = JSONUtil.parseObj(json);
        IpfCcmOriginPageLayout ipfCcmOriginPageLayout= JSONUtil.toBean(json,IpfCcmOriginPageLayout.class);

        System.out.println("当前端口号是:"+port);

        ipfCcmOriginPageLayoutService.insert(ipfCcmOriginPageLayout);
    }

    @RequestMapping(value = "/ipfCcmOriginPageLayout/delete")
    public void delete(@RequestBody String json){

        JSONObject jsonObject = JSONUtil.parseObj(json);
        String id = (String) jsonObject.get("id");

        System.out.println("当前端口号是:"+port);

        ipfCcmOriginPageLayoutService.delete(id);
    }

    @RequestMapping(value = "/ipfCcmOriginPageLayout/update")
    public void update(@RequestBody String json){

        JSONObject jsonObject = JSONUtil.parseObj(json);
        IpfCcmOriginPageLayout ipfCcmOriginPageLayout= JSONUtil.toBean(json,IpfCcmOriginPageLayout.class);

        System.out.println("当前端口号是:"+port);

        ipfCcmOriginPageLayoutService.update(ipfCcmOriginPageLayout);
    }

}
