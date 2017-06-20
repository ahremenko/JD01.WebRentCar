package by.htp.ahremenko.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ahremenko.command.Command;
import by.htp.ahremenko.command.CommandProvider;

public class RentCarApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final CommandProvider provider = new CommandProvider();

    public RentCarApp() {
        super();
    }
    //^ циркумфлекс
    // квантификаторы - ? ленивый, * ревнивый, + - жадный ))
    
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*
		PrintWriter out = response.getWriter();
		Date date = new Date();
		String UserName = request.getParameter("Login");
		out.println("<html><body>" + "<h2>Dear "+UserName+"! Show me the way to the next whiskey-bar!</h2><br/><h3>Date="+date +"</h3>"+"</body></html>");
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String commandName = request.getParameter("command");
		Command command = provider.getCommand(commandName);
		command.execute(request, response);
	}
	
	
}
