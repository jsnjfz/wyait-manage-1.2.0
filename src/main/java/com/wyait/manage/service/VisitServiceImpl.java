package com.wyait.manage.service;

import com.wyait.manage.entity.Article;
import com.wyait.manage.entity.Visit;
import com.wyait.manage.repository.ArticleRepository;
import com.wyait.manage.repository.VisitRepository;
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
public class VisitServiceImpl implements VisitService {
    @Autowired
    VisitRepository visitRepository;


    @Override
    public Page<Visit> findListAll(Pageable pageable) {
        Page<Visit> visitPage = visitRepository.findAll(pageable);
//        List<OrderDTO> orderDTOList = OrderMasterToOrderDTOConverter.convert(orderMasterPage.getContent());
        return new PageImpl<Visit>(visitPage.getContent(), pageable, visitPage.getTotalElements());

    }

}
