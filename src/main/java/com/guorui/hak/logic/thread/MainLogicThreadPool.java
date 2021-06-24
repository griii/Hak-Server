package com.guorui.hak.logic.thread;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class MainLogicThreadPool{

    @Value("${MAX_THREAD_THRESHOLD}")
    private int MAX_THREAD_THRESHOLD;

    private static class RejectedHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            //先不做任何处理
        }
    }

    @Bean
    public ExecutorService mainLogicPool(){
        //线程池仅容载每个游戏房间的内容，不是容载每个用户的数量
        //单个服务器的线程池，要求：核心100线程，无法添加线程，核心线程空闲10分钟后销毁
        //也就是说等待队列使用不存储的SynchronousQueue即可，拒绝策略为向用户返回拒绝值
        //线程乘以2的原因是每个房间维护一个指令解析线程和一个广播线程
        return new ThreadPoolExecutor(MAX_THREAD_THRESHOLD*2,
                MAX_THREAD_THRESHOLD*2,
                10,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new RejectedHandler());
    }

}
