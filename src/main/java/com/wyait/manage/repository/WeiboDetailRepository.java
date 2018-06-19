package com.wyait.manage.repository;


import com.wyait.manage.entity.WeiboDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author fz
 * @Date 2018/6/7 10:51
 * 
 */
public interface WeiboDetailRepository extends JpaRepository<WeiboDetail, String> {

    /**
     * 通过openid查找订单
     * @param
     * @param pageable
     * @return
     */
    Page<WeiboDetail> findDistinctByUserId(String userId, Pageable pageable);


}

