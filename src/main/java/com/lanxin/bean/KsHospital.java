package com.lanxin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class KsHospital extends Model<KsHospital> {//科室_医院表

    private static final long serialVersionUID = 1L;

    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;

    private Integer ksid;//所属科室

    private Integer hosid;//所属医院

    private Integer cid;//所属专科


}
