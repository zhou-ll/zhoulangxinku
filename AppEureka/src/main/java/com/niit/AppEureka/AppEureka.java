package com.niit.AppEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
*@packgeName	com.niit.AppEureka
*@author	zhoulanglang
*@version	2019年7月19日下午3:00:25
*
*/

@EnableEurekaServer
@SpringBootApplication
public class AppEureka {

	public static void main(String[] args) {
		SpringApplication.run(AppEureka.class, args);
	}

}
