package com.mortella.pm;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import com.mortella.pm.Funcs;

public final class MyPlugin extends JavaPlugin{
	public void onEnable(){
	 getLogger().info("Plugin Ativado!");	
}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	    if(cmd.getName().equalsIgnoreCase("mp")){	    	
	     
	    	if(args.length >= 2){
	    		if (sender.getServer().getPlayer(args[0]) != null){
	    		Funcs func = new Funcs();
	    		String mensagem = func.getMensagem(args);
	    	  Player alvo = sender.getServer().getPlayer(args[0]);
	         if(sender instanceof Player){
	        	 alvo.sendMessage(ChatColor.YELLOW + "["+ ChatColor.GRAY + sender.getName() + ChatColor.YELLOW + "-MP]" + ChatColor.GREEN + mensagem);
	         }else{ 
	        	 alvo.sendMessage(ChatColor.YELLOW + "["+ ChatColor.MAGIC + sender.getName() + ChatColor.YELLOW + "-MP]" + ChatColor.GREEN + mensagem);
	         }    	  	          
	          sender.sendMessage(ChatColor.YELLOW + "MP Enviada!");
	          getLogger().info("O jogador " + sender.getName() + " enviou MP para " + alvo.getDisplayName());
	          getLogger().info("Menssagem:" + mensagem);
	        }else{
	        	sender.sendMessage(ChatColor.RED + "Erro! Não foi possivel encontrar o jogador.");
	        }
	    
	    }else if(args.length <= 1){
	    	sender.sendMessage(ChatColor.RED + "Erro:");
	    	sender.sendMessage(ChatColor.RED + "Use: /mp <jogador> <mensagem>");
	    	
	    }
	    
	    return true;
	   
	}
	    return true;

	}
	
}
