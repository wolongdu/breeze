package com.breeze.job;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.breeze.common.security.annotation.EnableCustomConfig;
import com.breeze.common.security.annotation.EnableRyFeignClients;
import com.breeze.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 定时任务
 * 
 * @author breeze
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableRyFeignClients
@SpringCloudApplication
public class BreezeJobApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BreezeJobApplication.class, args);

    }
}
