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
	 log.info("[MPM] v1.0 Plugin Ativado!");	
}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	    if(cmd.getName().equalsIgnoreCase("mp")){	    	
	    
	    	if(args.length >= 2){
	    		if (sender.getServer().getPlayer(args[0]) != null){
	    		Funcs func = new Funcs();
	    		String mensagem = func.getMensagem(args);
	    	  Player alvo = sender.getServer().getPlayer(args[0]);
	          alvo.sendMessage(ChatColor.YELLOW + "["+ ChatColor.GRAY + sender.getName() + ChatColor.YELLOW + "-MP]" + ChatColor.GREEN + mensagem);
	          sender.sendMessage(ChatColor.YELLOW + "MP enviada!");
	          log.info("[MPM] O jogador " + sender.getName() + " enviou MP para " + alvo.getDisplayName());
	          log.info("[MPM] Mensagem:" +  mensagem);
	        }
	    }else if(args.length <= 1){
	    	sender.sendMessage(ChatColor.RED + "Erro:");
	    	sender.sendMessage(ChatColor.RED + "Use: /mp <jogador> <mensagem>");
	    	
	    }else{
	    	sender.sendMessage(ChatColor.RED + "Erro ao encontrar jogador,talvez ele não esteja online!");
	    }	      
	   
	}
	    return true;

	}
	
}
