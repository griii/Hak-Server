package com.guorui.hak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettydemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(NettydemoApplication.class, args);
        System.out.println("启动netty");
    }

}
