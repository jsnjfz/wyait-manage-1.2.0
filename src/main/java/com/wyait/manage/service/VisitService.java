package com.wyait.manage.service;

import com.wyait.manage.entity.Article;
import com.wyait.manage.entity.Visit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author fz
 * @Date 2018/6/7 10:56
 */
public interface VisitService {
    /**
     * 根据openid查询订单列表.
     */
    Page<Visit> findListAll(Pageable pageable);

//    Page<Article> findListAll(Pageable pageable);
//
//    Article findOne(String weiboId);
}
