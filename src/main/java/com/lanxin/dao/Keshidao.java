package com.lanxin.dao;

import com.lanxin.bean.Keshi;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lanxin.lombok.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
public interface Keshidao extends BaseMapper<Keshi> {
    public List<Keshi> selKeshi(Keshi ks);//查询所有科室,条件查询

}
