package com.wyait.manage.web;

import com.github.pagehelper.PageHelper;
import com.wyait.manage.entity.Article;
import com.wyait.manage.entity.Weibo;
import com.wyait.manage.entity.WeiboDetail;
import com.wyait.manage.entity.Weibore;
import com.wyait.manage.service.ArticleService;
import com.wyait.manage.service.WeiboService;
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

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ldlood on 2017/8/1.
 */
@Controller
//@RequestMapping("/article")
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/articleList")
    public String toUserList() {
        return "articleList";
    }


    @GetMapping("/article")
    @ResponseBody
    public PageDataResult list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                               @RequestParam("typeName") String type,
                             Map<String, Object> map) {

        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<Article> articlePage = articleService.findListAll(type, pageRequest);

        PageDataResult pdr = new PageDataResult();
        PageHelper.startPage(page, size);
        // 设置获取到的总记录数total：
        pdr.setTotals(new Long(articlePage.getTotalElements()).intValue());
        pdr.setList(articlePage.getContent());
        return pdr;
//
//        map.put("weiboPage", weiboPage);
//        map.put("currentPage", page);
//        map.put("size", size);
//
//        return new ModelAndView("weiboList1", map);

    }




}
