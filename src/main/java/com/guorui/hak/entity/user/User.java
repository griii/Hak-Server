package com.guorui.hak.entity.user;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class User {

    private String uid;
    private String token;
    private String psw;
    private String account;
    private String phone;
    private String code;
    private Date lastLogin;
    private String ipAddress;
    private String name;
    private String imgUrl;

}
