package commands.General;

import java.awt.Color;

import mainPackage.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[]args =event.getMessage().getContentRaw().split("\\s+");

		//the equalsIgnoreCase makes it so the lowercase or uppercase doesnt matter
		if (args[0].equalsIgnoreCase(Main.prefix + "commands")) {
			EmbedBuilder commandsEmbed=new EmbedBuilder();
	
			commandsEmbed.setTitle("Want to call me?");
			commandsEmbed.setDescription("Here are my commands! \n Remember to use the prefix '=' (e.g. '=botinfo').");
			commandsEmbed.addField("General Commands: "," '=botinfo':Get my information! \n '=help': Call for my assistance!",false);
			commandsEmbed.addField("Mathematical Commands: "," '=random [min] [max]': Generate a randon number between [min] and [max] ",false);
			
			commandsEmbed.setColor(Color.GREEN);
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(commandsEmbed.build()).queue();
		}
	}
}