package com.mortella.pm;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import com.mortella.pm.Funcs;

public class MyPlugin extends JavaPlugin{
	public final Logger log = Logger.getLogger("Minecraft");
	public void onEnable(){
	 log.info("[MPM] v1.0 Plugin Enabled!");	
}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	    if(cmd.getName().equalsIgnoreCase("pm")){	    	
	    
	    	if(args.length >= 2){
	    		if (sender.getServer().getPlayer(args[0]) != null){
	    		Funcs func = new Funcs();
	    		String mensagem = func.getMensagem(args);
	    	  Player alvo = sender.getServer().getPlayer(args[0]);
	          alvo.sendMessage(ChatColor.YELLOW + "["+ ChatColor.GRAY + sender.getName() + ChatColor.YELLOW + "-PM]" + ChatColor.GREEN + mensagem);
	          sender.sendMessage(ChatColor.YELLOW + "PM sended!");
	          log.info("[MPM] The player " + sender.getName() + " sent PM to " + alvo.getDisplayName());
	          log.info("[MPM] Message:" +  mensagem);
	        }
	    }else if(args.length <= 1){
	    	sender.sendMessage(ChatColor.RED + "Error:");
	    	sender.sendMessage(ChatColor.RED + "Use: /mp <player> <message>");
	    	
	    }else{
	    	sender.sendMessage(ChatColor.RED + "Error! Can not find this player!");
	    }	      
	   
	}
	    return true;

	}
	
}
