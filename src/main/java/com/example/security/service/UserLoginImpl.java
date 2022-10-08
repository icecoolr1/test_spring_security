package com.example.security.service;

import com.example.security.domin.ResponseResult;
import com.example.security.pojo.Customer;
import com.example.security.pojo.LoginCustomer;
import com.example.security.utils.JwtUtil;
import com.example.security.utils.RedisCache;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service

//自定义登录接口实现类
public class UserLoginImpl implements IUserLoginService{



    @Resource
    AuthenticationManager authenticationManager;
    @Resource
    RedisCache redisCache;
    @Override
    public ResponseResult<Map<String,Object>> Login(Customer customer) {
        //    1. 使用ProviderManager auth方法进行验证
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(customer.getUserName(),customer.getUserPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if(Objects.isNull(authenticate)){
            throw new RuntimeException("为空");
        }
        Map<String,Object> map = new HashMap<>();

        //2. 自己生成jwt给前端
        LoginCustomer loginCustomer = ((LoginCustomer) authenticate.getPrincipal());
        String userId = String.valueOf(loginCustomer.getCustomer().getUserId()) ;
        System.out.println(userId);
        String jwt = JwtUtil.createJWT(userId);
        map.put("token",jwt);


        //3. 系统用户相关所有信息放入redis
        redisCache.setCacheObject("login:"+userId,loginCustomer);


        return new ResponseResult<>(200, "成功", map);
    }

    @Override
    public ResponseResult LoginOut() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginCustomer customer = (LoginCustomer) authentication.getPrincipal();
        String userid = "login:"+ customer.getCustomer().getUserId();
        redisCache.deleteObject(userid);
        return new ResponseResult(200,"退出成功");
    }
}
