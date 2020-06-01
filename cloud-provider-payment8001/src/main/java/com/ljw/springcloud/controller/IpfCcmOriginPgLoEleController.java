package com.ljw.springcloud.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ljw.springcloud.entity.IpfCcmOriginPgLoEle;
import com.ljw.springcloud.service.IpfCcmOriginPgLoEleService;
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
public class IpfCcmOriginPgLoEleController {

    @Resource
    private IpfCcmOriginPgLoEleService ipfCcmOriginPgLoEleService;

    @Value("${server.port}")
    private String port;


    @RequestMapping(value = "/ipfCcmOriginPgLoEle/get")
    public IpfCcmOriginPgLoEle getPage(@RequestBody String json) {

        JSONObject jsonObject = JSONUtil.parseObj(json);
        String id = (String) jsonObject.get("id");

        System.out.println("当前端口号是:" + port);

        return ipfCcmOriginPgLoEleService.getPaymentById(id);
    }

    @RequestMapping(value = "/ipfCcmOriginPgLoEle/save")
    public void save(@RequestBody String json) {

        JSONObject jsonObject = JSONUtil.parseObj(json);
        IpfCcmOriginPgLoEle ipfCcmOriginPgLoEle = JSONUtil.toBean(json, IpfCcmOriginPgLoEle.class);

        System.out.println("当前端口号是:" + port);

        ipfCcmOriginPgLoEleService.insert(ipfCcmOriginPgLoEle);
    }

    @RequestMapping(value = "/ipfCcmOriginPgLoEle/delete")
    public void delete(@RequestBody String json) {

        JSONObject jsonObject = JSONUtil.parseObj(json);
        String id = (String) jsonObject.get("id");

        System.out.println("当前端口号是:" + port);

        ipfCcmOriginPgLoEleService.delete(id);
    }

    @RequestMapping(value = "/ipfCcmOriginPgLoEle/update")
    public void update(@RequestBody String json) {

        JSONObject jsonObject = JSONUtil.parseObj(json);
        IpfCcmOriginPgLoEle ipfCcmOriginPgLoEle = JSONUtil.toBean(json, IpfCcmOriginPgLoEle.class);

        System.out.println("当前端口号是:" + port);

        ipfCcmOriginPgLoEleService.update(ipfCcmOriginPgLoEle);
    }

}
