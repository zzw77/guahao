package com.lanxin.controller;


import com.lanxin.bean.Doctor;
import com.lanxin.bean.Paiban;
import com.lanxin.lombok.Result;
import com.lanxin.service.PaibanService;
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
@RequestMapping("/paiban")
public class PaibanController {

    @Autowired
    PaibanService paibanService;

    @RequestMapping("/listPb") //查询医生去排班
    @ResponseBody
    public Result listPb(@RequestBody Doctor doctor, String date){//查询某个专科下正在使用的科室
        return paibanService.listPb(doctor,date);
    }

    @RequestMapping("/addPb")
    @ResponseBody
    public Result addPb(@RequestBody Paiban[] paibans){
        return null;
    }

}
