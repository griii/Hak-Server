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

    @Autowired
    WebsocketChatServer websocketChatServer;

    public void startServer(){
		new Thread(websocketChatServer).start();
		System.out.println("运行线程2...");
		new Thread(new MsgLogic()).start();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//WebsocketChatServer.main(new String[]{});
        MsgLogic.userDao = this.userDao;
        startServer();
	}
 
}