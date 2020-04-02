package com.niit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
*@packgeName	com.niit.Controller
*@author	zhoulanglang
*@version	2019年7月19日下午10:17:36
*
*/
@RestController
public class OrderController {
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value ="/getorder1",method = RequestMethod.GET)
	public String getOrder1() {
		// order 使用rpc 远程调用技术 调用 会员服务
//		String memberUrl = "http://app-itmayiedu-member/getMember";
//		restTemplate.getForEntity("http://app-itmayiedu-member/getMember",String.class).getBody();
//		 restTemplate.getForObject(memberUrl, String.class);
		//System.out.println("会员服务调用订单服务,result:" + result);
		return restTemplate.getForEntity("http://app-itmayiedu-member/getMember",String.class).getBody();
	}

}
