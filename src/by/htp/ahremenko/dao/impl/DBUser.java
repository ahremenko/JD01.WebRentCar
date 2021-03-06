package by.htp.ahremenko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ahremenko.bean.User;
import by.htp.ahremenko.dao.DAOUser;
import by.htp.ahremenko.dao.connection.ConnectionPool;
import by.htp.ahremenko.dao.connection.ConnectionPoolException;
import by.htp.ahremenko.dao.exception.DAOException;
import by.htp.ahremenko.service.exception.ServiceException;


public class DBUser implements DAOUser {
	private static final Logger logger =LogManager.getRootLogger();

	@Override
	public User autorization(String lgn, String pwd) throws DAOException {

		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection con = null;
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
			
		} catch (SQLException e) {
			logger.info("SQL-Exception: " + e.getMessage());
			throw new DAOException("SQL-Exception: " + e.getMessage());
		} finally {
			try {
				if (rs != null ){rs.close();}
			} catch (SQLException e) {
				throw new DAOException("SQL-Exception: " + e.getMessage());
			}
			try {
				if (ps != null){ ps.close();}
			} catch (SQLException e) {
				throw new DAOException("SQL-Exception: " + e.getMessage());
			}
			try {
				if (con != null) {con.close();}
			} catch (SQLException e) {
				throw new DAOException("SQL-Exception: " + e.getMessage());
			}
		}
		return user;
	}
	
	@Override
	public Collection getAllUsers() throws DAOException {
		
		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection users = new ArrayList();
		
		try {
		
			try {
				con = conPool.takeConnection();
			} catch (ConnectionPoolException e) {
				throw new DAOException("Can't take connection!");
			}
			String sqlQuery = "SELECT id, user_name, user_login, IFNULL(is_admin,0) FROM rentcar.rc_user WHERE rec_state = 1 order by id";
			ps = con.prepareStatement(sqlQuery);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getString(3), rs.getString(2));
				user.setId(rs.getInt(1));
				user.setIsAdmin( (rs.getInt(4) == 1 ? 1 : 0 ) );
	            users.add(user);
			}
			
		} catch (SQLException e) {
			logger.info("SQL-Exception: " + e.getMessage());
			throw new DAOException("SQL-Exception: " + e.getMessage());
		} finally {
			try {
				if (rs != null ){rs.close();}
			} catch (SQLException e) {
				throw new DAOException("SQL-Exception: " + e.getMessage());
			}
			try {
				if (ps != null){ ps.close();}
			} catch (SQLException e) {
				throw new DAOException("SQL-Exception: " + e.getMessage());
			}
			try {
				if (con != null) {con.close();}
			} catch (SQLException e) {
				throw new DAOException("SQL-Exception: " + e.getMessage());
			}
		}
		return users;
    }
	
	@Override
	public User getUserById( int id) throws DAOException {
		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			try {
				con = conPool.takeConnection();
			} catch (ConnectionPoolException e) {
				throw new DAOException("Can't take connection!");
			}
			String sqlQuery = "SELECT id, user_name, user_login, IFNULL(is_admin,0) FROM rentcar.rc_user WHERE rec_state = 1 and id = ?";
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString(3),rs.getString(2));
				user.setId(rs.getInt(1));
				user.setIsAdmin( (rs.getInt(4) == 1 ? 1 : 0 ) );
			}
			
		} catch (SQLException e) {
			logger.info("SQL-Exception: " + e.getMessage());
			throw new DAOException("SQL-Exception: " + e.getMessage());
		} finally {
			try {
				if (rs != null ){rs.close();}
			} catch (SQLException e) {
				throw new DAOException("SQL-Exception: " + e.getMessage());
			}
			try {
				if (ps != null){ ps.close();}
			} catch (SQLException e) {
				throw new DAOException("SQL-Exception: " + e.getMessage());
			}
			try {
				if (con != null) {con.close();}
			} catch (SQLException e) {
				throw new DAOException("SQL-Exception: " + e.getMessage());
			}
		}
		return user;
	}

	@Override
	public boolean deleteUserById(int id) throws DAOException {
		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			try {
				con = conPool.takeConnection();
			} catch (ConnectionPoolException e) {
				throw new DAOException("Can't take connection!");
			}
			String sqlQuery = "UPDATE rentcar.rc_user SET rec_state = 0 WHERE rec_state = 1 and id = ?";
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			logger.info("SQL-Exception: " + e.getMessage());
			throw new DAOException("SQL-Exception: " + e.getMessage());
		} finally {
			try {
				if (ps != null){ ps.close();}
			} catch (SQLException e) {
				throw new DAOException("SQL-Exception: " + e.getMessage());
			}
			try {
				if (con != null) {con.close();}
			} catch (SQLException e) {
				throw new DAOException("SQL-Exception: " + e.getMessage());
			}
		}
	}
	
	@Override
	public boolean editUser(User usr) throws DAOException {
		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			try {
				con = conPool.takeConnection();
			} catch (ConnectionPoolException e) {
				throw new DAOException("Can't take connection!");
			}
			
			String sqlQuery = null;
			if (usr.getId() > 0 ) {
				sqlQuery = "UPDATE rentcar.rc_user SET user_name = ?, user_login = ?, user_password = ?, is_admin = ? WHERE id = ?";
			} else {
				sqlQuery = "INSERT INTO rentcar.rc_user (user_name, user_login, user_password, is_admin ) VALUES ( ?, ?, ?, ?)";
			}
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, usr.getName());
			ps.setString(2, usr.getLogin());
			ps.setString(3, usr.getPassword());
			ps.setInt(4, usr.getIsAdmin());
			if (usr.getId() > 0 ) {
				ps.setInt(5, usr.getId());
			}	
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			logger.info("SQL-Exception: " + e.getMessage());
			throw new DAOException("SQL-Exception: " + e.getMessage());
		} finally {
			try {
				if (ps != null){ ps.close();}
			} catch (SQLException e) {
				throw new DAOException("SQL-Exception: " + e.getMessage());
			}
			try {
				if (con != null) {con.close();}
			} catch (SQLException e) {
				throw new DAOException("SQL-Exception: " + e.getMessage());
			}
		}
		
	}
	

}
