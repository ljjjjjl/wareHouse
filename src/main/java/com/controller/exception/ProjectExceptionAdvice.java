package com.controller.exception;

import com.controller.result.Code;
import com.controller.result.Result;
import com.exception.SqlException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//表示异常处理器
public class ProjectExceptionAdvice {

    @ExceptionHandler(SqlException.class)
    public Result doSystemException(SqlException e){
        //记录日志
        System.out.println("调用SqlException");
        return new Result(e.getCode(),null,e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    //表示抛出所有异常
    public Result doException(Exception e){

        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统繁忙，请稍后再试！！");
    }
}
