package com.lanxin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.lanxin.vo.PageVo;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
@Data
public class Zhuanke extends PageVo {//专科表

    private static final long serialVersionUID = 1L;
    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;

    private String zkname;//名称

    private Integer hosid;//所属医院id

    @TableField(exist = false)//表示该属性不为数据库表字段，但又是必须使用的。
    private Set<Keshi> keshis=new HashSet<>();

    @TableField(exist = false)//表示该属性不为数据库表字段，但又是必须使用的。
    private Set<Malady> maladies=new HashSet<>();


}
