package com.lanxin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanxin.bean.*;
import com.lanxin.dao.Maladydao;
import com.lanxin.lombok.Result;
import com.lanxin.lombok.errors;
import com.lanxin.service.KsMaladyService;
import com.lanxin.service.MaladyService;
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
public class MaladyServiceImpl extends ServiceImpl<Maladydao, Malady> implements MaladyService {

    @Autowired
    Maladydao maladydao;

    @Autowired
    KsMaladyService ksMaladyService;

    @Override
    public Result selMalady(Malady malady) {
        PageHelper.startPage(malady.getPage(),malady.getCount());//执行查询前走
        List<Malady> maladys=maladydao.selMalady(malady);
        PageInfo<Malady> pageInfo=new PageInfo<Malady>(maladys);
        if(maladys.size()>0) {
            return Result.ok2(maladys,Integer.parseInt(String.valueOf(pageInfo.getTotal())));
        }else{
            throw new errors(500, "没有查询到疾病");
        }
    }

    @Override
    public Result addMalady(Malady malady) {
        return Result.ok(this.save(malady));
    }

    @Override
    public Result upKMalady(Malady malady) {
        return Result.ok(this.updateById(malady));
    }

    @Override
    public Result deKMalady(Integer oid) {
        QueryWrapper<KsMalady> ksMaladyQueryWrapper=new QueryWrapper<>();
        ksMaladyQueryWrapper.eq("mid",oid);
        List<KsMalady> list = ksMaladyService.list(ksMaladyQueryWrapper);
        if(list.size()<=0){
            return Result.ok(this.removeById(oid));
        }else {
            throw new errors(500, "疾病使用中不能删除");
        }
    }
}
