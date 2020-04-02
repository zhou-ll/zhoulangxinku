package com.niit.AppMember;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @packgeName com.niit.AppMember
 * @author zhoulanglang
 * @version 2019年7月19日下午3:20:28
 *
 */

@SpringBootApplication
@EnableEurekaClient
@RestController
@Slf4j
public class AppMember {

	public static void main(String[] args) {
		SpringApplication.run(AppMember.class, args);
	}

	@RequestMapping("/getMember")
	public String getMember() {
		log.info("我是普通消费者+++++getMember");
		return "我是普通消费者+++++getMember";

	}
}
