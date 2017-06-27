package by.htp.ahremenko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ahremenko.bean.User;
import by.htp.ahremenko.dao.DAOUser;
import by.htp.ahremenko.dao.connection.ConnectionPool;
import by.htp.ahremenko.dao.connection.ConnectionPoolException;
import by.htp.ahremenko.dao.exception.DAOException;


public class DBUser implements DAOUser {
	private static final Logger logger =LogManager.getRootLogger();

	@Override
	public User Autorization(String lgn, String pwd) throws DAOException {

		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
		
			try {
				con = conPool.takeConnection();
			} catch (ConnectionPoolException e) {
				throw new DAOException("Can't take connection!");
			}
			//logger.info("Start with prepareStatement!");
			String sqlQuery = "SELECT id, IFNULL(is_admin,0) FROM rentcar.rc_user WHERE rec_state = 1 and user_login = ? and user_password = ?";
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, lgn);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			//logger.info("get rows: "+ps.getMaxRows());
			//logger.info("row #: " + rs.getRow());
			while (rs.next()) {
				//logger.info("row: " + rs.getInt(1) + " " + rs.getInt(2));
				user = new User(lgn);
				user.setId(rs.getInt(1));
				user.setIsAdmin( (rs.getInt(2) == 1 ? 1 : 0 ) );
			}
			
			/*
			st = con.createStatement();
			
			rs = st.executeQuery("SELECT user_login, user_password, is_admin FROM rentcar.rc_user WHERE rec_state = 1");
			while (rs.next()) {
				if ( rs.getString(1).equals(lgn)) {
					if (rs.getString(2).equals(pwd)) {
						user = new User(lgn);
						user.setIsAdmin( (rs.getInt(3) == 1 ? 1 : 0 ) );
					}
				}	
			}*/
					
		} catch (SQLException e) {
			logger.info("SQL-Exception: " + e.getMessage());
			throw new DAOException("SQL-Exception: " + e.getMessage());
		} finally {
			try {
				if (rs != null ){rs.close();}
				if (st != null){ st.close();}
				if (ps != null){ ps.close();}
				if (con != null) {con.close();}
			} catch (SQLException e) {
				throw new DAOException("SQL-Exception: " + e.getMessage());
			}
		}
		
		return user;
	}

	/*@Override
	public String EditUser(String lgn, String pwd, String nm) {
		return null;
	}*/
	

}
