package com.ys.skywingracing.user.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class userController {

    @RequestMapping("/hi")
    public String hi() {
        return "hi";
    }
}
