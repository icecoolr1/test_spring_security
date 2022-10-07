package com.example.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.security.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface CustomerMapper  {
    @Select("SELECT * FROM CUSTOMER")
    List<Customer> getAllCustomer();

    @Select("SELECT  * FROM CUSTOMER WHERE user_id=#{id}")
    Customer getCustomerById(int id);

    @Select("SELECT * FROM CUSTOMER WHERE  user_name=#{username}")
    Customer getCustomerByName(String username);
}
