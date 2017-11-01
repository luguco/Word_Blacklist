package me.luguco.word_blacklist;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.List;

/**
 * Created by luguco on 28.10.2017.
 */
public class Command implements CommandExecutor {
    private Main plugin;
    public Command(Main main) {
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("Du musst ein Spieler sein, um diesen Command zu benutzen!");
            return true;
        }

        Player p = (Player) sender;

        if(!p.hasPermission("wbl")){
            p.sendMessage(Msg.prefix() + Msg.noperm());
            return true;
        }

        if(args.length == 0){
            p.sendMessage(Msg.prefix() + Msg.usage());
            return true;
        }


        if(args[0].equalsIgnoreCase("add")){
            if(!p.hasPermission("wbl.add")){
                p.sendMessage(Msg.prefix() + Msg.noperm());
                return true;
            }
            plugin.reloadConfig();
            if(args.length < 2){
                p.sendMessage(Msg.prefix() + Msg.usage());
                return true;
            }
            String toadd = args[1];
            List<String> blwords = plugin.blcfg.getStringList("Words");

            if(blwords.contains(toadd)){
                p.sendMessage(Msg.prefix() + Msg.inList().replace("%word%", toadd));
                return true;
            }

            blwords.add(toadd);
            plugin.blcfg.set("Words" , blwords);
            try {
                plugin.blcfg.save(plugin.bl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            p.sendMessage(Msg.prefix() + Msg.addWord().replace("%word%", toadd));

        }else if(args[0].equalsIgnoreCase("remove")){
            if(!p.hasPermission("wbl.remove")){
                p.sendMessage(Msg.prefix() + Msg.noperm());
                return true;
            }
            if(args.length < 2){
                p.sendMessage(Msg.prefix() + Msg.usage());
                return true;
            }
            String toremove= args[1];
            List<String> blwords = plugin.blcfg.getStringList("Words");
            if(!blwords.contains(toremove)){
                p.sendMessage(Msg.prefix() + Msg.notinList().replace("%word%", toremove));
                return true;
            }

            blwords.remove(toremove);
            plugin.blcfg.set("Words" , blwords);
            try {
                plugin.blcfg.save(plugin.bl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            p.sendMessage(Msg.prefix() + Msg.removeWord().replace("%word%", toremove));


        }else if(args[0].equalsIgnoreCase("show")){
            if(!p.hasPermission("wbl.show")){
                p.sendMessage(Msg.prefix() + Msg.noperm());
                return true;
            }
            List<String> blwords = plugin.blcfg.getStringList("Words");
            p.sendMessage(blwords.toString());


        }else{
            p.sendMessage(Msg.prefix() + Msg.usage());
        }
        return true;
    }
}
