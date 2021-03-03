package com.lanxin.controller;


import com.lanxin.bean.Hospital;
import com.lanxin.lombok.Result;
import com.lanxin.service.HospitalService;
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
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    HospitalService hospitalService;

    @RequestMapping("/HospitalById")
    @ResponseBody
    public Result HospitalById(Integer oid){ //查询医院信息
      return hospitalService.HospitalById(oid);
    }

    @RequestMapping("/HospitalUp")
    @ResponseBody
    public Result HospitalUp(@RequestBody Hospital hospital){ //修改医院信息
        return hospitalService.HospitalUp(hospital);
    }

    @RequestMapping("/Hospitaladd")
    @ResponseBody
    public Result Hospitaladd(@RequestBody Hospital hospital){ //添加医院信息
        return hospitalService.Hospitaladd(hospital);
    }

    @RequestMapping("/Hospitaldel")
    @ResponseBody
    public Result Hospitaldel(Integer oid){ //删除医院信息
        return hospitalService.Hospitaldel(oid);
    }


}
