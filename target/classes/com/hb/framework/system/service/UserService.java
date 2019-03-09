package com.hb.framework.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hb.framework.superhelp.util.Md5Tool;
import com.hb.framework.superhelp.util.PageView;
import com.hb.framework.system.dao.UserDao;
import com.hb.framework.system.entity.Roles;
import com.hb.framework.system.entity.User;


@Transactional
@Service("userService")
public class UserService{
	@Autowired
	private UserDao userDao;

	public PageView query(PageView pageView, User user) {
		List<User> list = userDao.query(pageView, user);
		pageView.setRecords(list);
		return pageView;
	}

	public void add(User user) {
		String password=user.getUserPassword();
		if(password==null || "".equals(password.trim())){
			password="666666";
		}
		user.setUserPassword(Md5Tool.getMd5(password));
		userDao.add(user);
		
	}

	public void delete(String id) {
		userDao.delete(id);
		
	}

	public User getById(String id) {
		return userDao.getById(id);
	}

	public void modify(User user) {
		userDao.modify(user);
	}

	public int countUser(String userName, String userPassword) {
		return userDao.countUser(userName, userPassword);
	}

	public User querySingleUser(String userName) {
        System.out.println(userDao.querySingleUser(userName));
		return userDao.querySingleUser(userName);
	}

	public Roles findbyUserRole(String userId) {
		return userDao.findbyUserRole(userId);
	}
	
	public void test() {
		System.out.println("testestat");
	}
}
