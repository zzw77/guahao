package com.lanxin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lanxin.vo.PageVo;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
@Data
public class Doctor extends PageVo {// 医生表

    private static final long serialVersionUID = 1L;

    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;//编号

    private String dname;//姓名

    private String phone;//电话

    private String images;//头像

    private Integer hosid;//所属医院id

    private Integer zkid;//专科id

    private Integer ksid;//科室id

    @TableField(exist = false)//不映射到数据库
    private String zkname;//专科名称
    @TableField(exist = false)//不映射到数据库
    private String ksname;//科室名称


    @TableField(exist = false)//不映射到数据库
    private List<Paiban> paibans=new ArrayList<>();
}
