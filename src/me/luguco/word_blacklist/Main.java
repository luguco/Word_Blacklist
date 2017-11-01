package me.luguco.word_blacklist;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by luguco on 28.10.2017.
 */
public class Main extends JavaPlugin {

    public  static File bl = new File("plugins/Word_Blacklist", "blacklist.yml");
    public static YamlConfiguration blcfg = YamlConfiguration.loadConfiguration(bl);

    public  static File msg = new File("plugins/Word_Blacklist", "messages.yml");
    public static YamlConfiguration msgcfg = YamlConfiguration.loadConfiguration(msg);



    @Override
    public void onEnable() {
        new Listeners(this);
        new Msg(this);
        new LoadMessages(this);

        LoadMessages.loadFile();
        Command cCommand = new Command(this);
        getCommand("wordblacklist").setExecutor(cCommand);
        Bukkit.getConsoleSender().sendMessage("§b[Word_Blacklist] enabled!");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§b[Word_Blacklist] disabled!");
    }

}
