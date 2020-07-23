package com.breeze.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.breeze.common.security.annotation.EnableRyFeignClients;

/**
 * 认证授权中心
 * 
 * @author breeze
 */
@EnableRyFeignClients
@SpringCloudApplication
public class BreezeAuthApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BreezeAuthApplication.class, args);

    }
}
