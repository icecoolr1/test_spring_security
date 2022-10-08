package com.example.security.handler;

import com.alibaba.fastjson.JSON;
import com.example.security.domin.ResponseResult;
import com.example.security.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseResult responseResult = new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "登录认证失败");
        String s = JSON.toJSONString(responseResult);
        WebUtils.renderString(response,s);
    }
}
