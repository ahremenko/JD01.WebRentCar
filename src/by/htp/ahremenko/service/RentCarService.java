package by.htp.ahremenko.service;

import java.util.Collection;

import by.htp.ahremenko.bean.User;
import by.htp.ahremenko.service.exception.ServiceException;

public interface RentCarService {
		
		public User Authorization (String login, String password) throws ServiceException;

		public Collection GetAllUsers() throws ServiceException;
		
		public boolean deleteUserById(int id) throws ServiceException;
		
		public User getUserById(int id) throws ServiceException;

}



