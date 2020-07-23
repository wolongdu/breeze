package com.breeze.modules.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 监控中心
 * 
 * @author breeze
 */
@EnableAdminServer
@SpringCloudApplication
public class BreezeMonitorApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BreezeMonitorApplication.class, args);

    }
}
