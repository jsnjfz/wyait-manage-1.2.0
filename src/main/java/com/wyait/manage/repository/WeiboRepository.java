package com.wyait.manage.repository;


import com.wyait.manage.entity.Weibo;
import com.wyait.manage.entity.WeiboDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author fz
 * @Date 2018/6/7 10:51
 * 
 */
public interface WeiboRepository extends JpaRepository<Weibo, String> {

    /**
     * 通过openid查找订单
     * @param
     * @param pageable
     * @return
     */
    Page<WeiboDetail> findDistinctByUserId(String userId, Pageable pageable);
}
