package com.lanxin.dao;

import com.lanxin.bean.Affiche;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lanxin.bean.Hospital;
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
public interface Affichedao extends BaseMapper<Affiche> {
   public List<Affiche> selAffiche(Affiche affiche);
}
