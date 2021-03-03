package com.lanxin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanxin.bean.*;
import com.lanxin.dao.Doctordao;
import com.lanxin.lombok.Result;
import com.lanxin.lombok.errors;
import com.lanxin.service.BookingService;
import com.lanxin.service.DoctorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lanxin.service.PaibanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<Doctordao, Doctor> implements DoctorService {

    @Autowired
    Doctordao doctordao;

    @Autowired
    PaibanService paibanService;

    @Autowired
    BookingService bookingService;

    @Override
    public Result selDoctor(Doctor doctor) {//分页组合查询
        PageHelper.startPage(doctor.getPage(),doctor.getCount());//执行查询前走//分页
        List<Doctor> doctors=doctordao.selDoctor(doctor);
        PageInfo<Doctor> pageInfo=new PageInfo<Doctor>(doctors);

        if(doctors.size()>0) {
            return Result.ok2(doctors,Integer.parseInt(String.valueOf(pageInfo.getTotal())));
        }else{
            throw new errors(500, "没有查询到医生信息");
        }
    }

    @Override
    public Result addorupdateDoctor(Doctor doctor , MultipartFile file, HttpServletRequest request) {//添加医生 和头像
        String path =request.getServletContext().getRealPath("/image");
        System.out.println(path);
        if(!file.isEmpty()){
            String Filename = file.getOriginalFilename();//文件名称
            String lastName=Filename.substring(Filename.lastIndexOf("."));//文件后缀
            String uuid= UUID.randomUUID().toString().replace("-","");//生成uuid 把里面的-给去掉
            String fname=uuid+lastName;//新文件名
            File file1 = new File(path +"/"+ fname);//file图片文件的路径
            if(!file1.getParentFile().exists()){//判断文件的上级目录是否存在
                file1.getParentFile().mkdirs();//不存在就创建
            }
            try {
                file.transferTo(file1);//上传文件到path文件夹里
                doctor.setImages(path+fname);//给图片字段赋值
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Result.ok(this.saveOrUpdate(doctor));//添加或修改 主键id有值就根据id修改,沒值就把添加一条

    }

    @Override
    public Result delDoctor(Integer oid) {//医生id
        QueryWrapper<Paiban> paibanQueryWrapper=new QueryWrapper<>();//排版表
        paibanQueryWrapper.eq("docid",oid);
        List<Paiban> paibans = paibanService.list(paibanQueryWrapper);

        QueryWrapper<Booking> wrapper2=new QueryWrapper<>();//预约
        wrapper2.eq("docid",oid);
        List<Booking> bookings = bookingService.list(wrapper2);

        if(bookings.size()<=0 && paibans.size()<=0){
            return Result.ok(this.removeById(oid));
        }else {
            throw new errors(500, "医生还有病人不能删除");
        }
    }



    @Override
    public Result qyzhuanke(Integer hosid) {
        return Result.ok(doctordao.qyzhuanke(hosid));
    }

    @Override
    public Result qykeshi(Integer zkid, Integer hosid) {
        return Result.ok(doctordao.qykeshi(zkid,hosid));
    }
}
