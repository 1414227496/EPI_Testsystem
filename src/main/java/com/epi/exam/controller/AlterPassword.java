package com.epi.exam.controller;

import com.epi.exam.Message.SendSms;
import com.epi.exam.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author YANGCHAO
 * @create 2019-12-07 14:40
 */
@Controller
@Transactional(rollbackFor = Exception.class)
@RequestMapping("/changePassword")
public class AlterPassword {
	@Autowired
	UserService userService;
	@Autowired
	private SendSms sendSms;
	private static String CODE = "111";


	@RequestMapping("/alter")
	@ResponseBody
	public int alterPassword(String telnumber, String clientCode, String newPassword) {
		//验证码校验成功
		if (CODE.equals( clientCode ) && newPassword.length() > 6) {
			String md5Hash = new Md5Hash( newPassword, "xiaoqing", 1 ).toString();
			return 1;
		}
		return 0;
	}

	@RequestMapping("/alterVerify")
	@ResponseBody
	public int verifyTelnumber(String telnumber) {

		if (userService.getUserByTelnumber( telnumber ) != null) {
			//账号已注册，则发送验证码
			CODE = sendSms.sendSms( telnumber );
			return 1;
		}
		return 0;
	}

}
