package la.chopper.spring.boot.core.component;

import la.chopper.spring.boot.core.pojo.Result;
import la.chopper.spring.boot.core.pojo.ResultCode;
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
