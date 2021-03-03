package com.lanxin.controller;


import com.lanxin.bean.Keshi;
import com.lanxin.bean.Malady;
import com.lanxin.lombok.Result;
import com.lanxin.service.MaladyService;
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
@RequestMapping("/malady")
public class MaladyController {

    @Autowired
    MaladyService maladyService;

    @RequestMapping("/selMalady")//查询所有科疾病 //组合分页查询
    @ResponseBody
    public Result selMalady(@RequestBody Malady malady){
        return maladyService.selMalady(malady);
    }

    @RequestMapping("/upMalady")//修改
    @ResponseBody
    public Result upKMalady(@RequestBody Malady malady){ //修改
        return maladyService.upKMalady(malady);
    }

    @RequestMapping("/addMalady")//添加
    @ResponseBody
    public Result addMalady(@RequestBody Malady malady){ //添加
        return maladyService.addMalady(malady);
    }

    @RequestMapping("/deKMalady")//删除
    @ResponseBody
    public Result deKMalady(Integer oid){ //删除
        return maladyService.deKMalady(oid);
    }



}
