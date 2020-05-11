package com.ljw.springcloud.service;

import com.ljw.springcloud.entity.IpfCcmOriginPageLayout;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/5/11.
 */
public interface IpfCcmOriginPageLayoutService {

    IpfCcmOriginPageLayout getPaymentById(String id);

    void insert(IpfCcmOriginPageLayout ipfCcmOriginPage);

    void delete(String id);

    void update(IpfCcmOriginPageLayout ipfCcmOriginPage);
}
