package com.lc.shiro.chapter3.role;

import java.util.Arrays;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

import com.lc.shiro.chapter3.utils.BaseTest;



public class RoleTest extends BaseTest{
	@SuppressWarnings("deprecation")
	@Test
	public void testHasRole(){
		login("classpath:shiro-role.ini", "zhang", "123");
		//判断用友角色 ： role1
		Assert.assertTrue(subject().hasRole("role1"));
		//判断拥有角色：role1 and role2
		Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1", "role2")));
		//判断拥有角色：role1 and role2 and !role3
		boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));
		Assert.assertEquals(true, result[0]);
		Assert.assertEquals(true, result[1]);
		Assert.assertEquals(false, result[2]);
	}
	
	@Test(expected = UnauthorizedException.class)
    public void testCheckRole() {
        login("classpath:shiro-role.ini", "zhang", "123");
        //断言拥有角色：role1
        subject().checkRole("role1");
        //断言拥有角色：role1 and role3 失败抛出异常
        subject().checkRoles("role1", "role3");
    }
	
	@Test
	public void testCheckRoleExceted(){
		login("classpath:shiro-role.ini", "zhang", "123");
        //断言拥有角色：role1
        subject().checkRole("role1");
        //断言拥有角色：role1 and role3 失败抛出异常
        try {
        	subject().checkRoles("role1", "role3");
		} catch (Exception e) {
            System.out.println(e.getMessage());
		}
	}
}
