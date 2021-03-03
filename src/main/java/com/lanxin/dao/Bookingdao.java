package com.lanxin.dao;

import com.lanxin.bean.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
public interface Bookingdao extends BaseMapper<Booking> {

    public List<Booking> listYypage(Booking booking);//分页模糊查询

    /*@Select("select * from keshi where oid in (select ksid from ks_hospital k where k.hosid=#{hosid})")
    public List<Keshi> bkKeshi(Integer hosid); //添加预约时查询科室*/

    @Select("select * from malady where oid in (select mid from ks_malady km where km.hid=#{hosid} and km.ksid=#{ksid})")
    public List<Malady> bkMalady(Integer hosid,Integer ksid);//预约时查询疾病 科室表

    @Select("select * from doctor d where d.ksid=#{ksid} and d.hosid=#{hosid}")
    public List<Doctor> bkDoctor(Integer hosid,Integer ksid);//预约时查询医生表


    @Select("select * from paiban where docid=#{docid} and amQuantity>0 and ondate>#{date}")
    public List<Paiban> bkPaiban(Integer docid,String date);//查询医生的排班时间预约数量大于0并且预约时间大于当前-显示医生的排班时间

    @Select("select * from paiban where docid=#{docid} and ondate=#{ondate}")
    public List<Paiban> bkampm(Integer docid,String date);//根据医生的排班时间-可以选择上下午

    @Update("update paiban set amQuantity=amQuantity-1 where docid=#{docid} and onam=#{ampm} and ondate=#{orderdate}")
    public boolean upPaiban(Booking booking);//预约时修改医生排班的预约数量

   /* @Select("select amQuantity from paiban where docid=#{docid} and onam=#{ampm} and ondate=#{ondate}")
    public int amQuantity(Integer docid,String ondate,String ampm);//医生排班的预约数量*/


    public List<Booking> kscount(Integer hosid,String startDate,String endDate);//科室预约统计

    public List<Booking> doccount(Integer hosid,String startDate,String endDate);//医生预约统计

    public List<Booking> hoscount(Integer hosid,String startDate,String endDate);//医院预约统计





}
