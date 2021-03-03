package com.lanxin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lanxin.vo.PageVo;
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
public class Booking extends PageVo {//预约表

    private static final long serialVersionUID = 1L;

    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;//编号

    private Integer uid;//用户id

    private Integer ksid;//科室id

    private Integer hosid;//医院id

    private Integer mid;//疾病id

    private Integer docid;//医生id

    private Date orderdate;//预约日期

    private String ampm;//上午或下午

    @TableField(exist = false)
    private String ksname;//科室名称

    @TableField(exist = false)
    private String dname;///医生名称

    @TableField(exist = false)
    private String mname;//疾病名称

    @TableField(exist = false)
    private String username;//用户名

    @TableField(exist = false)
    private Integer count2;


}
