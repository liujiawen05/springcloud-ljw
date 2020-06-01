package com.ljw.springcloud;

import com.ljw.springcloud.entity.IpfCcmOriginPage;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/5/2.
 */
public interface IpfCcmOriginPageService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    IpfCcmOriginPage getPaymentById(String id);

    void insert(IpfCcmOriginPage ipfCcmOriginPage);

    void delete(String id);

    void update(IpfCcmOriginPage ipfCcmOriginPage);

}
