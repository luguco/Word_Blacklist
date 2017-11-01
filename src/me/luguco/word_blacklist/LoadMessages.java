package me.luguco.word_blacklist;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by luguco on 28.10.2017.
 */
public class LoadMessages {

    private static Main plugin;
    private static ArrayList<String> words = new ArrayList<>();
    public LoadMessages(Main main) {
        this.plugin = main;
    }

    public static void loadFile(){
        if(!plugin.bl.exists()){
            try {
                plugin.bl.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!plugin.blcfg.contains("Words")){
            words.add("Penis");
            plugin.blcfg.set("Words", words);
        }

        if(!plugin.msg.exists()){
            try {
                plugin.msg.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!plugin.msgcfg.contains("Prefix")){
            plugin.msgcfg.set("Prefix", "§5[Word_Blacklist]§r ");
        }

        if(!plugin.msgcfg.contains("Usage")){
            plugin.msgcfg.set("Usage", "§bNutze: /wordblacklist [add|remove|show] <word>!");
        }

        if(!plugin.msgcfg.contains("NoPerm")){
            plugin.msgcfg.set("NoPerm", "§cDu hast keine Rechte, um diesen Befehl zu nutzen!");
        }

        if(!plugin.msgcfg.contains("AddWord")){
            plugin.msgcfg.set("AddWord", "§aDu hast das Wort '§b%word%§a' erfolgreich hinzugefügt!");
        }

        if(!plugin.msgcfg.contains("RemoveWord")){
            plugin.msgcfg.set("RemoveWord", "§aDu hast das Wort '§b%word%§a' erfolgreich gelöscht!");
        }

        if(!plugin.msgcfg.contains("InList")){
            plugin.msgcfg.set("InList", "§cDas Wort '§b%word%§c' ist bereits in der Blacklist!");
        }

        if(!plugin.msgcfg.contains("NotInList")){
            plugin.msgcfg.set("NotInList", "§cDas Wort '§b%word%§c' ist nicht in der Blacklist!");
        }

        if(!plugin.msgcfg.contains("MessageDenied")){
            plugin.msgcfg.set("MessageDenied", "§cDu darft das Wort '§4%word%§c' nicht benutzen!");
        }

        try {
            plugin.blcfg.save(plugin.bl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            plugin.msgcfg.save(plugin.msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
