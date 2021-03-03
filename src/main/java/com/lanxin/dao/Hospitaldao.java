package com.lanxin.dao;

import com.lanxin.bean.Hospital;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lanxin.lombok.Result;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
public interface Hospitaldao extends BaseMapper<Hospital> {

    @Select("select h.*,a.aname from hospital h left join area a on h.area=a.oid where h.oid=#{oid}")
    public Hospital HospitalById(Integer oid);
}
