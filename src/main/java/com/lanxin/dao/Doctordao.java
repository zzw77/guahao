package com.lanxin.dao;

import com.lanxin.bean.Doctor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lanxin.bean.Keshi;
import com.lanxin.bean.Paiban;
import com.lanxin.bean.Zhuanke;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
public interface Doctordao extends BaseMapper<Doctor> {

   public List<Doctor> selDoctor(Doctor doctor);//组合查询

   public List<Doctor> listPb(Doctor doctor);//查询排班

   //去添加医生的时候走
   @Select("select * from zhuanke where oid in (select zkid from zk_hospital z where z.hosid=#{hosid})")
   public List<Zhuanke> qyzhuanke(Integer hosid);//查询正在使用的专科

   @Select("select * from keshi where oid in (select ksid from ks_hospital k where k.zkid=#{zkid} and k.hosid=#{hosid})")
   public List<Keshi> qykeshi(Integer zkid,Integer hosid);//查询某个专科下正在使用的科室
}
