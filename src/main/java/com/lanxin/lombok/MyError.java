package com.lanxin.lombok;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice//该注解定义全局异常处理类
@ResponseBody
public class MyError {
    @ExceptionHandler(value = Exception.class) //该注解声明异常处理方法
    public Result exceptionHandler(Exception e) {

        if (e instanceof errors) {//判断是不是自定义异常
            errors ex = (errors) e;
            return new Result(ex.getCode(),ex.getMsg(),null);
        }
        return Result.fail();
    }

}
