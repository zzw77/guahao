package com.lanxin.controller;


import com.lanxin.bean.Admin;
import com.lanxin.lombok.Result;
import com.lanxin.service.AdminService;
import org.apache.coyote.Response;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/selAdmin")
    @ResponseBody
    public Result selAdmin(@RequestBody Admin admin){//查询管理表
        return adminService.selAdmin(admin);
    }

    @RequestMapping("/addAdmin")
    @ResponseBody
    public Result addAdmin(@RequestBody Admin admin){//添加管理表
        return adminService.addAdmin(admin);
    }

    @RequestMapping("/upAdmin")
    @ResponseBody
    public Result upAdmin(@RequestBody Admin admin){//修改管理表
        return adminService.upAdmin(admin);
    }

    @RequestMapping("/delAdmin")
    @ResponseBody
    public Result delAdmin(Integer oid){//删除管理表
        return adminService.delAdmin(oid);
    }

}
