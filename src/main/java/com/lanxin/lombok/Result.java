package com.lanxin.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//无参的构造方法
@AllArgsConstructor//所有参的构造方法
public class Result{
    private Integer code;//返回码
    private String msg;//返回信息
    private Object data;//返回对象
    private Integer num;//返回的总页数

    public Result(Integer code, String msg,Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }


    public static Result ok(Object data){

        return new Result(200,"操作成功",data);
    }
    public static Result ok2(Object data,Integer num){

        return new Result(200,"操作成功",data,num);
    }

    public static Result fail(){

        return new Result(500,"操作失败",null

        );
    }
}
