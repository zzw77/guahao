package com.lanxin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
@Data
public class Hospital extends Model<Hospital> {//医院表

    private static final long serialVersionUID = 1L;

    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;//编号

    private String hname;//医院名称

    private String level;//级别

    private Integer area;//地区id

    private String address;//地址

    private String path;//乘车线路

    private String phone;//电话

    private String jianjie;//医院简介

    private String plan;//预约步骤

    @TableField(exist = false)//表示该属性不为数据库表字段，但又是必须使用的。
    private String aname;//地区名

}
