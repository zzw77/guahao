package com.lanxin.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lanxin.bean.Doctor;
import com.lanxin.bean.Paiban;
import com.lanxin.dao.Doctordao;
import com.lanxin.dao.Paibandao;
import com.lanxin.lombok.Result;
import com.lanxin.service.PaibanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lanxin.vo.DateVo;
import com.lanxin.vo.PaibanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
@Service
public class PaibanServiceImpl extends ServiceImpl<Paibandao, Paiban> implements PaibanService {

    @Autowired
    Doctordao doctordao;

    @Autowired
    Paibandao paibandao;

    @Override//查询医生去排班
    public Result listPb(Doctor doctor, String date) {
        Integer begin =Integer.parseInt(date.substring(0, 4));//年份
        Integer end = Integer.parseInt(date.substring(date.indexOf("-")+1));//月份
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, begin);
        a.set(Calendar.MONTH, end-1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);//天数

        List<Doctor> doctors=doctordao.listPb(doctor);//查询的医生集合
        DateVo dateVoas[] =new DateVo[maxDate];//上午数组
        DateVo dateVops[] =new DateVo[maxDate];//下午数组
        DateVo dateVoa;//上午对象
        DateVo dateVop;//下午对象
        List<PaibanVo> paibanVoList=new ArrayList<>();//排班vo集合
        for(Doctor d:doctors){ //循环查询的医生集合
            PaibanVo paibanVo=new PaibanVo();
            paibanVo.setOid(d.getOid());
            paibanVo.setDname(d.getDname());

            for (int i=0;i<maxDate;i++){//循环这个月多少天
                dateVoa=new DateVo();//上午对象
                dateVop=new DateVo();//下午对象
                String str;
                if(i<10){
                    str=date+"-0"+(i+1);
                }else{
                    str=date+"-"+(i+1);
                }

                dateVoa.setDete(str);//上午对象添加时间
                dateVop.setDete(str);//下午对象添加时间


                dateVoas[i]=dateVoa;//上午对象数组
                dateVops[i]=dateVop;//下午对象数组

                for(Paiban p:d.getPaibans()){
                    if(str.equals(p.getOnam()) && p.getOnam().equals("a")){//判断时间=排班时间 并且=上午
                        dateVoa.setChecked(true);//更改上午状态
                    }else if(str.equals(p.getOnam()) && p.getOnam().equals("p")){//判断时间=排班时间 并且=下午
                        dateVop.setChecked(true);//更改下   午状态
                    }

                }

            }
            paibanVo.setAms(dateVoas);
            paibanVo.setPms(dateVops);
            paibanVoList.add(paibanVo);
        }

        return Result.ok(paibanVoList);
    }

    @Override
    public Result addPb(Paiban[] paibans) {//添加修改排班
        List<Paiban> paibanList=new ArrayList<>();
        Set<Integer> docids=new HashSet<>();

        for(Paiban p:paibans){
            paibanList.add(p);//存排班对象
            docids.add(p.getDocid());//存医生id
        }
        for(Integer doid:docids){
            paibandao.delPb(doid,paibans[0].getOndate());//添加前先删除
        }

        return Result.ok(this.saveBatch(paibanList));//添加多条
    }


}
