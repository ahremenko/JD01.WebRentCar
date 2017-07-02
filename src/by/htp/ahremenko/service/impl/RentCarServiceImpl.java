package by.htp.ahremenko.service.impl;

import by.htp.ahremenko.bean.User;
import by.htp.ahremenko.dao.DAOUser;
import by.htp.ahremenko.dao.exception.DAOException;
import by.htp.ahremenko.dao.factory.DAOFactory;
import by.htp.ahremenko.service.RentCarService;
import by.htp.ahremenko.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RentCarServiceImpl implements RentCarService {
	private static final Logger logger =LogManager.getRootLogger();
	
	@Override
	public User Authorization(String login, String password) throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			DAOUser user = daoObjectFactory.getDAOUser();
			User realUser = user.autorization(login,password);
			if (realUser != null) {
				return realUser;
			} 
		} catch ( DAOException e) {
			logger.error("Error on server:" + e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return null;
	}

	@Override
	public Collection GetAllUsers() throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			DAOUser user = daoObjectFactory.getDAOUser();
			Collection users = new ArrayList(); 
			users = user.getAllUsers();
			return users;
		} catch ( DAOException e) {
			logger.error("Error on server:" + e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public boolean deleteUserById(int id) throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			DAOUser user = daoObjectFactory.getDAOUser();
			return user.deleteUserById(id);
		} catch ( DAOException e) {
			logger.error("Error on server:" + e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public User getUserById(int id) throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			DAOUser user = daoObjectFactory.getDAOUser();
			User realUser = user.getUserById(id);
			if (realUser != null) {
				return realUser;
			} 
		} catch ( DAOException e) {
			logger.error("Error on server:" + e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return null;
	}
	
	@Override
	public boolean editUser(User usr) throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			DAOUser user = daoObjectFactory.getDAOUser();
			return user.editUser(usr);
		} catch ( DAOException e) {
			logger.error("Error on server:" + e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}

	
}
