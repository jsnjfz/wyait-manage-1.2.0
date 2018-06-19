package com.wyait.manage.service;

import com.wyait.manage.entity.Weibo;
import com.wyait.manage.entity.WeiboDetail;
import com.wyait.manage.entity.Weibore;
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
public class WeiboServiceImpl implements WeiboService {
    @Autowired
    WeiboRepository weiboRepository;

    @Autowired
    WeiboreRepository weiboreRepository;

    @Autowired
    WeiboDetailRepository weiboDetailRepository;

    @Override
    public Page<WeiboDetail> findList(String userId, Pageable pageable) {
        Page<WeiboDetail> weiboDetailPage = weiboDetailRepository.findDistinctByUserId(userId, pageable);
        System.out.println(weiboDetailPage);

        return new PageImpl<WeiboDetail>(weiboDetailPage.getContent(), pageable, weiboDetailPage.getTotalElements());
    }

    @Override
    public Page<Weibo> findListAll(Pageable pageable) {
        Page<Weibo> orderMasterPage = weiboRepository.findAll(pageable);
//        List<OrderDTO> orderDTOList = OrderMasterToOrderDTOConverter.convert(orderMasterPage.getContent());
        return new PageImpl<Weibo>(orderMasterPage.getContent(), pageable, orderMasterPage.getTotalElements());

    }

    @Override
    public Weibore findOne(String weiboId) {
        Weibore  weibore = weiboreRepository.findByWeiboId(weiboId);
//        List<OrderDTO> orderDTOList = OrderMasterToOrderDTOConverter.convert(orderMasterPage.getContent());
        return weibore;

    }
}
