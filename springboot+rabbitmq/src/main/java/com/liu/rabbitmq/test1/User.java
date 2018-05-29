package com.liu.rabbitmq.test1;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 刘仁楠
 * @date 2018/5/28 14:23
 */
@Data
public class User implements Serializable{

    private static final long serialVersionUID = -7856879762301422465L;

    private String Name;

    private String Sex;
}
