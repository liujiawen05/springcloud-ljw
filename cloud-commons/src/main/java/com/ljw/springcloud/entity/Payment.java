package com.ljw.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/4/7.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    //测试分支提交
    private Long id;

    private String serial;

}
