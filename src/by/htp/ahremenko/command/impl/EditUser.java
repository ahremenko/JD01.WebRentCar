package by.htp.ahremenko.command.impl;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ahremenko.bean.User;
import by.htp.ahremenko.command.Command;
import by.htp.ahremenko.command.SessionPool;
import by.htp.ahremenko.service.RentCarService;
import by.htp.ahremenko.service.exception.ServiceException;
import by.htp.ahremenko.service.factory.ServiceFactory;

public class EditUser implements Command {

	private static final Logger logger = LogManager.getRootLogger();
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// add or remove or edit user
		
		ServiceFactory factory = ServiceFactory.getInstance();
		RentCarService rentCarService = factory.getRentCarService();
		SessionPool sessionPool = SessionPool.getInstance();
		String page = "";		
		String userId = request.getParameter("userId");
		
		
		try {
			
			 if (request.getParameter("Delete") != null) {
   			     //logger.info("Start deleteUserById ( " + userId + " ) ");
				 if (!userId.equals(null)) {
					    if (rentCarService.deleteUserById(Integer.parseInt(userId))) {
					    	request.setAttribute("infoMessage", "User was deleted successfully.");
					    } else {
					    	request.setAttribute("errorMessage", "User was not deleted!");
					    }	
		         }
				 //logger.info("deleteUserById done." );
				 Collection users = rentCarService.GetAllUsers();
				 //logger.info("GetAllUsers() done." );
				 request.setAttribute("users", users);
				 //logger.info("setAttribute(users) done." );
				 page = "WEB-INF/jsp/admin.jsp";
			}
			
			if (request.getParameter("Edit") != null) {
				if (!userId.equals(null)) {
					User user4Edit = rentCarService.getUserById(Integer.parseInt(userId));
					request.setAttribute("user4Edit", user4Edit);
					page = "WEB-INF/jsp/edituser.jsp";
				}
			}
			
			if (request.getParameter("Add") != null) {
				User user4Edit = new User("");
				user4Edit.setId(0);
				user4Edit.setIsAdmin(0);
				request.setAttribute("user4Edit", user4Edit);
				page = "WEB-INF/jsp/edituser.jsp";
			}
			
			if (request.getParameter("OK") != null) {
  			    logger.info("Start EditUser ( " + userId + " ) ");				
				String nm = request.getParameter("userName");
				String login = request.getParameter("userLogin");
				String password = request.getParameter("userPassword");
				String isAdmin = request.getParameter("isAdmin");
				User user4Edit = new User(login,nm);
				user4Edit.setPassword(password);
				user4Edit.setId(Integer.parseInt(userId));
				user4Edit.setIsAdmin(Integer.parseInt(isAdmin));
			    if (rentCarService.editUser(user4Edit)) {
			    	request.setAttribute("infoMessage", "User was added or updated successfully.");
			    } else {
			    	request.setAttribute("errorMessage", "User was not added or updated!");
			    }
				Collection users = rentCarService.GetAllUsers();
			    request.setAttribute("users", users);
				page = "WEB-INF/jsp/admin.jsp";
			}

			if (request.getParameter("Cancel") != null) {
				Collection users = rentCarService.GetAllUsers();
			    request.setAttribute("users", users);
				page = "WEB-INF/jsp/admin.jsp";
			}
			
			Cookie[] cookie = request.getCookies();
			for (Cookie cook : cookie){
				if (cook.getName().equals("sessionId")) {
					int currentuserId = sessionPool.getUserIdBySessionId(cook.getValue());
					User user = rentCarService.getUserById(currentuserId);
					request.setAttribute("user", user);
				}	
			}	
			 
		} catch (ServiceException e){
			request.setAttribute("errorMessage", "Error: " + e.getMessage());
			page = "error.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		//logger.info("getRequestDispatcher done. page: " + page);
		dispatcher.forward(request, response);
		//logger.info("forward done");

		
	}
	
}
