package com.guorui.hak.config.aspectConfig;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.guorui.hak.entity.instruct.Instruct;
import com.guorui.hak.entity.player.impl.PlayerPeople;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Slf4j
@Component
public class LogInstructAspect {

    @Pointcut("execution(* com.guorui.hak.entity.instruct..*.*(..))")
    public void instructLog(){
    }

    @Around("instructLog()")
    public void aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        StringBuilder logInfor = new StringBuilder();
        joinPoint.proceed();//先执行
        //System.out.println("切面执行...");
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof Instruct){
                Instruct ins = (Instruct)arg;
                logInfor.append("u: [" + ins.getRoomId() + ":" + ins.getUid() + "]" +  "," + ((Instruct) arg).getOrder());
            }else if(arg instanceof PlayerPeople){
                log.info(logInfor + ", {}",arg.toString());
            }
        }
    }
}
