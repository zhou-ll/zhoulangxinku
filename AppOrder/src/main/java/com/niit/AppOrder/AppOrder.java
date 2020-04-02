package com.niit.AppOrder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
*@packgeName	com.niit.AppOrder
*@author	zhoulanglang
*@version	2019年7月19日下午10:20:22
*
*/
@SpringBootApplication
@EnableEurekaClient
@RestController
@Slf4j
public class AppOrder {
	public static void main(String[] args) {
		SpringApplication.run(AppOrder.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/getorder")
	public String getOrder() {
		// order 使用rpc 远程调用技术 调用 会员服务
		String memberUrl = "http://app-itmayiedu-member/getMember";
		String result = restTemplate.getForObject(memberUrl, String.class);
		System.out.println("会员服务调用订单服务,result:" + result);
		log.info(result);
		return result;
	}
	@RequestMapping("/me")
	public String getMe() {
		// order 使用rpc 远程调用技术 调用 会员服务
		//String memberUrl = "http://app-itmayiedu-member/getMember";
		//String result = restTemplate.getForObject(memberUrl, String.class);
		String result = "会员服务";
		System.out.println("会员服务调用订单服务,result:" + result);
		return result;
	}
}

