package com.lanxin.controller;


import com.lanxin.bean.Hospital;
import com.lanxin.bean.Keshi;
import com.lanxin.lombok.Result;
import com.lanxin.service.KeshiService;
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
@RequestMapping("/keshi")
public class KeshiController {

    @Autowired
    KeshiService keshiService;


    @RequestMapping("/selKs")//查询
    @ResponseBody
    public Result selKs(){
        return Result.ok(keshiService.list());
    }


    @RequestMapping("/selKeshi")//查询所有科室 分页
    @ResponseBody
    public Result selKeshi(@RequestBody Keshi keshi){ //查询所有科室信息
        return keshiService.selKeshi(keshi);
    }

    @RequestMapping("/upKeshi")//修改
    @ResponseBody
    public Result upKeshi(@RequestBody Keshi keshi){ //修改
        return keshiService.upKeshi(keshi);
    }

    @RequestMapping("/addKeshi")//添加
    @ResponseBody
    public Result addKeshi(@RequestBody Keshi keshi){ //添加
        return keshiService.addKeshi(keshi);
    }

    @RequestMapping("/delKeshi")//删除
    @ResponseBody
    public Result delKeshi(Integer oid){ //删除
        return keshiService.deKeshi(oid);
    }


}
