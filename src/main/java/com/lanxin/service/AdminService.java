package com.lanxin.service;

import com.lanxin.bean.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lanxin.lombok.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
public interface AdminService extends IService<Admin> {
    public Result selAdmin(Admin admin);
    public Result addAdmin(Admin admin);
    public Result upAdmin(Admin admin);
    public Result delAdmin(Integer oid);

}
