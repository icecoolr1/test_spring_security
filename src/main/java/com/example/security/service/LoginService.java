package com.example.security.service;


import com.example.security.mapper.CustomerMapper;
import com.example.security.pojo.Customer;
import com.example.security.pojo.LoginCustomer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

//自定义UserDetail实现类
@Service
public class LoginService implements UserDetailsService {

    @Resource
    CustomerMapper customerMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1 根据用户名查询到数据库数据

        Customer customer = customerMapper.getCustomerByName(username);
        if (Objects.isNull(customer)) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        //2 封装权限信息、


        //3 返回UserDetails
        return new LoginCustomer(customer);
    }
}
