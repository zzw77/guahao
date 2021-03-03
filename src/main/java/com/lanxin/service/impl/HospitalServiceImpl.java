package com.lanxin.service.impl;

import com.lanxin.bean.Hospital;
import com.lanxin.dao.Hospitaldao;
import com.lanxin.lombok.Result;
import com.lanxin.service.HospitalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class HospitalServiceImpl extends ServiceImpl<Hospitaldao, Hospital> implements HospitalService {

    @Autowired
    Hospitaldao hospitaldao;

    @Override
    public Result HospitalById(Integer oid) {//查询医院信息
        Object obj=hospitaldao.HospitalById(oid);
        return Result.ok(obj);
    }

    @Override
    public Result HospitalUp(Hospital hospital) {//修改医院信息
        return Result.ok(this.updateById(hospital));
    }

    @Override
    public Result Hospitaladd(Hospital hospital) {
        return Result.ok(this.save(hospital));
    }

    @Override
    public Result Hospitaldel(Integer oid) {
        return Result.ok(this.removeById(oid));
    }

}
