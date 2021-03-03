package com.lanxin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanxin.bean.*;
import com.lanxin.dao.Zhuankedao;
import com.lanxin.lombok.Result;
import com.lanxin.lombok.errors;
import com.lanxin.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lanxin.vo.zkwhVo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
@Service
public class ZhuankeServiceImpl extends ServiceImpl<Zhuankedao, Zhuanke> implements ZhuankeService {

    @Autowired
    ZkHospitalService zkHospitalService;

    @Autowired
    KsHospitalService ksHospitalService;

    @Autowired
    KsMaladyService ksMaladyService;

    @Autowired
    KeshiService keshiService;

    @Autowired
    MaladyService maladyService;


    @Autowired
    Zhuankedao zhuankedao;

    @Override
    public Result selZhuanke(Zhuanke zhuanke) {
        PageHelper.startPage(zhuanke.getPage(),zhuanke.getCount());//执行查询前走
        List<Zhuanke> zhuankes=zhuankedao.selzhuanke(zhuanke);
        PageInfo<Zhuanke> pageInfo=new PageInfo<Zhuanke>(zhuankes);

        if(zhuankes.size()>0) {
            return Result.ok2(zhuankes,Integer.parseInt(String.valueOf(pageInfo.getTotal())));
        }else{
            throw new errors(500, "没有查询到数据");
        }
    }

    @Override
    public Result addZhuanke(Zhuanke zhuanke) {
        return Result.ok(this.save(zhuanke));
    }

    @Override
    public Result upKZhuanke(Zhuanke zhuanke) {
        return Result.ok(this.updateById(zhuanke));
    }

    @Override
    public Result deKZhuanke(Integer oid) {
        QueryWrapper<ZkHospital> wrapper=new QueryWrapper<>();
        wrapper.eq("zkid",oid);
        List<ZkHospital> list2 = zkHospitalService.list(wrapper);//医院 专科表

        QueryWrapper<Keshi> keshiQueryWrapper = new QueryWrapper<>();
        keshiQueryWrapper.eq("zkid", oid);
        List<Keshi> list = keshiService.list(keshiQueryWrapper);//科室表

        QueryWrapper<Malady> maladyQueryWrapper = new QueryWrapper<>();//疾病表
        maladyQueryWrapper.eq("zkid", oid);
        List<Malady> list1 = maladyService.list(maladyQueryWrapper);

        if(list2.size()>0 || list.size()>0 || list1.size()>0){
            throw new errors(500, "正在使用不能删除");
        }else {
            return Result.ok(this.removeById(oid));
        }
    }

    //专科科室维护 树状图
    @Override
    public Result zkAll(Integer hosid) {
        QueryWrapper<ZkHospital> wrapper=new QueryWrapper<>();
        wrapper.eq("hosid",hosid);
        List<ZkHospital> zkHospitals = zkHospitalService.list(wrapper);//医院 专科表

        QueryWrapper<KsHospital> ksHospitalQueryWrapper=new QueryWrapper<>();
        wrapper.eq("hosid",hosid);
        List<KsHospital> ksHospitals = ksHospitalService.list(ksHospitalQueryWrapper);//科室医院表

        QueryWrapper<KsMalady> ksMaladyQueryWrapper=new QueryWrapper<>();
        wrapper.eq("hid",hosid);
        List<KsMalady> ksMaladies = ksMaladyService.list(ksMaladyQueryWrapper);//医院 专科表



        List<Zhuanke> zhuankes=zhuankedao.zkAll(hosid) ;
        /*for(Zhuanke z:zhuankes){
            for(Keshi k:z.getKeshis()){
                for(Malady m:z.getMaladies()){
                    k.getMaladies().add(m);
                }
            }
        }*/


        for(Zhuanke z:zhuankes){
            for(ZkHospital zh:zkHospitals){
                if(zh.getZkid()==z.getOid()){//判断第专科医院表 是否有专科
                    z.setChecked(true);
                }
            }

            for(Keshi k:z.getKeshis()){
                for(Malady m:z.getMaladies()){//把 疾病添加到科室疾病集合
                    Malady malady=new Malady();
                    malady.setOid(m.getOid());
                    malady.setMname(m.getMname());
                    k.getMaladies().add(malady);
                }
                for(KsHospital kh:ksHospitals){//判断科室医院表 是否有科室
                    if(k.getOid()==kh.getKsid() && z.getOid()==kh.getCid()){
                        k.setChecked(true);
                    }
                }

                for(Malady m:k.getMaladies()) {
                    for (KsMalady km : ksMaladies) {//判断疾病科室表 是否有疾病
                        if(m.getOid()==km.getMid() && km.getKsid()==k.getOid()){
                            m.setChecked(true);
                        }
                    }
                }
            }
        }

        return Result.ok(zhuankes);
    }
    //专科科室维护

    @Override
    @Transient //事务
    public Result upzkAll(zkwhVo zkwhVo,Integer hosid) {

        QueryWrapper<ZkHospital> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("hosid",hosid);
        zkHospitalService.remove(queryWrapper);//删除专科


        QueryWrapper<KsHospital> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.eq("hosid",hosid);
        ksHospitalService.remove(queryWrapper1);//删除科室

        QueryWrapper<KsMalady> queryWrapper2=new QueryWrapper<>();
        queryWrapper2.eq("hid",hosid);
        ksMaladyService.remove(queryWrapper2);//删除疾病


//添加专科-医院
        String [] zhuankes=zkwhVo.getZhuankes();
        List<ZkHospital> zkHospitalList=new ArrayList<>();
        for(String str:zhuankes){
            ZkHospital zkHospital=new ZkHospital();
            zkHospital.setHosid(hosid);
            zkHospital.setZkid(Integer.parseInt(str));
            zkHospitalList.add(zkHospital);
        }
        zkHospitalService.saveBatch(zkHospitalList);

//添加科室-医院
        String[] keshis = zkwhVo.getKeshis();
        List<KsHospital> ksHospitalList=new ArrayList<>();
        for(String ks:keshis){
            String[] split = ks.split("-");
            KsHospital ksHospital=new KsHospital();
            ksHospital.setCid(Integer.parseInt(split[0]));
            ksHospital.setKsid(Integer.parseInt(split[1]));
            ksHospital.setHosid(hosid);
            ksHospitalList.add(ksHospital);
        }
        ksHospitalService.saveBatch(ksHospitalList);
//添加疾病-科室
        String [] maladys=zkwhVo.getMaladys();
        List<KsMalady> ksMaladyList=new ArrayList<>();
        for(String ml:maladys){
            String[] split = ml.split("-");
            KsMalady ksMalady=new KsMalady();
            ksMalady.setHid(hosid);
            ksMalady.setKsid(Integer.parseInt(split[0]));
            ksMalady.setMid(Integer.parseInt(split[1]));

            ksMaladyList.add(ksMalady);
        }
        ksMaladyService.saveBatch(ksMaladyList);

        return Result.ok(true);
    }
}
