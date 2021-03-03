package com.lanxin.service;

import com.lanxin.bean.Booking;
import com.lanxin.bean.Keshi;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lanxin.lombok.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
public interface KeshiService extends IService<Keshi> {

    public Result selKeshi(Keshi ks);
    public Result addKeshi(Keshi keshi );
    public Result upKeshi(Keshi keshi );
    public Result deKeshi(Integer oid);
}
