package com.lanxin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanxin.bean.Users;
import com.lanxin.dao.Usersdao;
import com.lanxin.lombok.Result;
import com.lanxin.lombok.errors;
import com.lanxin.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
@Service
public class UsersServiceImpl extends ServiceImpl<Usersdao, Users> implements UsersService {

    @Autowired
    Usersdao usersdao;

    @Override
    public Result selUser(Users user) {
        PageHelper.startPage(user.getPage(),user.getCount());//执行查询前走
        List<Users> users=usersdao.selUser(user);
        PageInfo<Users> pageInfo=new PageInfo<Users>(users);

        if(users.size()>0) {
            return Result.ok2(users,Integer.parseInt(String.valueOf(pageInfo.getTotal())));
        }else{
            throw new errors(500, "没有查询到用户");
        }
    }

    @Override
    public Result addUser(Users user) {
        return Result.ok(this.save(user));
    }

    @Override
    public Result upUser(Users user) {
        return Result.ok(this.updateById(user));
    }

    @Override
    public Result delUser(Integer oid) {
        return null;
    }
}
