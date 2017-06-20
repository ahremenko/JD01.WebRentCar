package by.htp.ahremenko.service;

import by.htp.ahremenko.service.impl.UserServiceImpl;

public class ServiceFactory {
private static final ServiceFactory instance = new ServiceFactory();
	
	private final UserServiceImpl userService = new UserServiceImpl();
	
	private ServiceFactory(){}
	
	public static ServiceFactory getInstance() {
		return instance;
	}
	
	public UserService getUserService() {
		return userService;
	}
}
