package commands.General;

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
			help.setTitle("You need my help? UwU");
			help.addField("General help:", "Whenever a command requires a [parameter] you don't need to write the brackets, just the value.\n "
					+ "For example: '=random 0 10' is a valid command",false);
			help.addField("If you want my info type:"," '=botinfo' ",false);
			help.addField("If you want my command list type: ", " '=commands' ", false);
			
			help.setColor(Color.ORANGE);
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