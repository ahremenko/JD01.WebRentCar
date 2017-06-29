package by.htp.ahremenko.command.impl;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ahremenko.command.Command;
import by.htp.ahremenko.command.SessionPool;
import by.htp.ahremenko.bean.User;
import by.htp.ahremenko.service.factory.ServiceFactory;
import by.htp.ahremenko.service.RentCarService;
import by.htp.ahremenko.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Authorization implements Command {

	private static final Logger logger = LogManager.getRootLogger();
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// check login and password 		
		String login = request.getParameter("Login");
		String password = request.getParameter("password");
		ServiceFactory factory = ServiceFactory.getInstance();
		RentCarService rentCarService = factory.getRentCarService();
		SessionPool sessionPool = SessionPool.getInstance();
		String page;
		try {
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
			}
		} catch (ServiceException e){
			request.setAttribute("errorMessage", "Error: " + e.getMessage());
			page = "error.jsp";
		}
		
		//logger.info("Current sessionPool: " + sessionPool.toString());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
	}
	

}
