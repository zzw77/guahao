package com.lanxin.service.impl;

import com.lanxin.bean.Area;
import com.lanxin.dao.Areadao;
import com.lanxin.lombok.Result;
import com.lanxin.service.AreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
@Service
public class AreaServiceImpl extends ServiceImpl<Areadao, Area> implements AreaService {

    @Override
    public Result selArea() {
        return Result.ok(this.list());
    }

    @Override
    public Result addArea(Area area) {
        return Result.ok(this.save(area));
    }

    @Override
    public Result upArea(Area area) {
        return Result.ok(this.updateById(area));
    }

    @Override
    public Result delArea(Integer oid) {
        return Result.ok(this.removeById(oid));
    }
}
