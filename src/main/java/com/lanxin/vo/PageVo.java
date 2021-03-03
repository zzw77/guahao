package com.lanxin.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class PageVo {

    @TableField(exist = false)
    Integer page;  //当前页
    @TableField(exist = false)
    Integer count; //每页数量
    @TableField(exist = false)
    boolean checked=false;
}
