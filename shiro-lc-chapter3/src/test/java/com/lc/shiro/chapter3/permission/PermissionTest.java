package com.lc.shiro.chapter3.permission;

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
}
