package com.lanxin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class Paiban extends Model<Paiban> {//排班表

    private static final long serialVersionUID = 1L;

    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;

    @TableField("amQuantity")
    private Integer amQuantity;//预约数量

    private String ondate;//值班日期

    private String onam;//上午下午

    private Integer docid;//医生id


}
