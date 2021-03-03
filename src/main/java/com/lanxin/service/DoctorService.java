package com.lanxin.service;

import com.lanxin.bean.Booking;
import com.lanxin.bean.Doctor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lanxin.bean.Keshi;
import com.lanxin.bean.Zhuanke;
import com.lanxin.lombok.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gaoqin
 * @since 2020-07-13
 */
public interface DoctorService extends IService<Doctor> {

    public Result selDoctor(Doctor doctor);
    public Result addorupdateDoctor(Doctor doctor , MultipartFile prctureFile, HttpServletRequest request);
    public Result delDoctor(Integer oid);

    public Result qyzhuanke(Integer hosid);//查询正在使用的专科

    public Result qykeshi(Integer zkid, Integer hosid);//查询某个专科下启用的科室
}
