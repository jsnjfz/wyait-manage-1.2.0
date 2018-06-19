package com.wyait.manage.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author fz
 * @Date 2018/6/7 10:37
 */

@Entity
@Data
@Table(name = "weibore")
public class Weibore {
    /**
     * 订单id.
     */
    @Id
    private int id;

    private String reLink;

    /**
     * 买家名字.
     */
    private String weiboContent;

    /**
     * 买家手机号.
     */
    private String weiboId;



}
