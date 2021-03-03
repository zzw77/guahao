package com.lanxin.dao;

import com.lanxin.bean.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.catalina.User;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
public interface Usersdao extends BaseMapper<Users> {

    public List<Users> selUser(Users user);
}
