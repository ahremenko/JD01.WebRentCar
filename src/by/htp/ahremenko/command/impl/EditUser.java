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
		
		int answer = checkAction(request);
		String userId = request.getParameter("userId");
		String login = request.getParameter("userLogin");
		String password = request.getParameter("userPassword");
		String isAdmin = request.getParameter("isAdmin");
		
		logger.info("Start editUser() command!   answer: " + answer + ", userId: " + userId );
		
		try {
			
			if (answer == 3) {
				//delete user
				 if (userId != null) {
					    if (rentCarService.deleteUserById(Integer.parseInt(userId))) {
					    	request.setAttribute("infoMessage", "User was deleted.");
					    } else {
					    	request.setAttribute("errorMessage", "User was not deleted! See log, please.");
					    }	
		         }
				 Collection users = rentCarService.GetAllUsers();
				 request.setAttribute("users", users);
				 page = "WEB-INF/jsp/admin.jsp";
			}
			
			/*
  		    User user = rentCarService.Authorization(login, password);
			if (user!=null) {
				Cookie sessionId = new Cookie("sessionId", sessionPool.addNewSession(user.getId()) );
				request.setAttribute("user", user);
				response.addCookie(sessionId);
				if (user.getIsAdmin()==1) {
					Collection users = rentCarService.GetAllUsers();
					request.setAttribute("users", users);
					page = "WEB-INF/jsp/admin.jsp";
				} else {
					page = "WEB-INF/jsp/main.jsp";
				}	
			} else {
				request.setAttribute("errorMessage", "User not found or wrong password!");
				page = "index.jsp";
			}*/
		} catch (ServiceException e){
			request.setAttribute("errorMessage", "Error: " + e.getMessage());
			page = "error.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
	}
	
	private int checkAction(HttpServletRequest req) {
        if (req.getParameter("Add") != null) {
            return 1;
        }
        if (req.getParameter("Edit") != null) {
            return 2;
        }
        if (req.getParameter("Delete") != null) {
        	return 3;
        }
        return 0;
    }
	

}
