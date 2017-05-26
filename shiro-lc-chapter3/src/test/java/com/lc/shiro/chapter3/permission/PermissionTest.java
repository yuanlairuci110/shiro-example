package com.lc.shiro.chapter3.permission;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

import com.lc.shiro.chapter3.utils.BaseTest;


public class PermissionTest extends BaseTest{
	@Test
	public void testIsPermitted(){
		login("classpath:shiro-permission.ini", "zhang", "123");
		//判断拥有权限：user:create
		Assert.assertTrue(subject().isPermitted("user:create"));
		//判断拥有权限：user:update and user:delete
		Assert.assertTrue(subject().isPermittedAll("user:update", "user:delete"));
		//判断拥有权限：user:update and user:delete
		Assert.assertTrue(subject().isPermittedAll("user:update", "user:delete"));
	}

	@Test(expected = UnauthorizedException.class)
	public void testCheckPermission() {
		login("classpath:shiro-permission.ini", "zhang", "123");
		//断言拥有权限：user:create
		subject().checkPermission("user:create");
		//断言拥有权限：user:delete and user:update
		subject().checkPermissions("user:delete", "user:update");
		//断言拥有权限：user:view 失败抛出异常
		subject().checkPermissions("user:view");
	}

	@Test
	public void testCheckPermissionException(){
		login("classpath:shiro-permission.ini", "zhang", "123");
		//断言拥有权限：user:create
		subject().checkPermission("user:create");
		//断言拥有权限：user:delete and user:update
		subject().checkPermissions("user:delete", "user:update");
		//断言拥有权限：user:view 失败抛出异常
		try {
			subject().checkPermissions("user:view");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
