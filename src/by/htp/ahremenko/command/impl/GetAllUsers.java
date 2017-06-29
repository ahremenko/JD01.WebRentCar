package by.htp.ahremenko.command.impl;

import java.io.IOException;
import java.util.ArrayList;
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

public class GetAllUsers implements Command {

		private static final Logger logger = LogManager.getRootLogger();
		
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
			
			ServiceFactory factory = ServiceFactory.getInstance();
			RentCarService rentCarService = factory.getRentCarService();
			SessionPool sessionPool = SessionPool.getInstance();
			 
			String page;
			try {
				Collection users = rentCarService.GetAllUsers();
				request.setAttribute("users", users);
				page = "WEB-INF/jsp/admin.jsp";
			} catch (ServiceException e){
				request.setAttribute("errorMessage", "Error: " + e.getMessage());
				page = "error.jsp";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		}
}
