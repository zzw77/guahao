package com.lanxin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lanxin.bean.Admin;
import com.lanxin.dao.Admindao;
import com.lanxin.lombok.Result;
import com.lanxin.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
@Service
public class AdminServiceImpl extends ServiceImpl<Admindao, Admin> implements AdminService {

    @Override
    public Result selAdmin(Admin admin) {
        QueryWrapper<Admin> wrapper=new QueryWrapper<>();
        wrapper.eq("username",admin.getUsername());
        wrapper.eq("password",admin.getPassword());

        Admin admin2=this.getOne(wrapper);
        if(admin2==null){
            return Result.ok(false);
        }else{
            return Result.ok(true);
        }

    }

    @Override
    public Result addAdmin(Admin admin) {
        return Result.ok(this.save(admin));
    }

    @Override
    public Result upAdmin(Admin admin) {

        return Result.ok(this.updateById(admin));
    }

    @Override
    public Result delAdmin(Integer oid) {
        return Result.ok(this.removeById(oid));
    }
}
