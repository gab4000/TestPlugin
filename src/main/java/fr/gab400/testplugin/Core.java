package fr.gab400.testplugin;

import dev.xernas.menulib.MenuLib;
import fr.gab400.testplugin.commands.CommandHome;
import fr.gab400.testplugin.commands.staff.*;
import fr.gab400.testplugin.events.FreezeEvents;
import fr.gab400.testplugin.events.JoinEvent;
import fr.gab400.testplugin.events.LeaveEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Objects;

public class Core extends JavaPlugin {
	
	public static Core instance;
	public ArrayList<Player> invisible_list = new ArrayList<>();
	public static ArrayList<Player> frozen_players = new ArrayList<>();
	
	public static Core getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		
		instance = this;
		
		MenuLib.init(this);
		
		Objects.requireNonNull(getCommand("home")).setExecutor(new CommandHome());
		Objects.requireNonNull(getCommand("players")).setExecutor(new CommandPlayers());
		Objects.requireNonNull(getCommand("broadcast")).setExecutor(new CommandBroadcast(this));
		Objects.requireNonNull(getCommand("top")).setExecutor(new CommandTop());
		Objects.requireNonNull(getCommand("freeze")).setExecutor(new CommandFreeze());
		Objects.requireNonNull(getCommand("gamemode")).setExecutor(new CommandGamemode());
		Objects.requireNonNull(getCommand("vanish")).setExecutor(new CommandVanish(this));
		
		
		getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		getServer().getPluginManager().registerEvents(new LeaveEvent(), this);
		getServer().getPluginManager().registerEvents(new FreezeEvents(), this);
	}
}
