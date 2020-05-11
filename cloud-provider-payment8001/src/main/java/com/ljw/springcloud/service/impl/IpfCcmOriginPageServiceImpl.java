package com.ljw.springcloud.service.impl;

import com.ljw.springcloud.dao.IpfCcmOriginPageMapper;
import com.ljw.springcloud.entity.IpfCcmOriginPage;
import com.ljw.springcloud.service.IpfCcmOriginPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/5/2.
 */
@Service
public class IpfCcmOriginPageServiceImpl implements IpfCcmOriginPageService {

    @Resource
    private IpfCcmOriginPageMapper ipfCcmOriginPageMapper;

    @Override
    public IpfCcmOriginPage getPaymentById(String id) {
        return ipfCcmOriginPageMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insert(IpfCcmOriginPage ipfCcmOriginPage) {
        ipfCcmOriginPageMapper.insert(ipfCcmOriginPage);
    }

    @Override
    public void delete(String id) {
        ipfCcmOriginPageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(IpfCcmOriginPage ipfCcmOriginPage) {
        ipfCcmOriginPageMapper.updateByPrimaryKey(ipfCcmOriginPage);
    }
}
