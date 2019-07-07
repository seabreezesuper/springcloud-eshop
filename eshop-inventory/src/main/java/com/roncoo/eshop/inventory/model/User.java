package com.roncoo.eshop.inventory.model;

/**
 * 测试用户Model类
 * @author Administrator
 *
 */
public class User {

	/**
	 * 测试用户姓名
	 */
	private String userName;
	/**
	 * 测试用户年龄
	 */
	private Integer age;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
