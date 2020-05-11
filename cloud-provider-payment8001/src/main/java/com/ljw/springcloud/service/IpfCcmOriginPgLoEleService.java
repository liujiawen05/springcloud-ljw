package com.ljw.springcloud.service;

import com.ljw.springcloud.entity.IpfCcmOriginPgLoEle;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/5/11.
 */
public interface IpfCcmOriginPgLoEleService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    IpfCcmOriginPgLoEle getPaymentById(String id);

    void insert(IpfCcmOriginPgLoEle IpfCcmOriginPgLoEle);

    void delete(String id);

    void update(IpfCcmOriginPgLoEle IpfCcmOriginPgLoEle);
}
