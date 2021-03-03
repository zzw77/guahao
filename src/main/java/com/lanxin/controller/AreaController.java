package com.lanxin.controller;


import com.lanxin.bean.Affiche;
import com.lanxin.bean.Area;
import com.lanxin.lombok.Result;
import com.lanxin.service.AfficheService;
import com.lanxin.service.AreaService;
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
@RequestMapping("/area")
public class AreaController {

    @Autowired
    AreaService areaService;

    @RequestMapping("/selArea")
    @ResponseBody
    public Result selArea(){//查询地区
        return areaService.selArea();
    }

    @RequestMapping("/addArea")
    @ResponseBody
    public Result addArea(@RequestBody Area area){//添加
        return areaService.addArea(area);
    }

    @RequestMapping("upArea")
    @ResponseBody
    public Result upArea(@RequestBody Area area){//修改
        return areaService.upArea(area);
    }

    @RequestMapping("delArea")
    @ResponseBody
    public Result delArea(Integer oid){//删除
        return areaService.delArea(oid);
    }

}
