package com.lanxin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanxin.bean.Admin;
import com.lanxin.bean.Affiche;
import com.lanxin.bean.Doctor;
import com.lanxin.dao.Affichedao;
import com.lanxin.lombok.Result;
import com.lanxin.lombok.errors;
import com.lanxin.service.AfficheService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
@Service
public class AfficheServiceImpl extends ServiceImpl<Affichedao, Affiche> implements AfficheService {

    @Autowired
    Affichedao affichedao;

    @Override
    public Result selAffiche(Affiche affiche) {
        PageHelper.startPage(affiche.getPage(),affiche.getCount());//执行查询前走//分页
        List<Affiche> affiches=affichedao.selAffiche(affiche);
        PageInfo<Affiche> pageInfo=new PageInfo<Affiche>(affiches);

        if(affiches.size()>0) {
            return Result.ok2(affiches,Integer.parseInt(String.valueOf(pageInfo.getTotal())));
        }else{
            throw new errors(500, "没有查询到数据");
        }
    }

    @Override
    public Result addAffiche(Affiche affiche) {
        return Result.ok(this.save(affiche));
    }

    @Override
    public Result upAAffiche(Affiche affiche) {
        return Result.ok(this.updateById(affiche));
    }

    @Override
    public Result delAffiche(Integer oid) {
        return Result.ok(this.removeById(oid));
    }
}
