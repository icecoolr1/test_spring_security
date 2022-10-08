package com.example.security.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer  implements Serializable {
    private static final long serialVersionUID = 1L;

    private long userId;
    // 用户名
    private String userName;
    // 密码
    private String userPassword;
    // 邮箱
    private String userEmail;
    // 角色
    private String userRole;

}