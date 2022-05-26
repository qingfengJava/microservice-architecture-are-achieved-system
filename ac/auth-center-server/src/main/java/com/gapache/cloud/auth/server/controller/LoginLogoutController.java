package com.gapache.cloud.auth.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginLogoutController {

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
}
