package com.lanxin.controller;


import com.lanxin.bean.Users;
import com.lanxin.lombok.Result;
import com.lanxin.service.UsersService;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.catalina.User;
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
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @RequestMapping("/selUsers")
    @ResponseBody //组合分页查询用户
    public Result selUsers(@RequestBody Users users){
        return usersService.selUser(users);
    }

    @RequestMapping("/addUsers")
    @ResponseBody //添加
    public Result addUsers(@RequestBody Users users){
        return usersService.addUser(users);
    }
    @RequestMapping("/upUsers")
    @ResponseBody //修改
    public Result upUsers(@RequestBody Users users){
        return usersService.upUser(users);
    }

    @RequestMapping("/delUsers")
    @ResponseBody //删除
    public Result delUsers(Integer oid){
        return usersService.delUser(oid);
    }


}
