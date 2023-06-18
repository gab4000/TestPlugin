package fr.gab400.testplugin.commands.staff;

import fr.gab400.testplugin.utils.FreezeUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFreeze implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player player) {
            if (args.length == 1) {
                Player target = player.getServer().getPlayer(args[0]);

                if (target == null) {
                    player.sendMessage(ChatColor.RED + "Ce joueur n'existe pas ou n'est pas connecté");
                    return false;
                }

                FreezeUtils.switch_freeze(player, target);
            } else {
                player.sendMessage(ChatColor.RED + "La commande est " + ChatColor.BLUE + "/freeze <joueur>");
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
}
