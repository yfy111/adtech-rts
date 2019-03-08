package com.adtech.rts.controller;

import com.adtech.rts.result.Result;
import com.adtech.rts.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录接口
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    @GetMapping("/loginIndex")
    public ModelAndView loginIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @PostMapping("/login")
    public Result login(String userName,String password){
        return loginService.login(userName,password);
    }
}
