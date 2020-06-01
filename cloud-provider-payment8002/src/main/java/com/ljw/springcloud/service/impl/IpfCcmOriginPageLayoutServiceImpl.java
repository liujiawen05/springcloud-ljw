package com.ljw.springcloud.service.impl;

import com.ljw.springcloud.dao.IpfCcmOriginPageLayoutMapper;
import com.ljw.springcloud.entity.IpfCcmOriginPageLayout;
import com.ljw.springcloud.service.IpfCcmOriginPageLayoutService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/5/11.
 */
@Service
public class IpfCcmOriginPageLayoutServiceImpl implements IpfCcmOriginPageLayoutService {

    @Resource
    private IpfCcmOriginPageLayoutMapper ipfCcmOriginPageLayoutMapper;

    @Override
    public IpfCcmOriginPageLayout getPaymentById(String id) {
        return ipfCcmOriginPageLayoutMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insert(IpfCcmOriginPageLayout ipfCcmOriginPage) {
        ipfCcmOriginPageLayoutMapper.insert(ipfCcmOriginPage);
    }

    @Override
    public void delete(String id) {
        ipfCcmOriginPageLayoutMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(IpfCcmOriginPageLayout ipfCcmOriginPage) {
        ipfCcmOriginPageLayoutMapper.updateByPrimaryKey(ipfCcmOriginPage);
    }
}
