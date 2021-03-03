package com.lanxin.vo;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class PaibanVo {
    private Integer oid;//医生id
    private String dname;//医生姓名
   /* private Integer count;//预约数量*/
    private DateVo ams[];//上午
    private DateVo pms[];//下午


}

