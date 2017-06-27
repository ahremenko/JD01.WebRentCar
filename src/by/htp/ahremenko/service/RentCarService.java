package by.htp.ahremenko.service;

import by.htp.ahremenko.bean.User;
import by.htp.ahremenko.service.exception.ServiceException;

public interface RentCarService {
		
		public User Authorization (String login, String password) throws ServiceException;

}



