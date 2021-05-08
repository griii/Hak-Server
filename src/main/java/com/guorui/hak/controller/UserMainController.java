package com.guorui.hak.controller;


import com.guorui.hak.pojo.Result;
import com.guorui.hak.service.UserMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/user")
@RestController
public class UserMainController {
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






















