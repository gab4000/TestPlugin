package fr.gab400.testplugin.enums;

import fr.gab400.testplugin.Core;
import fr.gab400.testplugin.events.FreezeEvents;
import fr.gab400.testplugin.events.JoinEvent;
import fr.gab400.testplugin.events.LeaveEvent;
import fr.gab400.testplugin.events.PlayersMenuEvents;
import org.bukkit.event.Listener;

public enum Events implements Listener {
	
	JOIN_EVENT(new JoinEvent(new Core())),
	LEAVE_EVENT(new LeaveEvent()),
	FREEZE_EVENTS(new FreezeEvents()),
	PLAYERS_MENU_EVENTS(new PlayersMenuEvents());
	
	public final Listener listener;
	
	Events(Listener listener) {
		this.listener = listener;
	}
}
