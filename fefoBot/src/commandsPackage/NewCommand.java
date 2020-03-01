package commandsPackage;

import mainPackage.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class NewCommand extends ListenerAdapter{

	// main register method
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[]args =event.getMessage().getContentRaw().split("\\s+");
		//fill here with necessary command
		if(args[0].equalsIgnoreCase(Main.prefix + "botinfo")) {
			//Instantiating an embededbuilder object
			EmbedBuilder NewCommand=new EmbedBuilder();
		}
	}
}

