package fr.gab400.testplugin.managers;

import fr.gab400.testplugin.Core;
import fr.gab400.testplugin.enums.Events;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EventManager implements Listener {
	
	Core core;
	
	public EventManager(Core core) {
		this.core = core;
	}
	
	@EventHandler
	public void onEvent(Event e) {
		for (Events event : Events.values()) {
			this.core.getServer().getPluginManager().registerEvents(event.listener, this.core);
		}
	}
}
