package by.htp.ahremenko.dao;

import java.util.Collection;

import by.htp.ahremenko.bean.User;
import by.htp.ahremenko.dao.exception.DAOException;

public interface DAOUser {
	
	public User Autorization(String lgn, String pwd) throws DAOException;
	public Collection getAllUsers() throws DAOException;
	//public String EditUser(String lgn, String pwd, String nm);
	
}
