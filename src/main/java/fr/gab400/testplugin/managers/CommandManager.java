package fr.gab400.testplugin.managers;

import fr.gab400.testplugin.Core;
import fr.gab400.testplugin.enums.Commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class CommandManager implements CommandExecutor {
	
	Core core;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		for (Commands command : Commands.values()) {
			Objects.requireNonNull(this.core.getCommand(command.command)).setExecutor(command.cls);
		}
		return true;
	}
	
	public CommandManager(Core core) {
		this.core = core;
	}
}
