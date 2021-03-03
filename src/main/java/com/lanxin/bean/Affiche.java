package com.lanxin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
public class Affiche extends PageVo {//公告表

    private static final long serialVersionUID = 1L;
    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;//编号

    private String title;//标题

    private String content;//内容

    private Integer hosid;//所属医院

   /* @TableField(exist = false)//表示该属性不为数据库表字段，但又是必须使用的。
    private String hname;//医院名*/

}
