package com.lanxin.controller;


import com.lanxin.bean.Booking;
import com.lanxin.bean.Doctor;
import com.lanxin.lombok.Result;
import com.lanxin.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController {

   @Autowired
   DoctorService doctorService;


    @RequestMapping("/selDr")//查询
    @ResponseBody
    public Result selDr()
    {
        return Result.ok(doctorService.list());
    }

    @RequestMapping("/selDoctor")//组合查询//查询医生表
    @ResponseBody
    public Result selDoctor(@RequestBody Doctor doctor)
    {
        return doctorService.selDoctor(doctor);
    }

    @RequestMapping("/addorupdateDoctor")
    @ResponseBody//修改或添加
    public Result addorupdateDoctor(Doctor doctor, MultipartFile file, HttpServletRequest request){
        return doctorService.addorupdateDoctor(doctor,file,request);
    }

    @RequestMapping("/delDoctor")
    @ResponseBody
    public Result delDoctor(Integer oid){//删除
        return doctorService.delDoctor(oid);
    }


    //去添加

    @RequestMapping("/qyzhuanke")
    @ResponseBody
    public Result qyzhuanke(Integer hosid){//查询正在使用的专科
        return doctorService.qyzhuanke(hosid);
    }
    @RequestMapping("/qykeshi")
    @ResponseBody
    public Result qykeshi(Integer zkid, Integer hosid){//查询某个专科下正在使用的科室
        return doctorService.qykeshi(zkid,hosid);
    }



}
