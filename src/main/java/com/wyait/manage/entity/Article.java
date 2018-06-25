package com.wyait.manage.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @Author fz
 * @Date 2018/6/7 10:37
 */

@Entity
@Data
@Table(name = "article")
public class Article {
    @Id
    private int id;

    private String title;

    private String content;

    private String type;

    private String url;

}
