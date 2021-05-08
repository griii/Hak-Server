package com.guorui.hak.netty;

import com.guorui.hak.logic.MsgLogic;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class WebsocketChatServer implements Runnable{

    private int port;

    public WebsocketChatServer(int port) {
        this.port = port;
    }

    public void run(){
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
             .channel(NioServerSocketChannel.class)
             .childHandler(new WebsocketChatServerInitializer())
             .option(ChannelOption.SO_BACKLOG, 128)
             .childOption(ChannelOption.SO_KEEPALIVE, true);
    		System.out.println("WebsocketChatServer 启动了");
            ChannelFuture f = b.bind(port).sync(); // (7)
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
    		System.out.println("WebsocketChatServer 关闭了");
        }
    }

    public static void main(String[] args) throws Exception {
        int port;
        port = 8088;
        new Thread(new WebsocketChatServer(port)).start();
        System.out.println("运行线程2...");
        new Thread(new MsgLogic()).start();
    }
}