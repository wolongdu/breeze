package com.breeze.system;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.breeze.common.security.annotation.EnableCustomConfig;
import com.breeze.common.security.annotation.EnableRyFeignClients;
import com.breeze.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 系统模块
 * 
 * @author breeze
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringCloudApplication
public class BreezeSystemApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BreezeSystemApplication.class, args);

    }
}
