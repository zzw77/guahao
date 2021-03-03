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
public class Malady extends PageVo {//疾病表

    private static final long serialVersionUID = 1L;
    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;

    private String mname;//疾病名称

    private Integer zkid;//所属专科id

    private Integer hid;//医院id

    @TableField(exist = false)
    private String zkname;//专科名称

}
