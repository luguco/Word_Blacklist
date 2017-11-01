package me.luguco.word_blacklist;

/**
 * Created by luguco on 28.10.2017.
 */
public class Msg {

    private static Main plugin;
    public Msg(Main main) {
        this.plugin = main;
    }

    public static String prefix(){
        return plugin.msgcfg.getString("Prefix");
    }

    public static String usage(){
        return plugin.msgcfg.getString("Usage");
    }

    public static String noperm(){
        return plugin.msgcfg.getString("NoPerm");
    }

    public static String addWord(){
        return plugin.msgcfg.getString("AddWord");
    }

    public static String removeWord(){
        return plugin.msgcfg.getString("RemoveWord");
    }

    public static String inList(){
        return plugin.msgcfg.getString("InList");
    }

    public static String notinList(){
        return plugin.msgcfg.getString("NotInList");
    }

    public static String messageDenied(){
        return plugin.msgcfg.getString("MessageDenied");
    }
}
