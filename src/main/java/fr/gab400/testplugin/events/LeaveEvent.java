package fr.gab400.testplugin.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Bukkit.broadcastMessage("[§4-§r] §9" + e.getPlayer().getName() + " §4a quitté le serveur !");
    }

}
