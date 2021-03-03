package com.lanxin.service;

import com.lanxin.bean.Admin;
import com.lanxin.bean.Affiche;
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
public interface AfficheService extends IService<Affiche> {

    public Result selAffiche(Affiche affiche);
    public Result addAffiche(Affiche affiche );
    public Result upAAffiche(Affiche affiche );
    public Result delAffiche(Integer oid);
}
