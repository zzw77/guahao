package com.lanxin.controller;


import com.lanxin.bean.Area;
import com.lanxin.bean.Booking;
import com.lanxin.lombok.Result;
import com.lanxin.service.BookingService;
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
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @RequestMapping("/selBooking")
    @ResponseBody
    public Result selBooking(){//查询预约表
        return bookingService.selBooking();
    }
    @RequestMapping("/listYypage")
    @ResponseBody
    public Result listYypage(@RequestBody Booking booking) {//分页模糊查询

        return bookingService.listYypage(booking);
    }

    @RequestMapping("/addBooking")
    @ResponseBody
    public Result addBooking(@RequestBody Booking booking){//添加
        return bookingService.addBooking(booking);
    }

    @RequestMapping("/upBooking")
    @ResponseBody
    public Result upBooking(@RequestBody Booking booking){//修改
        return bookingService.upBooking(booking);
    }

    @RequestMapping("/delBooking")
    @ResponseBody
    public Result delBooking(Integer oid){//删除
        return bookingService.delBooking(oid);
    }

}
