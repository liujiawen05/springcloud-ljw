package com.ljw.springcloud.dao;

import com.ljw.springcloud.entity.IpfCcmOriginPageLayout;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IpfCcmOriginPageLayoutMapper {
    int deleteByPrimaryKey(String ipfCcmOriginPageLayoutId);

    int insert(IpfCcmOriginPageLayout record);

    int insertSelective(IpfCcmOriginPageLayout record);

    IpfCcmOriginPageLayout selectByPrimaryKey(String ipfCcmOriginPageLayoutId);

    int updateByPrimaryKeySelective(IpfCcmOriginPageLayout record);

    int updateByPrimaryKey(IpfCcmOriginPageLayout record);
}