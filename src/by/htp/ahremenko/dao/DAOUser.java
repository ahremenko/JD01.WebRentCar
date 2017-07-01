package by.htp.ahremenko.dao;

import java.util.Collection;

import by.htp.ahremenko.bean.User;
import by.htp.ahremenko.dao.exception.DAOException;
import by.htp.ahremenko.service.exception.ServiceException;

public interface DAOUser {
	
	public User autorization(String lgn, String pwd) throws DAOException;
	public Collection getAllUsers() throws DAOException;
	public User getUserById(int id) throws DAOException;
	public boolean deleteUserById(int id) throws DAOException;
	//public String EditUser(String lgn, String pwd, String nm);
	
}
