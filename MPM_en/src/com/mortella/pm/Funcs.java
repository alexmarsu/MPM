package com.mortella.pm;


public class Funcs {
	
   public String getMensagem(String[] args){
	   String mensagem = "";
	   for (int i = 1; i < args.length; i++){
			mensagem = mensagem + " " + args[i];
			}
	   return mensagem;
   }
   
}