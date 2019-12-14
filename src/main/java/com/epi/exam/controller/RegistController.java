package com.epi.exam.controller;

import com.epi.exam.Message.SendSms;
import com.epi.exam.entity.User;
import com.epi.exam.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;


/**
 * 注册以及手机号码验证
 *
 * @author YANGCHAO
 * @create 2019-12-04 11:10
 */

@Controller
@RequestMapping("/regist")
public class RegistController {
	@Autowired
	private RegistService registService;
	@Autowired
	private UserService userService;
	@Autowired
	private SendSms sendSms;
	@Autowired
	private RoleService roleService;
	@Autowired
	PermissionList permissionList;
	@Autowired
	private PermissionService permissionService;
	//记得删掉
	private static String CODE = "111";
	private static Integer COUNTTELNUMBER = 11;

	/**
	 * @param map map中有user的数据和客户端传来的手机验证码clientcode
	 * @return
	 */
	@RequestMapping("/submmit")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public String regist(@RequestBody Map<Object, Object> map) {
		User user = new User();
		String clientcode = null;
		String str = "clientcode";
		//遍历map得到user和clientcode
		Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Object, Object> entry = it.next();
			if (entry.getKey().equals( str )) {
				clientcode = (String) entry.getValue();
			} else {
				//给user对象赋值
				user = SetMethod( user, entry.getKey(), entry.getValue() );
			}
		}

		System.out.println( user.toString() );

		if (clientcode.equals( CODE ) && user != null) {
			int MSG = registService.regist( user );

			if (MSG != 0) {
				System.out.println( "注册成功" );
				//注册时给用户添加默认角色
				String roleId = roleService.insertRole( user.getId() );
				//根据返回的roleId给用户添加默认权限
				permissionList.insertPermission( roleId );
				permissionList.selectPermission( roleId );
				permissionList.updatePermission( roleId );
				return "index.html";
			}
			CODE = null;
			System.out.println( "注册失败" );
			return "login.html";
		} else {
			return "login.html";
		}

	}

	/**
	 * 验证手机号是否合法、并且验证手机号是否存在
	 */
	@RequestMapping("/verify")
	@ResponseBody
	public String verifyTelnumber(String telnumber) {
		//验证手机号码位数以及是否注册
		if (telnumber.length() != COUNTTELNUMBER) {
			System.out.println( "账号不合法，请您重新输入" );
			return "login.html";
		} else if (userService.getUserByTelnumber( telnumber ) != null) {
			System.out.println( "账号已注册，请您重新更换账号" );
			return "login.html";
		}
		CODE = sendSms.sendSms( telnumber );
		return "index.html";

	}


	/**
	 * 得到set方法
	 */

	public User SetMethod(User user, Object key, Object v) {
		Class clazz = user.getClass();
		String filedName = key.toString();
		try {
			Object value = v;
			Class typeClass = clazz.getDeclaredField( filedName ).getType();
			String methodName = "set" + filedName.substring( 0, 1 ).toUpperCase() + filedName.substring( 1 );
			String dat = "class java.util.Date";
			String type = typeClass.toString();
			if (dat.equals( type )) {
				//格式化日期
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
				simpleDateFormat.setLenient( false );
				//将字符串转化为Date
				value = simpleDateFormat.parse( (String) value );
			}
			Method method = clazz.getDeclaredMethod( methodName, typeClass );
			method.invoke( user, new Object[]{value} );
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
