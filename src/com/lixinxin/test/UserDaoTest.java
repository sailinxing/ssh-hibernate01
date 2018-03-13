package com.lixinxin.test;


import org.junit.Before;
import org.junit.Test;

import com.lixinxin.dao.UserDao;
import com.lixinxin.model.User;

public class UserDaoTest {
	UserDao dao;
	@Before
	public void init(){
		dao=new UserDao();
	}
	@Test
	public void testSelectById() {
		User user=dao.selectById(2);
		System.out.println(user);
		
	}

	@Test
	public void testDelete() {
		User user=new User();
		user.setId(4);
		dao.delete(user);
	}

	@Test
	public void testInsert() {
	User user=new User();
	user.setUsername("xiaoxiao");
	user.setAge(30);
	dao.insert(user);
	}

	@Test
	public void testUpdate() {
		User user=new User();
		user.setId(1);
		user.setAge(22);
		user.setUsername("xiaohei");
		dao.update(user);
	}
	@Test
	public void testSaveOrUpdate(){
		User user=new User();
		user.setId(6);
		user.setAge(25);
		user.setUsername("mmxxdd");
		dao.saveOrUpdate(user);
	}
	@Test
	public void testMerge(){
		User user=new User();
		user.setId(11);
		user.setAge(28);
		user.setUsername("mmmdd");
		dao.merge(user);
	}
}
