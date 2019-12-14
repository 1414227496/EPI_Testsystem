package com.epi.exam.controller;


import com.epi.exam.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YANGCHAO
 * @create 2019-12-03 9:59
 */

@RestController
public class LoginController {
	@Autowired
	UserService userService;

	@RequestMapping("/doLogin")
	public String doLogin(String telnumber, String password) {
		//获取主体进行验证
		Subject subject = SecurityUtils.getSubject();
		try {
			UsernamePasswordToken token = new UsernamePasswordToken( telnumber, password );
			subject.login( token );
			System.out.println( "登录成功!" );

			return "index.html";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println( "登录失败!" );
			return "403.html";

		}

	}

	@GetMapping("/index")
	public String hello() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/logout")
	public void logOut() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		System.out.println( "logout sucessful" );
	}


}
