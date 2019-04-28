package la.chopper.spring.boot.core.controller;

import la.chopper.spring.boot.core.domain.ApiReturnObject;
import la.chopper.spring.boot.core.util.ApiReturnUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author TonyTonyChopper
 */
@Controller
@RequestMapping("/CheckCenter")
public class CheckCenterController {

    /**
     * 页面请求
     * @param cid
     * @return
     */
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav=new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return mav;
    }

    /**
     * 推送数据接口
     * @param cid
     * @param message
     * @return
     */
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public ApiReturnObject pushToWeb(@PathVariable String cid, String message) {
        try {
            WebSocketServerController.sendInfo(message, cid);
        } catch (IOException e) {
            e.printStackTrace();
            return ApiReturnUtils.error(cid + "#" + e.getMessage());
        }
        return ApiReturnUtils.success(cid);
    }
}
