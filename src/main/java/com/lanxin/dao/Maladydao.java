package com.lanxin.dao;

import com.lanxin.bean.Malady;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lanxin.lombok.Result;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
public interface Maladydao extends BaseMapper<Malady> {

    public List<Malady> selMalady(Malady malady);//模糊查询

}
