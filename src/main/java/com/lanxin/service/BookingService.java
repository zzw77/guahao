package com.lanxin.service;

import com.lanxin.bean.Area;
import com.lanxin.bean.Booking;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lanxin.lombok.Result;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
public interface BookingService extends IService<Booking> {

    public Result selBooking();
    public Result listYypage(Booking booking);//分页模糊查询
    public Result addBooking(Booking booking );
    public Result upBooking(Booking booking );
    public Result delBooking(Integer oid);
}
