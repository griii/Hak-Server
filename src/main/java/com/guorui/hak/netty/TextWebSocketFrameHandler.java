package com.guorui.hak.netty;

import com.guorui.hak.dao.UserDao;
import com.guorui.hak.entity.room.IRoom;
import com.guorui.hak.logic.MsgLogic;
import com.guorui.hak.entity.instruct.Instruct;
import com.guorui.hak.util.MsgManage;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;



@ChannelHandler.Sharable
@Component
public class TextWebSocketFrameHandler extends
		SimpleChannelInboundHandler<TextWebSocketFrame> {

	@Value("${MAX_USER_THRESHOLD}")
	public static int MAX_USER_THRESHOLD;

	public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	public static ConcurrentHashMap<String,Channel> channelMap = new ConcurrentHashMap<>(512);
	public static Map<String, IRoom> roomMap = new HashMap<>(512);

	@Autowired
	MsgManage msgManage;

	@Autowired
	UserDao userDao;

	@Override
	protected void channelRead0(ChannelHandlerContext ctx,
								TextWebSocketFrame msg) throws Exception { // (1)
		//System.out.println("接收到text消息..." + msg.text());
		//先对比uid是否正确
		//将消息转为Instruct指令形式,然后交付给manage处理
		Channel incoming = ctx.channel();
		JSONObject jsonObject = JSONObject.fromObject(msg.text());
		Instruct instruct = new Instruct(jsonObject.get("order")+"",jsonObject.getLong("time"),jsonObject.get("obj"),jsonObject.getInt("roomId"),Integer.parseInt(jsonObject.get("uid").toString()));
		if (instruct.getOrder().equals("JOIN")){
			if (!channelMap.containsKey(incoming.id()+"")){
				System.out.println("指令异常返回");
				return;
			}
			System.out.println("map更新" + channelMap.toString());
			channelMap.put(instruct.getUid() + "",channelMap.remove(incoming.id()+""));
			System.out.println("map更新完毕" + channelMap.toString());
			msgManage.join(instruct, userDao.getNameById(instruct.getUid()));
			return;
		}
		if (!channelMap.containsKey(instruct.getUid() + "")){
			System.out.println("不存在该UID...");
			return;
		}
		//System.out.println("指令存入队列中...");
		roomMap.get(instruct.getUid()+"").addInstruct(instruct);
		//msgManage.addInstruct(instruct);
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {  // (2)
		Channel incoming = ctx.channel();
		channels.writeAndFlush(new TextWebSocketFrame("[SERVER] - " + incoming.remoteAddress() + " 加入"));
		channels.add(incoming);
		String tag = incoming.id() + "";
		channelMap.put(tag,incoming);
		System.out.println("Client:"+incoming.remoteAddress() +"加入");
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {  // (3)
		Channel incoming = ctx.channel();
		// Broadcast a message to multiple Channels
		channels.writeAndFlush(new TextWebSocketFrame("[SERVER] - " + incoming.remoteAddress() + " 离开"));
		System.out.println("Client:"+incoming.remoteAddress() +"离开");
		// A closed Channel is automatically removed from ChannelGroup,
		// so there is no need to do "channels.remove(ctx.channel());"
		}
	    
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception { // (5)
        Channel incoming = ctx.channel();
		System.out.println("Client:"+incoming.remoteAddress()+"在线");
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception { // (6)
        Channel incoming = ctx.channel();
		System.out.println("Client:"+incoming.remoteAddress()+"掉线");
		//掉线后清楚本类中两个容器中的通道，然后清除在Room中维护的通道  后续取消清除操作改为将该用户的状态更新为"掉线"
		for (Map.Entry<String,Channel> entry:channelMap.entrySet()){
			if (entry.getValue().equals(incoming)){

				break;
			}
		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
    	Channel incoming = ctx.channel();
    	incoming.id();
		System.out.println("Client:"+incoming.remoteAddress()+"异常");
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
	}
}