package com.lanxin.controller;


import com.lanxin.bean.Keshi;
import com.lanxin.bean.Zhuanke;
import com.lanxin.lombok.Result;
import com.lanxin.service.ZhuankeService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
@Controller
@RequestMapping("/zhuanke")
public class ZhuankeController {

    @Autowired
    ZhuankeService zhuankeService;


    @RequestMapping("/selZk")//查询
    @ResponseBody
    public Result selZk(){
        return Result.ok(zhuankeService.list());
    }


    @RequestMapping("/selZhuanke")//查询所有和模糊分页查询
    @ResponseBody
    public Result selZhuanke(@RequestBody Zhuanke zhuanke){//
        return zhuankeService.selZhuanke(zhuanke);
    }

    @RequestMapping("/upKZhuanke")//修改
    @ResponseBody
    public Result upKZhuanke(@RequestBody Zhuanke zhuanke){ //修改
        return zhuankeService.upKZhuanke(zhuanke);
    }

    @RequestMapping("/addZhuanke")//添加
    @ResponseBody
    public Result addZhuanke(@RequestBody Zhuanke zhuanke){ //添加
        return zhuankeService.addZhuanke(zhuanke);
    }

    @RequestMapping("/deKZhuanke")//删除
    @ResponseBody
    public Result deKZhuanke(Integer oid){ //删除 1.专科id
        return zhuankeService.deKZhuanke(oid);
    }


    @RequestMapping("/zkAll")//专科科室维护
    @ResponseBody
    public Result zkAll(Integer hosid){
        return zhuankeService.zkAll(hosid);
    }
}
