package fr.gab400.testplugin.utils;

import fr.gab400.testplugin.Core;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FreezeUtils {
    
    public static ArrayList<Player> frozen_players = Core.frozen_players;
    public static String prefix = ChatColor.GRAY + "[" + ChatColor.BLUE + "Freeze" + ChatColor.GRAY + "] ";

    public static void switch_freeze(Player player, Player target) {
        if (target == null) {
            player.sendMessage(prefix + ChatColor.DARK_RED + "Joueur introuvable !");
        } else {
            if (!frozen_players.contains(target)) {
                target.sendMessage(prefix + ChatColor.DARK_RED + "Tu a été freeze par " + ChatColor.BLUE + player.getDisplayName() + ChatColor.DARK_RED + " !");
                player.sendMessage(prefix + ChatColor.DARK_RED + "Vous avez freeze " + ChatColor.BLUE + target.getDisplayName() + ChatColor.DARK_RED + " !");
                frozen_players.add(target);
                PlayersMenuUtils.state = "§4Freeze";
            } else {
                target.sendMessage(prefix + ChatColor.DARK_GREEN + "Tu a été unfreeze par " + ChatColor.BLUE + player.getDisplayName() + ChatColor.DARK_GREEN + " !");
                player.sendMessage(prefix + ChatColor.DARK_GREEN + "Vous avez unfreeze " + ChatColor.BLUE + target.getDisplayName() + ChatColor.DARK_GREEN + " !");
                frozen_players.remove(target);
                PlayersMenuUtils.state = "§2Unfreeze";
            }
        }
    }
}
