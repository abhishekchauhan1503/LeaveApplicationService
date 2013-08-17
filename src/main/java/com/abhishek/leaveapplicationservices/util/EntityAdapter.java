package com.abhishek.leaveapplicationservices.util;

import com.abhishek.leaveapplication.model.Application;
import com.abhishek.leaveapplication.model.Role;
import com.abhishek.leaveapplication.model.User;
import com.abhishek.leaveapplicationservice.entity.ApplicationEntity;
import com.abhishek.leaveapplicationservice.entity.RoleEntity;
import com.abhishek.leaveapplicationservice.entity.UserEntity;

public class EntityAdapter {

	public UserEntity userToEntity(User user){
		UserEntity userEntity = new UserEntity();
		userEntity.setId(user.getId());
		userEntity.setUserName(user.getUserName());
		userEntity.setPassword(user.getPassword());
		userEntity.setRoleType(roleToEntity(user.getRoleType()));
		if(user.getManagerId()!=null){
		userEntity.setManager(managerToEntity(user.getManagerId()));
		}
		return userEntity;
	}

	private UserEntity managerToEntity(User manager){
		UserEntity userEntity = new UserEntity();
		userEntity.setId(manager.getId());
		//userEntity.setUserName(manager.getUserName());
		//userEntity.setPassword(manager.getPassword());
		//userEntity.setRoleType(roleToEntity(manager.getRoleType()));
		return userEntity;
	}

	
	public RoleEntity roleToEntity(Role role) {
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setId(role.getRoleId());
		roleEntity.setName(role.getRoleName());
		return roleEntity;
	}
	
	public ApplicationEntity applicationToEntity(Application application){
		ApplicationEntity applicationEntity = new ApplicationEntity();
		applicationEntity.setContent(application.getContent());
		applicationEntity.setSubmissionDate(application.getSubmissionDate());
		applicationEntity.setStatus(application.getStatus());
		applicationEntity.setFrom(userToEntity(application.getFrom()));
		applicationEntity.setTo(userToEntity(application.getTo()));
		return applicationEntity;
	}
	
	public Role roleEntityToRole(RoleEntity roleEntity){
		Role role = new Role();
		role.setRoleId(roleEntity.getId());
		role.setRoleName(roleEntity.getName());
		return role;
		
	}
	
	public User userEntityToUser(UserEntity userEntity){
		User user = new User();
		if(userEntity.getId()>0){
		user.setId(userEntity.getId());
		}
		user.setPassword(userEntity.getPassword());
		user.setUserName(userEntity.getUserName());
		user.setRoleType(roleEntityToRole(userEntity.getRoleType()));
		if(userEntity.getManager()!=null){
			user.setManagerId(managerEntityToUser(userEntity.getManager()));
		}
		return user;
	}
	
	private User managerEntityToUser(UserEntity managerEntity){
		User manager = new User();
		if(managerEntity.getId()>0){
			manager.setId(managerEntity.getId());
		}
		//manager.setUserName(managerEntity.getUserName());
		//manager.setRoleType(roleEntityToRole(managerEntity.getRoleType()));
		return manager;
	}
	
	public Application applicationEntityToApplication(ApplicationEntity applicationEntity){
		Application application = new Application();
		if(applicationEntity.getId()!=0){
			application.setId(applicationEntity.getId());
		}
		application.setContent(applicationEntity.getContent());
		application.setId(applicationEntity.getId());
		application.setStatus(applicationEntity.getStatus());
		application.setSubmissionDate(applicationEntity.getSubmissionDate());
		application.setFrom(userEntityToUser(applicationEntity.getFrom()));
		application.setTo(managerEntityToUser(applicationEntity.getTo()));
		return application;
	}
}
