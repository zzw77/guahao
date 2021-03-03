package com.lanxin.service;

import com.lanxin.bean.Keshi;
import com.lanxin.bean.Malady;
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
public interface MaladyService extends IService<Malady> {

    public Result selMalady(Malady malady);
    public Result addMalady(Malady malady );
    public Result upKMalady(Malady malady );
    public Result deKMalady(Integer oid);

}
