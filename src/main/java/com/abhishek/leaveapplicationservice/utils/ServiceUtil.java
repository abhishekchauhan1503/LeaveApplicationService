package com.abhishek.leaveapplicationservice.utils;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import com.abhishek.leaveapplication.model.User;
import com.abhishek.leaveapplication.utils.Util;
import com.abhishek.leaveapplicationservice.servicesimpl.UserServicesImpl;

@Service
@ContextConfiguration(locations = { "classpath:/META-INF/spring/service-context.xml" })
public class ServiceUtil {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/spring/service-context.xml");
		BeanFactory factory = context;
		User user = (User) factory.getBean("userTest");// new User();
		UserServicesImpl userServicesImpl = (UserServicesImpl) factory
				.getBean("userService");
		userServicesImpl.createUser(user);
		System.out.println(user.getUserName());
	}

}
