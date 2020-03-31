package commandsPackage;

import java.awt.Color;

import mainPackage.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Help extends ListenerAdapter{

	// main register method

 public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
	 String[]args =event.getMessage().getContentRaw().split("\\s+");
		
		//the equalsIgnoreCase makes it so the lowercase or uppercase doesnt matter
		if (args[0].equalsIgnoreCase(Main.prefix + "help")) {
			//Instantiating an embededbuilder object
			EmbedBuilder help=new EmbedBuilder();
			help.setTitle("Help Stuff");
			help.setDescription("DESCRIPTION TO BE FILLED AS IT GOES");
			help.addField("Information:","TO BE FILLED",false);
			help.addField("My creator: ", "Juan Díaz", false);
			help.addField("My github repo if you're interested: ", "https://github.com/juandiaz28/Fefo", false);
			help.setColor(Color.ORANGE);
			help.setFooter("Created by Juan Díaz", null);
			//event.getMember().getUser().getAvatarUrl()
			event.getChannel().sendTyping().queue();
			//original line when typing =info
			//event.getChannel().sendMessage("Hey there, what do you need help with?").queue();
			//new line
			event.getChannel().sendMessage(help.build()).queue();
			//the clear helps clear the embed to save system resources
		}
	}
 }