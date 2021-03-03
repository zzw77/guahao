package com.lanxin.service;

import com.lanxin.bean.Doctor;
import com.lanxin.bean.Paiban;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lanxin.lombok.Result;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
public interface PaibanService extends IService<Paiban> {

    public Result listPb(Doctor doctor, String date);//查询医生去排班
    public Result addPb(Paiban[] paibans);//添加排班

}
