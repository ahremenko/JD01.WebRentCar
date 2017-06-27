package by.htp.ahremenko.dao.factory;


import by.htp.ahremenko.dao.DAOUser;
import by.htp.ahremenko.dao.impl.DBUser;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	
	
	private final DAOUser dbUser = new DBUser();
		
	private DAOFactory(){
	}
	
	public static DAOFactory getInstance() {
		return instance;
	}
	
	public DAOUser getDAOUser() {
		return dbUser;
	}
	
	
}
