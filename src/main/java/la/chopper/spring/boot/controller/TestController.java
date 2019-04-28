package la.chopper.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("soraka")
public class TestController {

    @RequestMapping("test")
    public String test() {
        return "test";
    }
}
