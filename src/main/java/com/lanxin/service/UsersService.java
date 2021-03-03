package com.lanxin.service;

import com.lanxin.bean.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lanxin.lombok.Result;
import org.apache.catalina.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
public interface UsersService extends IService<Users> {

    public Result selUser(Users user);
    public Result addUser(Users user);
    public Result upUser(Users user);
    public Result delUser(Integer oid);

}
