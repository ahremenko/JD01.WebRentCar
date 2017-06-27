package by.htp.ahremenko.dao;

import by.htp.ahremenko.bean.User;
import by.htp.ahremenko.dao.exception.DAOException;

public interface DAOUser {
	
	public User Autorization(String lgn, String pwd) throws DAOException;
	//public String EditUser(String lgn, String pwd, String nm);
	
}
