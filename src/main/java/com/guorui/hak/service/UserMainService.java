package com.guorui.hak.service;


import com.guorui.hak.dao.UserDao;
import com.guorui.hak.pojo.Result;
import com.guorui.hak.pojo.User;
import com.guorui.hak.util.MainUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMainService {

    @Autowired
    UserDao userDao;

    @Autowired
    User user;

    public Result login(String account,String psw){
        User userReal = userDao.getUserByAccount(account);
        if (userReal == null){
            return Result.defaultError().reSetObj("账户不存在!");
        }
        if (userReal.getPsw().equals(MainUtil.getMD5(psw))){
            user.setAccount(userReal.getAccount());
            user.setToken(userReal.getToken());
            user.setName(userReal.getName());
            user.setPhone(userReal.getPhone());
            user.setUid(userReal.getUid());
            return Result.defaultSuccess().reSetObj(user);
        }else{
            return Result.defaultError().reSetObj("密码错误!");
        }
    }

    public Result register(String account,String name,String phone,String psw){
        if (userDao.getUserByAccount(account) != null){
            return Result.defaultError().reSetObj("账户已存在!");
        }
        if (userDao.getUserByName(name) != null){
            return Result.defaultError().reSetObj("该昵称已被使用!");
        }
        String token = MainUtil.getToken(account);
        userDao.insertUser(account, name, phone, MainUtil.getMD5(psw), token);
        return Result.defaultSuccess().reSetObj(token);
    }



}
