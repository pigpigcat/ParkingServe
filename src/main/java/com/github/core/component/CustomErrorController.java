package com.github.core.component;

import com.github.core.pojo.Result;
import com.github.core.pojo.ResultCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TonyTonyChopper
 */
@RestController
@RequestMapping("/error")
public class CustomErrorController {


    public Result test() {
        Result result = new Result();
        result.setResultCode(ResultCode.FORBIDDEN);
        return result;
    }
}
