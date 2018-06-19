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
@Table(name = "weibo")
public class Weibo {
    /**
     * 订单id.
     */
    @Id
    private int id;

    private String userId;

    /**
     * 买家名字.
     */
    private String commentScreenName;

    /**
     * 买家手机号.
     */
    private String commentCont;

    /**
     * 买家地址.
     */
    private String createTime;


}
