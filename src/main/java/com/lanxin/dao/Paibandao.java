package com.lanxin.dao;

import com.lanxin.bean.Doctor;
import com.lanxin.bean.Paiban;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lanxin.lombok.Result;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
public interface Paibandao extends BaseMapper<Paiban> {

    @Delete("delete from paiban where docid=#{docid} and date_format(ondate,'%Y%m')=date_format(#{date},'%Y%m')")
    public boolean delPb(Integer docid,String date);

}
