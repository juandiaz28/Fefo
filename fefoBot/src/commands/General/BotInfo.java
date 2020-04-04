package commands.General;

/*
 * Created a new package for exclusive command usage
 * The old Command.class in the mainPackage has been erased and is essentially this new class
 * 
 */
import java.awt.Color;


import mainPackage.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class BotInfo extends ListenerAdapter {
	//ListenerAdapter registers events
	//events can be sending messages or adding reactions to messages
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[]args =event.getMessage().getContentRaw().split("\\s+");
		
		//the equalsIgnoreCase makes it so the lowercase or uppercase doesnt matter
		if (args[0].equalsIgnoreCase(Main.prefix + "botinfo")) {
			//Instantiating an embededbuilder object
			EmbedBuilder botInfoEmbed=new EmbedBuilder();
			//test for role
//			System.out.println(event.getGuild().getRoles().toString());
//			if() {
//				
//			}
//		
			botInfoEmbed.setTitle("Bot Stuff");
			botInfoEmbed.setDescription("Important bot stuff for you since you're interested in me UwU ");
			botInfoEmbed.addField("Information:","I am an assistant bot for your server that is currently undergoing development. \n Type =help if you need me.",false);
			botInfoEmbed.addField("My creator: ", "Juan Díaz", false);
			botInfoEmbed.addField("My github repo if you're interested: ", "https://github.com/juandiaz28/Fefo", false);
			botInfoEmbed.setColor(Color.GREEN);
			botInfoEmbed.setFooter("Created by Juan Díaz", null);
			
			event.getChannel().sendTyping().queue();
			//original line when typing =info
			//event.getChannel().sendMessage("Hey there, what do you need help with?").queue();
			//new line
			event.getChannel().sendMessage(botInfoEmbed.build()).queue();
			//the clear helps clear the embed to save system resources
		}
	}
}