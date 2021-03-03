package com.lanxin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanxin.bean.*;
import com.lanxin.dao.Keshidao;
import com.lanxin.lombok.Result;
import com.lanxin.lombok.errors;
import com.lanxin.service.KeshiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lanxin.service.KsHospitalService;
import com.lanxin.service.KsMaladyService;
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
public class KeshiServiceImpl extends ServiceImpl<Keshidao, Keshi> implements KeshiService {

    @Autowired
    KsHospitalService ksHospitalService;

    @Autowired
    KsMaladyService ksMaladyService;

    @Autowired
    Keshidao keshidao;

    @Override
    public Result selKeshi(Keshi ks) {

        PageHelper.startPage(ks.getPage(),ks.getCount());//执行查询前走
        List<Keshi> keshis=keshidao.selKeshi(ks);
        PageInfo<Keshi> pageInfo=new PageInfo<Keshi>(keshis);
        if(keshis.size()>0) {
            return Result.ok2(keshis,Integer.parseInt(String.valueOf(pageInfo.getTotal())));
        }else{
            throw new errors(500, "没有查询到数据");
        }
    }

    @Override
    public Result addKeshi(Keshi keshi) {
        return Result.ok(this.save(keshi));
    }

    @Override
    public Result upKeshi(Keshi keshi) {
        return Result.ok(this.updateById(keshi));
    }

    @Override
    public Result deKeshi(Integer oid) {//科室id
        QueryWrapper<KsHospital> wrapper=new QueryWrapper<>();//科室医院表
        wrapper.eq("ksid",oid);
        List<KsHospital> ksHospitalslist = ksHospitalService.list(wrapper);

        QueryWrapper<KsMalady> wrapper2=new QueryWrapper<>();//科室 疾病表
        wrapper2.eq("ksid",oid);
        List<KsMalady> ksMaladieslist = ksMaladyService.list(wrapper2);

        if(ksHospitalslist.size()<=0 && ksMaladieslist.size()<=0){
            return Result.ok(this.removeById(oid));
        }else {
            throw new errors(500, "科室使用中不能删除");
        }
    }
}
