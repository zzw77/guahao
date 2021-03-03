package com.lanxin.service;

import com.lanxin.bean.Malady;
import com.lanxin.bean.Zhuanke;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lanxin.lombok.Result;
import com.lanxin.vo.zkwhVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
public interface ZhuankeService extends IService<Zhuanke> {

    public Result selZhuanke(Zhuanke zhuanke);
    public Result addZhuanke(Zhuanke zhuanke );
    public Result upKZhuanke(Zhuanke zhuanke );
    public Result deKZhuanke(Integer zkid);

    public Result zkAll(Integer hosid);//专科科室维护
    public Result upzkAll(zkwhVo zkwhVo ,Integer hosid);//专科科室维护

}
