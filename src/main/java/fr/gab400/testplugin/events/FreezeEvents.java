package fr.gab400.testplugin.events;

import fr.gab400.testplugin.utils.FreezeUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class FreezeEvents implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if (FreezeUtils.frozen_players.contains(player)) {
            e.setTo(e.getFrom());
            player.sendMessage(FreezeUtils.prefix + ChatColor.DARK_RED + "Tu est freeze !");
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        Entity entity = e.getEntity();
        if (entity instanceof Player && FreezeUtils.frozen_players.contains(entity)) {
            e.setCancelled(true);
        }
    }
}
