package com.lanxin.service;

import com.lanxin.bean.Affiche;
import com.lanxin.bean.Area;
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
public interface AreaService extends IService<Area> {

    public Result selArea();
    public Result addArea(Area area );
    public Result upArea(Area area );
    public Result delArea(Integer oid);
}
