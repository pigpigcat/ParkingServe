package com.github.core.component;

import com.github.core.pojo.Result;
import com.github.core.pojo.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 *
 * @author wulitech
 * @version 1.0
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result defaultExceptionHandler(HttpServletRequest request, Exception e) {
        if (e instanceof NoHandlerFoundException) {
            Result result = new Result();
            result.setResultCode(ResultCode.NOT_FOUND);
            return result;
        }
        e.printStackTrace();
        Result result = new Result();
        result.setCode(500);
        result.setMsg("服务器内部错误");
        result.setData(e.getMessage());
        return result;
    }

}
