package com.lanxin.dao;

import com.lanxin.bean.Zhuanke;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
public interface Zhuankedao extends BaseMapper<Zhuanke> {

    public List<Zhuanke> selzhuanke(Zhuanke zhuanke);

    //显示树状图
    public List<Zhuanke> zkAll(Integer hosid);//专科科室
}
