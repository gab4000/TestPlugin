package fr.gab400.testplugin.enums;

import fr.gab400.testplugin.Core;
import fr.gab400.testplugin.commands.CommandHome;
import fr.gab400.testplugin.commands.staff.*;
import org.bukkit.command.CommandExecutor;

public enum Commands {
	
	HOME("home", new CommandHome()),
	BROADCAST("bradcast", new CommandBroadcast(new Core())),
	VANISH("vanish", new CommandVanish(new Core())),
	GAMEMODE("gamemode", new CommandGamemode()),
	PLAYERS("players", new CommandPlayers()),
	TOP("top", new CommandTop()),
	FREEZE("freeze", new CommandFreeze());
	
	public final String command;
	public final CommandExecutor cls;
	
	Commands(String command, CommandExecutor cls) {
		this.command = command;
		this.cls = cls;
	}
}
