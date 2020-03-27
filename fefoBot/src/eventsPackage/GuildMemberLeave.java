package eventsPackage;

import java.awt.Color;
import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberLeave extends ListenerAdapter{
	//Standard messages for when someone joins the server
	String[] welcomeMessages = { "[member] has left, what a simp!", "Suden sus tetillas y sus ojos, [member] se fue del server.",
	"[member] apestaba, que bueno que se fue."};

	public void onGuildMemberLeave(GuildMemberJoinEvent event) {
		EmbedBuilder join = new EmbedBuilder();
		Random rand=new Random();
		int num=rand.nextInt(welcomeMessages.length);

//creating embed to show message
		join.setColor(Color.RED);
		join.setDescription(welcomeMessages[num].replace("[member]", event.getMember().getAsMention()));

		event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
		
		//this is for adding role when someone joins
		event.getGuild().modifyMemberRoles(event.getMember(), event.getGuild().getRolesByName("Simp-Level", true)).complete();
	}
}
