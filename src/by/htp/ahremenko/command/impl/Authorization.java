package by.htp.ahremenko.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ahremenko.command.Command;
import by.htp.ahremenko.domain.User;
import by.htp.ahremenko.service.ServiceFactory;
import by.htp.ahremenko.service.UserService;

public class Authorization implements Command {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// check login and password here
		// dispatcher
		// do 
		
		String login = request.getParameter("Login");
		String password = request.getParameter("password");
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		
		User user = userService.Authorization(login, password);
		String page;
		if (user!=null) {
			request.setAttribute("user", user);
			page = "WEB-INF/jsp/main.jsp";
		} else {
			request.setAttribute("errorMessage", "Wrong password!");
			page = "index.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
	}
	

}
