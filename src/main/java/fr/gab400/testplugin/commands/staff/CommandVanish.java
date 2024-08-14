package fr.gab400.testplugin.commands.staff;

import fr.gab400.testplugin.Core;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandVanish implements CommandExecutor {

    Core core;

    public CommandVanish(Core plugin) {
        this.core = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player player) {

            if (args.length != 0) {
                player.sendMessage(ChatColor.RED + "La commande est " + ChatColor.BLUE + "/vanish");
                return false;
            }

            if (! core.invisible_list.contains(player)) {
                for (Player people : Bukkit.getOnlinePlayers()) {
                    people.hidePlayer(core, player);
                }
                core.invisible_list.add(player);
                player.sendMessage(ChatColor.RED + "Vous êtes désormais invisible sur le serveur.");
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.AQUA + "Vanish activé"));

            } else {
                for (Player people : Bukkit.getOnlinePlayers()) {
                    people.showPlayer(core, player);
                }
                core.invisible_list.remove(player);
                player.sendMessage(ChatColor.RED + "Vous êtes désormais visible sur le serveur.");
            }
        } else {
            return false;
        }
        return true;
    }
}
