package com.guorui.hak.controller;


import com.guorui.hak.entity.http.Result;
import com.guorui.hak.service.UserMainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RequestMapping("/user")
@RestController
public class UserMainController {


    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserMainService userMainService; 

    @PostMapping("/login")
    public Result login(String account,String psw){
        return userMainService.login(account,psw);
    }


    @PostMapping("/register")
    public Result register(String account,String name,String phone,String psw){
        return userMainService.register(account, name, phone, psw);
    }
}






















