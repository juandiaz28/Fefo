package eventsPackage;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReceived extends ListenerAdapter{
	String thing;
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		EmbedBuilder msg= new EmbedBuilder();
				thing=event.getMessage().toString();

//If conditional Ensures the bot doesn't get stuck in a loop from it's own event
				if(!event.getMember().getUser().equals(event.getJDA().getSelfUser())) {
					msg.setTitle("Repeating what you got");
					msg.addField("Test with ids",thing,false);
					event.getChannel().sendTyping().queue();
					event.getChannel().sendMessage(msg.build()).queue();
				}
				
	}


}
