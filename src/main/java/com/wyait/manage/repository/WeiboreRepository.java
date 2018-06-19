package com.wyait.manage.repository;


import com.wyait.manage.entity.Weibore;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author fz
 * @Date 2018/6/7 10:51
 * 
 */
public interface WeiboreRepository extends JpaRepository<Weibore, String> {

    /**
     * 通过openid查找订单
     * @param
     * @param
     * @return
     */
    Weibore findByWeiboId(String weiboId);
}
