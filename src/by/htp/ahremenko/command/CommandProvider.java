package by.htp.ahremenko.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.ahremenko.command.impl.Authorization;
import by.htp.ahremenko.command.impl.EditUser;
import by.htp.ahremenko.command.impl.GetAllUsers;
import by.htp.ahremenko.command.Command;

public class CommandProvider {
	
	private Map<Commands, Command> commands = new HashMap<Commands, Command>();

	public CommandProvider(){
		commands.put(Commands.AUTHORIZATION, new Authorization());		
		commands.put(Commands.GETALLUSERS, new GetAllUsers());
		commands.put(Commands.EDITUSER, new EditUser());
	}
	
	public Command getCommand(String commandName){
		return commands.get(Commands.valueOf(commandName.toUpperCase()));		
	}

}
