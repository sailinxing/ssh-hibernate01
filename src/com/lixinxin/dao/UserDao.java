package com.lixinxin.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lixinxin.model.User;
import com.lixinxin.tools.DBUtils;

public class UserDao {
	public User selectById(Integer id) {
		Session session = DBUtils.findSession();		
		User user = (User) session.get(User.class, id);
//		User user= (User) session.load(User.class, id);
		session.close();
		return user;
	}
	public void delete(User user){
		Session session = DBUtils.findSession();
		Transaction ts = session.beginTransaction();
		try {
			session.delete(user);
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
		finally {
			session.close();
		}		
	}
	public void insert(User user){
		Session session = DBUtils.findSession();
		Transaction ts = session.beginTransaction();
		try {
			session.save(user);
			session.flush();
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
		finally {
			session.close();
		}		
	}
	public void update(User user){
		Session session = DBUtils.findSession();
		Transaction ts = session.beginTransaction();
		try {
			session.update(user);
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
		finally {
			session.close();
		}		
	}
	public void saveOrUpdate(User user){
		Session session = DBUtils.findSession();
		Transaction ts = session.beginTransaction();
		try {
			session.delete(user);
			session.saveOrUpdate(user); 
			session.flush();
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
		}
		finally {
			session.close();
		}
	}
	public void merge(User user){
		Session session = DBUtils.findSession();
		Transaction ts = session.beginTransaction();
		try {
			session.update(user);
			session.evict(user);
			User user1 = (User) session.get(User.class, user.getId());
			user.setUsername("sss");
//			session.update(user);
//			session.saveOrUpdate(user);
			System.out.println(user1);
			session.merge(user);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
		}
		finally {
			session.close();
		}
	}
}
