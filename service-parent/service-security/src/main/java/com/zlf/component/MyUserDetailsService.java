package com.zlf.component;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: zlf
 * @Date: 2021/03/30/23:38
 * @Description:
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        /* 此处查询数据库得到角色权限列表，这里可以用Redis缓存以增加查询速度 */
        System.out.println("--- ---- 判断");
        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));  // 角色 需要以 ROLE_ 开头
        return new org.springframework.security.core.userdetails.User(username,  new BCryptPasswordEncoder().encode("123456"), authorityList);
    }
}
