package fr.gab400.testplugin.commands.staff;

import fr.gab400.testplugin.menus.PlayersMenu;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPlayers implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player player) {
            if (args.length != 0) {
                player.sendMessage(ChatColor.RED + "La commande est " + ChatColor.BLUE + "/players");
                return false;
            }
            PlayersMenu menu = new PlayersMenu(player);
            menu.open();
        } else {
            return false;
        }
        return true;
    }
}
