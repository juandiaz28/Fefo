package mainPackage;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
	//ListenerAdapter registers events
	//events can be sending messages or adding reactions to messages
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[]args =event.getMessage().getContentRaw().split(" ");
		
		//the equalsIgnoreCase makes it so the lowercase or uppercase doesnt matter
		if (args[0].equalsIgnoreCase(Main.prefix + "botinfo")) {
			//Instantiating an embededbuilder object
			EmbedBuilder botinfo=new EmbedBuilder();
			botinfo.setTitle("Bot Stuff");
			botinfo.setDescription("Important bot stuff for you since you're interested in me UwU ");
			botinfo.addField("Information:","I am an assistant bot for your server that is currently undergoing development. \n Type =help if you need me.",false);
			//info.addField("My creator: ", "Juan Díaz", false);
			botinfo.addField("My github repo if you're interested: ", "https://github.com/juandiaz28/Fefo", false);
			botinfo.setColor(Color.GREEN);
			botinfo.setFooter("Created by Juan Díaz", event.getMember().getUser().getAvatarUrl());
			
			event.getChannel().sendTyping().queue();
			//original line when typing =info
			//event.getChannel().sendMessage("Hey there, what do you need help with?").queue();
			//new line
			event.getChannel().sendMessage(botinfo.build()).queue();
			//the clear helps clear the embed to save system resources
			botinfo.clear();
		}
	}
}
