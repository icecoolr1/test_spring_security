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



    @Select("SELECT  perms FROM sys_user s\n" +
            "    LEFT JOIN sys_user_role sur on s.id = sur.user_id\n" +
            "        LEFT JOIN sys_role sr on sur.role_id = sr.id\n" +
            "            LEFT JOIN sys_role_menu srm on sr.id = srm.role_id\n" +
            "                LEFT JOIN sys_menu sm on srm.menu_id = sm.id\n" +
            "                    where sm.status = 0 and s.id= #{cid} and s.status = 0")
    List<String> getCustomerPerms(long cid);
}
