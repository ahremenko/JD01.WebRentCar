package by.htp.ahremenko.service.factory;

import by.htp.ahremenko.service.RentCarService;
import by.htp.ahremenko.service.impl.RentCarServiceImpl;

public class ServiceFactory {
private static final ServiceFactory instance = new ServiceFactory();
	
	private final RentCarService rentCarService = new RentCarServiceImpl();
	
	private ServiceFactory(){}
	
	public static ServiceFactory getInstance() {
		return instance;
	}
	
	public RentCarService getRentCarService() {
		return rentCarService;
	}
}