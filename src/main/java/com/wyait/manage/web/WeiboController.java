package com.wyait.manage.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wyait.manage.entity.UserRoleDTO;
import com.wyait.manage.entity.Weibo;
import com.wyait.manage.entity.WeiboDetail;
import com.wyait.manage.entity.Weibore;
import com.wyait.manage.pojo.Role;
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
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ldlood on 2017/8/1.
 */
@Controller
@RequestMapping("/weibo")
@Slf4j
public class WeiboController {

    @Autowired
    private WeiboService weiboService;

    @RequestMapping("/weiboList")
    public String toUserList() {
        return "/weiboList";
    }

    @RequestMapping("/weiboDetail")
    public String weiboDetail() {
        return "/weiboDetail";
    }


    @GetMapping("/list")
    @ResponseBody
    public PageDataResult list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {

        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<Weibo> weiboPage = weiboService.findListAll(pageRequest);

        PageDataResult pdr = new PageDataResult();
        PageHelper.startPage(page, size);
        // 设置获取到的总记录数total：
        pdr.setTotals(new Long(weiboPage.getTotalElements()).intValue());
        pdr.setList(weiboPage.getContent());
        return pdr;
//
//        map.put("weiboPage", weiboPage);
//        map.put("currentPage", page);
//        map.put("size", size);
//
//        return new ModelAndView("weiboList1", map);

    }



    /**
     * 订单详情
     * @param
     * @param map
     * @return
     */
    @GetMapping("/detail")
    @ResponseBody
    public PageDataResult detail(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
                               @RequestParam(value = "size", defaultValue = "10", required = false) Integer size,
                               @RequestParam("userId") String userId,
                               Map<String, Object> map) {
        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<WeiboDetail> weiboDetailPage = weiboService.findList(userId,pageRequest);


        PageDataResult pdr = new PageDataResult();
        PageHelper.startPage(page, size);
        // 设置获取到的总记录数total：
        pdr.setTotals(new Long(weiboDetailPage.getTotalElements()).intValue());
        pdr.setList(weiboDetailPage.getContent());
        return pdr;

//
//        map.put("weiboDetailPage", weiboDetailPage);
//        map.put("userId", userId);
//        map.put("currentPage", page);
//        map.put("size", size);
//
//        return new ModelAndView("weiboDetail", map);
    }

    /**
     * 订单详情
     * @param
     * @param map
     * @return
     */
    @GetMapping("/quanwen")
    @ResponseBody
    public Map<String, Object> detail(@RequestParam("weiboId") String weiboId) {

        Map<String, Object> map = new HashMap<>();
        Weibore weibore = weiboService.findOne(weiboId);
        map.put("weibore", weibore);
        map.put("msg", "ok");

        return map;
    }


}
