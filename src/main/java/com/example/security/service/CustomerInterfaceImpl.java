package com.example.security.service;

import com.example.security.mapper.CustomerMapper;
import com.example.security.pojo.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerInterfaceImpl implements ICustomerInterface {
    @Resource
    CustomerMapper customerMapper;
    @Override
    public List<Customer> getAllCustomer() {
        return customerMapper.getAllCustomer();
    }
}
