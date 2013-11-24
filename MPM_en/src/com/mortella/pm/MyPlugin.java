package com.mortella.pm;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import com.mortella.pm.Funcs;

public class MyPlugin extends JavaPlugin{
	public void onEnable(){
	 getLogger().info("Plugin Enabled!");	
}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	    if(cmd.getName().equalsIgnoreCase("pm")){	    	
	    
	    	if(args.length >= 2){
	    		if (sender.getServer().getPlayer(args[0]) != null){
	    		Funcs func = new Funcs();
	    		String mensagem = func.getMensagem(args);
	    	  Player alvo = sender.getServer().getPlayer(args[0]);
	    	  if (sender instanceof Player){
	          alvo.sendMessage(ChatColor.YELLOW + "["+ ChatColor.GRAY + sender.getName() + ChatColor.YELLOW + "-PM]" + ChatColor.GREEN + mensagem);
	    	  }else{
	    	  alvo.sendMessage(ChatColor.YELLOW + "["+ ChatColor.MAGIC + sender.getName() + ChatColor.YELLOW + "-PM]" + ChatColor.GREEN + mensagem);  
	    	  }
	          sender.sendMessage(ChatColor.YELLOW + "PM Sent!");
	          getLogger().info("[MPM] The player " + sender.getName() + " sent PM to " + alvo.getDisplayName());
	          getLogger().info("[MPM] Message:" +  mensagem);
	        }else{
	        	sender.sendMessage(ChatColor.RED + "Error! Cannot find that user.");
	        }
	    }else if(args.length <= 1){
	    	sender.sendMessage(ChatColor.RED + "Error:");
	    	sender.sendMessage(ChatColor.RED + "Use: /mp <player> <message>");
	    	
	    }
	    	
	   return true;
	   
	}
	    return true;

	}
	
}
