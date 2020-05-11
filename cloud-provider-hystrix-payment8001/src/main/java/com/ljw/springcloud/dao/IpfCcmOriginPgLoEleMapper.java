package com.ljw.springcloud.dao;

import com.ljw.springcloud.entity.IpfCcmOriginPgLoEle;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IpfCcmOriginPgLoEleMapper {
    int deleteByPrimaryKey(String ipfCcmOrPgLoEleId);

    int insert(IpfCcmOriginPgLoEle record);

    int insertSelective(IpfCcmOriginPgLoEle record);

    IpfCcmOriginPgLoEle selectByPrimaryKey(String ipfCcmOrPgLoEleId);

    int updateByPrimaryKeySelective(IpfCcmOriginPgLoEle record);

    int updateByPrimaryKey(IpfCcmOriginPgLoEle record);
}