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
@Table(name = "weibo_detailall")
public class WeiboDetail {
    @Id
    private String id;
    private String userId;
    private String weiboContent;
    private String weiboReContent;
    private String weiboPlace;
    private String publishTime;
    private String publishTool;
    private String upNum;
    private String retweetNum;
    private String commentNum;
    private String reLink;
    private String weiboId;
    private int yuanchuang;
}
