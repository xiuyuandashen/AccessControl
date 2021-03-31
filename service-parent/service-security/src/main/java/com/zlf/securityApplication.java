package com.zlf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: zlf
 * @Date: 2021/03/30/23:07
 * @Description:
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.zlf"})
public class securityApplication {
    public static void main(String[] args) {
        SpringApplication.run(securityApplication.class,args);
    }
}
