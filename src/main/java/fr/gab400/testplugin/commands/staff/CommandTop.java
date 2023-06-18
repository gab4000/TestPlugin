package fr.gab400.testplugin.commands.staff;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class CommandTop implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player p) {

            if (args.length != 0) {
                p.sendMessage(ChatColor.RED + "La commande est " + ChatColor.BLUE + "/top");
                return false;
            }

            Location loc = p.getLocation();
            int x = loc.getBlockX();
            int z = loc.getBlockZ();

            double y = Objects.requireNonNull(loc.getWorld()).getHighestBlockYAt(x, z);

            p.teleport(new Location(p.getWorld(), x, y + 1, z, loc.getYaw(), loc.getPitch()));

        } else {
            return false;
        }
        return true;
    }
}
