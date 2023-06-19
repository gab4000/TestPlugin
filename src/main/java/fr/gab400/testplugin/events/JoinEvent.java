package fr.gab400.testplugin.events;

import fr.gab400.testplugin.Core;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    Core plugin;

    public JoinEvent(Core plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Bukkit.broadcastMessage("[§2+§r] §9" + e.getPlayer().getName() + " §2a rejoint le serveur !");

        for (int i = 0; i < plugin.invisible_list.size(); i++) {
            e.getPlayer().hidePlayer(plugin, plugin.invisible_list.get(i));
        }
    }

}
