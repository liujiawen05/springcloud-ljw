package com.ljw.springcloud.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ljw.springcloud.entity.IpfCcmOriginPage;
import com.ljw.springcloud.service.IpfCcmOriginPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class IpfCcmOriginPageController {

    @Resource
    private IpfCcmOriginPageService ipfCcmOriginPageService;

    @Value("${server.port}")
    private String port;

    @Autowired
    public StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/ipfCcmOriginPage/get")
    public IpfCcmOriginPage getPage(@RequestBody String json){

        JSONObject jsonObject = JSONUtil.parseObj(json);
        String id = (String) jsonObject.get("id");

        System.out.println("当前端口号是:"+port);

        return ipfCcmOriginPageService.getPaymentById(id);
    }

    @RequestMapping(value = "/ipfCcmOriginPage/save")
    public void save(@RequestBody String json){

        JSONObject jsonObject = JSONUtil.parseObj(json);
        IpfCcmOriginPage ipfCcmOriginPage= JSONUtil.toBean(json,IpfCcmOriginPage.class);

        System.out.println("当前端口号是:"+port);

        ipfCcmOriginPageService.insert(ipfCcmOriginPage);
    }

    @RequestMapping(value = "/ipfCcmOriginPage/delete")
    public void delete(@RequestBody String json){

        JSONObject jsonObject = JSONUtil.parseObj(json);
        String id = (String) jsonObject.get("id");

        System.out.println("当前端口号是:"+port);

        ipfCcmOriginPageService.delete(id);
    }

    @RequestMapping(value = "/ipfCcmOriginPage/update")
    public void update(@RequestBody String json){

        JSONObject jsonObject = JSONUtil.parseObj(json);
        IpfCcmOriginPage ipfCcmOriginPage= JSONUtil.toBean(json,IpfCcmOriginPage.class);

        System.out.println("当前端口号是:"+port);

        ipfCcmOriginPageService.update(ipfCcmOriginPage);
    }

}
