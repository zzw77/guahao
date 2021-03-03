package com.lanxin.controller;


import com.lanxin.bean.Admin;
import com.lanxin.bean.Affiche;
import com.lanxin.lombok.Result;
import com.lanxin.service.AfficheService;
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
@RequestMapping("/affiche")
public class AfficheController {

    @Autowired
    AfficheService afficheService;

    @RequestMapping("/selAffiche")
    @ResponseBody
    public Result selAffiche(@RequestBody Affiche affiche){//组合查询公告表
        return afficheService.selAffiche(affiche);
    }

    @RequestMapping("/addAffiche")
    @ResponseBody
    public Result addAffiche(@RequestBody Affiche affiche){//添加公告表
        return afficheService.addAffiche(affiche);
    }

    @RequestMapping("/upAAffiche")
    @ResponseBody
    public Result upAAffiche(@RequestBody Affiche affiche){//修改公告表
        return afficheService.upAAffiche(affiche);
    }

    @RequestMapping("/delAffiche")
    @ResponseBody
    public Result delAffiche(Integer oid){//删除管理表
        return afficheService.delAffiche(oid);
    }


}
