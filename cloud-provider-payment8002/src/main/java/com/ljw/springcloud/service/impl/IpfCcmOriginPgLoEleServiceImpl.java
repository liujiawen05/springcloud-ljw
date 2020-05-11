package com.ljw.springcloud.service.impl;

import com.ljw.springcloud.dao.IpfCcmOriginPgLoEleMapper;
import com.ljw.springcloud.entity.IpfCcmOriginPgLoEle;
import com.ljw.springcloud.service.IpfCcmOriginPgLoEleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/5/11.
 */
@Service
public class IpfCcmOriginPgLoEleServiceImpl implements IpfCcmOriginPgLoEleService {

    @Resource
    private IpfCcmOriginPgLoEleMapper ipfCcmOriginPgLoEleMapper;

    @Override
    public IpfCcmOriginPgLoEle getPaymentById(String id) {
        return ipfCcmOriginPgLoEleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insert(IpfCcmOriginPgLoEle IpfCcmOriginPgLoEle) {
        ipfCcmOriginPgLoEleMapper.insert(IpfCcmOriginPgLoEle);
    }

    @Override
    public void delete(String id) {
        ipfCcmOriginPgLoEleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(IpfCcmOriginPgLoEle IpfCcmOriginPgLoEle) {
        ipfCcmOriginPgLoEleMapper.updateByPrimaryKey(IpfCcmOriginPgLoEle);
    }
}
