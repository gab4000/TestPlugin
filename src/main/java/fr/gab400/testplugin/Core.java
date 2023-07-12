package fr.gab400.testplugin;

import fr.gab400.testplugin.managers.CommandManager;
import fr.gab400.testplugin.managers.EventManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Core extends JavaPlugin {
	
	public static Core instance;
	public ArrayList<Player> invisible_list = new ArrayList<>();
	
	public static Core getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		
		instance = this;
		
		CommandManager commandManager = new CommandManager(this);
		EventManager eventManager = new EventManager(this);
	}
}
