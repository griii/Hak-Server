package com.guorui.hak.config;

import com.guorui.hak.dao.UserDao;
import com.guorui.hak.logic.MsgLogic;
import com.guorui.hak.netty.WebsocketChatServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartPingService implements CommandLineRunner {

    @Autowired
    UserDao userDao;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		WebsocketChatServer.main(new String[]{});
        System.out.println(this.userDao);
        MsgLogic.userDao = this.userDao;
	}
 
}