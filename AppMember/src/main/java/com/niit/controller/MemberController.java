package com.niit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @packgeName com.niit.controller
 * @author zhoulanglang
 * @version 2019年7月19日下午5:12:05
 *
 */
@RestController
public class MemberController {
	@RequestMapping("/getMember")
	public String getMember() {
		return "this is getMember";
	}
}
