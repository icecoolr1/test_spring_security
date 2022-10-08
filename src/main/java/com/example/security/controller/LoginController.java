package com.example.security.controller;


import com.example.security.domin.ResponseResult;
import com.example.security.pojo.Customer;
import com.example.security.service.ICustomerInterface;
import com.example.security.service.IUserLoginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController()
@RequestMapping("/user")
public class LoginController {
    @Resource
    ICustomerInterface customerInterface;
    @Resource
    IUserLoginService userLoginService;

    @GetMapping("/hello")
    public List<Customer> Login(String username){

        return customerInterface.getAllCustomer();
    }

    @PostMapping("/login")
    public ResponseResult<Map<String, Object>> userLogin(@RequestBody Customer customer){

        return userLoginService.Login(customer);
    }

    @PostMapping("/logout")
    public ResponseResult<Map<String,Object>> userLogout(){

        return userLoginService.LoginOut();
    }


}
