package com.lanxin.service;

import com.lanxin.bean.Hospital;
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
public interface HospitalService extends IService<Hospital> {

    public Result HospitalById(Integer oid);
    public Result HospitalUp(Hospital hospital);
    public Result Hospitaladd(Hospital hospital);
    public Result Hospitaldel(Integer oid);
}
