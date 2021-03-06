package com.guorui.hak.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class WebsocketChatServerInitializer extends
		ChannelInitializer<SocketChannel> {


	@Autowired
	TextWebSocketFrameHandler textWebSocketFrameHandler;

	@Override
    public void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
		pipeline.addLast(new HttpObjectAggregator(64*1024));
		pipeline.addLast(new WebSocketServerProtocolHandler("/hak/ws"));
		System.out.println(textWebSocketFrameHandler);
		pipeline.addLast(textWebSocketFrameHandler);
    }
}