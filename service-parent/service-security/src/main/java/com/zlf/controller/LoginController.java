package com.zlf.controller;

import com.zlf.Api.CommonResult;
import com.zlf.entity.User;
import com.zlf.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: zlf
 * @Date: 2021/03/30/23:15
 * @Description:
 */
@RestController
public class LoginController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @PostMapping("/admin/login")
    public String login(@RequestBody User user, HttpServletRequest request) {
        /* 在这里验证用户名和密码，验证成功则生成token返回 */
        System.out.println("--- -- -login");
        System.out.println(user);
//        Map<String,String> map = new HashMap<>();
//        map.put("key",jwtTokenUtil.generateToken(user));
        return  tokenHead+" "+jwtTokenUtil.generateToken(user);  // 生成 Token，返回给客户端
    }

    @PreAuthorize("hasAnyRole('USER')")  // 对单个方法进行权限控制
    @GetMapping("/me")
    public String me() {
        // 从上下文中获取 UserDetails
        UserDetails userDetails = (UserDetails) org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUsername() + "," + userDetails.getPassword();
    }
}
