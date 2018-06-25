package com.wyait.manage.service;

import com.wyait.manage.entity.Article;
import com.wyait.manage.entity.Weibo;
import com.wyait.manage.entity.WeiboDetail;
import com.wyait.manage.entity.Weibore;
import com.wyait.manage.repository.ArticleRepository;
import com.wyait.manage.repository.WeiboDetailRepository;
import com.wyait.manage.repository.WeiboRepository;
import com.wyait.manage.repository.WeiboreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Author fz
 * @Date 2018/6/7 10:58
 */
@Service
@Transactional(transactionManager="jpaTransactionManager")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;


    @Override
    public Page<Article> findListAll(String type, Pageable pageable) {
        Page<Article> orderMasterPage = articleRepository.findByType(type,pageable);
//        List<OrderDTO> orderDTOList = OrderMasterToOrderDTOConverter.convert(orderMasterPage.getContent());
        return new PageImpl<Article>(orderMasterPage.getContent(), pageable, orderMasterPage.getTotalElements());

    }

}
