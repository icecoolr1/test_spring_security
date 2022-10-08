package com.example.security.service;

import com.example.security.domin.ResponseResult;
import com.example.security.pojo.Customer;

import java.util.Map;


public interface IUserLoginService {
     ResponseResult<Map<String,Object>> Login(Customer customer);

     ResponseResult LoginOut();
}
