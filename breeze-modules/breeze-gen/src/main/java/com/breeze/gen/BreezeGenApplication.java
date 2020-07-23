package com.breeze.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.breeze.common.security.annotation.EnableCustomConfig;
import com.breeze.common.security.annotation.EnableRyFeignClients;
import com.breeze.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 代码生成
 * 
 * @author breeze
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableRyFeignClients
@SpringCloudApplication
public class BreezeGenApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BreezeGenApplication.class, args);

    }
}
