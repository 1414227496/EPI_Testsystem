package com.epi.exam.shiro;


import com.epi.exam.entity.Permission;
import com.epi.exam.entity.Role;
import com.epi.exam.entity.User;
import com.epi.exam.service.PermissionService;
import com.epi.exam.service.RoleService;
import com.epi.exam.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;

	//引入日志

	private static final Logger logger = LoggerFactory.getLogger( MyShiroRealm.class );

	//授权

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		logger.info( "开始授权" );
		//从凭证中获得用户名

		String telnumber = (String) principalCollection.getPrimaryPrincipal();
		//根据电话查询用户对象
		User user = userService.getUserByTelnumber( telnumber );
		if (user == null) {
			return null;
		}
		//查询用户拥有的角色
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<Role> roleList = roleService.findByUserId( user.getId() );
		for (Role role : roleList) {
			//赋予用户角色
			info.addRole( role.getRole() );
			//分配权限
			List<Permission> permissionList = permissionService.getPermissionListById( role.getId() );

			for (Permission permission : permissionList) {
				info.addStringPermission( permission.getPermission() );
			}
		}
		logger.info( "授权完毕" );
		return info;
	}

	//认证

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		logger.info( "开始认证用户信息" );
		//获得当前用户的账户名
		String telnumber = (String) authenticationToken.getPrincipal();

		//从数据库中根据用户名查找用户
		User user = userService.getUserByTelnumber( telnumber );

		if (user == null) {
			return null;
		}
		//盐值，如果密码进行加密就需要下面的方法

		ByteSource salt = ByteSource.Util.bytes( "xiaoqing" );

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo( user.getTelnumber(), user.getPassword(), salt, getName() );
		logger.info( "认证完毕" );
		return info;

	}

}
