package com.example.security;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.security.mapper.CustomerMapper;
import com.example.security.pojo.Customer;
import com.example.security.service.ICustomerInterface;
import com.example.security.utils.JwtUtil;
import com.example.security.utils.RedisCache;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

@SpringBootTest
class TestSpringSecurityApplicationTests {
    @Resource
    ICustomerInterface customerInterface;
    @Resource
    CustomerMapper customerMapper;
    @Resource
    RedisCache redisCache;

    @Test
    void contextLoads() {
        System.out.println("true = " + true);
    }

    @Test
    void testJwt(){
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("XYZ")
                .setIssuedAt(new Date())
                .setSubject("user")
                .signWith(SignatureAlgorithm.HS256,"icecoolr1")
                .claim("userId","8788");
        String compact = jwtBuilder.compact();
        System.out.println(compact);

        Claims claims = Jwts.parser().setSigningKey("icecoolr1").parseClaimsJws(compact).getBody();
        System.out.println(claims);
    }

    @Test
    void testMapper(){
//        List<Customer> allCustomer = customerInterface.getAllCustomer();
//        for (Customer customer : allCustomer) {
//            System.out.println(customer);
//        }

//
//        Customer customerById = customerMapper.getCustomerByName("sss");
//        System.out.println(customerById);

        BCryptPasswordEncoder sad = new BCryptPasswordEncoder();
        System.out.println(sad.encode("Wy20001976"));

    }

    @Test
    void testggg(){
        String jwt = JwtUtil.createJWT("2");
        System.out.println(jwt);
    }

    @Test
    void getPerms(){
        System.out.println(customerMapper.getCustomerPerms(3));
    }




}
