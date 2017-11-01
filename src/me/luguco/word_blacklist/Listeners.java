package me.luguco.word_blacklist;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.IOException;
import java.util.List;

/**
 * Created by luguco on 28.10.2017.
 */
public class Listeners implements Listener {
    private Main plugin;

    boolean badword = false;
    private String sbadword;
    public Listeners(Main main) {
        this.plugin = main;
        this.plugin.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){

        try {
            plugin.blcfg.save(plugin.bl);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        badword = false;
        Player p = e.getPlayer();

        String message = e.getMessage();

        List<String> words = plugin.blcfg.getStringList("Words");

        for( String word : words) {
            sbadword = word;
            String bword = word.toUpperCase();
            message = message.toUpperCase();

            if (message.contains(bword)) {
                badword = true;
                break;
            }
        }
        if (badword) {
            p.sendMessage(Msg.prefix() + Msg.messageDenied().replace("%word%", sbadword));
            e.setCancelled(true);
        }
    }
}
