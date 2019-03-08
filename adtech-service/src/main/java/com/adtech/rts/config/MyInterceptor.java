package com.adtech.rts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @功能描述 自定义拦截器
 */
@Configuration
public class MyInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;
    //方法执行前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //跳入登录页面
        if(redisTemplate.opsForValue().get("user")==null){
            response.sendRedirect("/loginIndex");
            return false;
        }
        return true;
    }

    //方法执行后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    //页面渲染前
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
