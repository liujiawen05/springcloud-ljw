package com.ljw.springcloud.dao;

import com.ljw.springcloud.entity.IpfCcmOriginPage;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface IpfCcmOriginPageMapper {
    int deleteByPrimaryKey(String ipfCcmOriginPageId);

    int insert(IpfCcmOriginPage record);

    int insertSelective(IpfCcmOriginPage record);

    IpfCcmOriginPage selectByPrimaryKey(String ipfCcmOriginPageId);

    int updateByPrimaryKeySelective(IpfCcmOriginPage record);

    int updateByPrimaryKey(IpfCcmOriginPage record);
}