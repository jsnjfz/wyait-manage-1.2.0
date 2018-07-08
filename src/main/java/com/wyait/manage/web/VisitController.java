package com.wyait.manage.web;

import com.github.pagehelper.PageHelper;
import com.wyait.manage.entity.Article;
import com.wyait.manage.entity.Visit;
import com.wyait.manage.service.ArticleService;
import com.wyait.manage.service.VisitService;
import com.wyait.manage.utils.PageDataResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Ldlood on 2017/8/1.
 */
@Controller
//@RequestMapping("/article")
@Slf4j
public class VisitController {

    @Autowired
    private VisitService visitService;

    @RequestMapping("/visitList")
    public String toUserList() {
        return "visitList";
    }


    @GetMapping("/visit")
    @ResponseBody
    public PageDataResult list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {

        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<Visit> visitPage = visitService.findListAll(pageRequest);

        PageDataResult pdr = new PageDataResult();
        PageHelper.startPage(page, size);
        // 设置获取到的总记录数total：
        pdr.setTotals(new Long(visitPage.getTotalElements()).intValue());
        pdr.setList(visitPage.getContent());
        return pdr;

    }




}
