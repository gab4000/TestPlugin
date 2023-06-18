package fr.gab400.testplugin.commands;

import fr.gab400.testplugin.TestPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class CommandHome implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player player) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.YELLOW + "Vos homes sont : ");
                for (String string : Objects.requireNonNull(TestPlugin.getInstance().getConfig().getConfigurationSection("home." + player.getUniqueId())).getKeys(false)) {
                    if (string == null) {
                        return false;
                    }
                    player.sendMessage(ChatColor.YELLOW + "- " + string);
                    return true;
                }
            }

            else if (args.length == 1) {
                player.sendMessage(ChatColor.DARK_RED + "Vous devez spécifier un argument !");
                return false;
            }

            else if (args.length == 2) {
                if (Objects.equals(args[0], "tp")) {
                    if (TestPlugin.getInstance().getConfig().contains("home."+player.getUniqueId().toString()+"."+args[1])) {
                        World w = Bukkit.getServer().getWorld(Objects.requireNonNull(TestPlugin.getInstance().getConfig().getString("home." + player.getUniqueId() + "." + args[1] + ".world")));
                        double x = TestPlugin.getInstance().getConfig().getDouble("home."+player.getUniqueId() + "."+args[1] + ".x");
                        double y = TestPlugin.getInstance().getConfig().getDouble("home."+player.getUniqueId() + "."+args[1] + ".y");
                        double z = TestPlugin.getInstance().getConfig().getDouble("home."+player.getUniqueId() + "."+args[1] + ".z");
                        double pitch = TestPlugin.getInstance().getConfig().getDouble("home."+player.getUniqueId() + "."+args[1] + ".pitch");
                        double yaw = TestPlugin.getInstance().getConfig().getDouble("home."+player.getUniqueId() + "."+args[1] + ".yaw");
                        player.teleport(new Location(w, x, y, z, (float) yaw, (float) pitch));
                        player.sendMessage(ChatColor.DARK_GREEN + "Vous avez été téléporté au home !");
                        return true;
                    }
                    else {
                        player.sendMessage(ChatColor.DARK_RED + "Ce home ne semble pas exister !");
                    }
                    return false;
                }
                else if (Objects.equals(args[0], "add")) {
                    if (args[1] != null) {
                        TestPlugin.getInstance().getConfig().set("home." + player.getUniqueId() + "." + args[1] + ".world", Objects.requireNonNull(player.getLocation().getWorld()).getName());
                        TestPlugin.getInstance().getConfig().set("home." + player.getUniqueId() + "." + args[1] + ".x", player.getLocation().getX());
                        TestPlugin.getInstance().getConfig().set("home." + player.getUniqueId() + "." + args[1] + ".y", player.getLocation().getY());
                        TestPlugin.getInstance().getConfig().set("home." + player.getUniqueId() + "." + args[1] + ".z", player.getLocation().getZ());
                        TestPlugin.getInstance().getConfig().set("home." + player.getUniqueId() + "." + args[1] + ".pitch", player.getEyeLocation().getPitch());
                        TestPlugin.getInstance().getConfig().set("home." + player.getUniqueId() + "." + args[1] + ".yaw", player.getEyeLocation().getYaw());
                        TestPlugin.getInstance().saveConfig();
                        player.sendMessage(ChatColor.DARK_GREEN + "Home ajouté !");
                        return true;
                    }
                }
                else if (Objects.equals(args[0], "del")) {
                    if (TestPlugin.getInstance().getConfig().contains("home."+player.getUniqueId() + "." + args[1])) {
                        TestPlugin.getInstance().getConfig().set("home."+player.getUniqueId() + "." + args[1], null);
                        TestPlugin.getInstance().saveConfig();
                        player.sendMessage(ChatColor.DARK_GREEN + "Home retiré !");
                        return true;
                    }
                    else {
                        player.sendMessage(ChatColor.DARK_RED + "Ce home ne semble pas exister !");
                        return false;
                    }
                }
            }

            else if (args.length > 3) {
                player.sendMessage(ChatColor.RED + "La commande est " + ChatColor.BLUE + "/home <add/tp/del> <nom>");
                return false;
            }

        } else {
            return false;
        }
        return true;
    }
}
