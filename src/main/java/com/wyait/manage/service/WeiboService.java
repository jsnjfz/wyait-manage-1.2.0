package com.wyait.manage.service;

import com.wyait.manage.entity.Weibo;
import com.wyait.manage.entity.WeiboDetail;
import com.wyait.manage.entity.Weibore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author fz
 * @Date 2018/6/7 10:56
 */
public interface WeiboService {
    /**
     * 根据openid查询订单列表.
     */
    Page<WeiboDetail> findList(String userId, Pageable pageable);

    Page<Weibo> findListAll(Pageable pageable);

    Weibore findOne(String weiboId);
}
