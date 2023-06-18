package fr.gab400.testplugin;

import fr.gab400.testplugin.commands.CommandHome;
import fr.gab400.testplugin.commands.staff.*;
import fr.gab400.testplugin.events.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class TestPlugin extends JavaPlugin {

    public static TestPlugin instance;
    public static TestPlugin getInstance() {
        return instance;
    }

    public ArrayList<Player> invisible_list = new ArrayList<>();
    @Override
    public void onEnable() {

        instance = this;

        // Commands
        Objects.requireNonNull(getCommand("broadcast")).setExecutor(new CommandBroadcast(this));
        Objects.requireNonNull(getCommand("gamemode")).setExecutor(new CommandGamemode());
        Objects.requireNonNull(getCommand("home")).setExecutor(new CommandHome());
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new CommandVanish(this));
        Objects.requireNonNull(getCommand("top")).setExecutor(new CommandTop());
        Objects.requireNonNull(getCommand("players")).setExecutor(new CommandPlayers());
        Objects.requireNonNull(getCommand("freeze")).setExecutor(new CommandFreeze());

        // Events
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new LeaveEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayersMenuEvents(), this);
        getServer().getPluginManager().registerEvents(new FreezeEvents(), this);

    }

    public YamlConfiguration getConfig(String lang) {
        File file = new File(this.getDataFolder(), "/" + lang + ".yml");
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
        return configuration;
    }
}
