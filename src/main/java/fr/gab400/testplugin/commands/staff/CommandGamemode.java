package fr.gab400.testplugin.commands.staff;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class CommandGamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player player) {
            if (args.length == 1) {
                if (Objects.equals(args[0], "s")) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.DARK_RED + "Votre mode de jeu est passé en Survie");
                }
                else if (Objects.equals(args[0], "sp")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatColor.DARK_RED + "Votre mode de jeu est passé en Spectateur");
                }
                else if (Objects.equals(args[0], "c")) {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.DARK_RED + "Votre mode de jeu est passé en Créatif");
                }
                else if (Objects.equals(args[0], "a")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(ChatColor.DARK_RED +  "Votre mode de jeu est passé en Aventure");
                }
            } else {
                player.sendMessage(ChatColor.RED + "La commande est " + ChatColor.BLUE + "/gamemode <s/sp/c/a>");
                return false;
            }
        }
        return true;
    }
}
