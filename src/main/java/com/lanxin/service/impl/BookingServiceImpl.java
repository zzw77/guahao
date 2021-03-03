package com.lanxin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanxin.bean.Booking;
import com.lanxin.bean.Doctor;
import com.lanxin.dao.Bookingdao;
import com.lanxin.lombok.Result;
import com.lanxin.lombok.errors;
import com.lanxin.service.BookingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class BookingServiceImpl extends ServiceImpl<Bookingdao, Booking> implements BookingService {

    @Autowired
    Bookingdao bookingdao;

    @Override
    public Result selBooking() {
        return Result.ok(this.list());
    }

    @Override
    public Result listYypage(Booking booking) {//分页模糊查询
        PageHelper.startPage(booking.getPage(),booking.getCount());//执行查询前走//分页
        List<Booking> bookings=bookingdao.listYypage(booking);
        PageInfo<Booking> pageInfo=new PageInfo<Booking>(bookings);

        if(bookings.size()>0) {
            return Result.ok2(bookings,Integer.parseInt(String.valueOf(pageInfo.getTotal())));
        }else{
            throw new errors(500, "没有查询到预约信息");
        }
    }

    @Override
    public Result addBooking(Booking booking) {
        this.save(booking);
        return Result.ok(bookingdao.upPaiban(booking));
    }

    @Override
    public Result upBooking(Booking booking) {
        return Result.ok(this.updateById(booking));
    }

    @Override
    public Result delBooking(Integer oid) {
        return Result.ok(this.removeById(oid));
    }
}
