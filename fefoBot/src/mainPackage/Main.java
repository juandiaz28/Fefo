package mainPackage;

import javax.security.auth.login.LoginException;

import commands.General.BotInfo;
import commands.General.Commands;
import commands.General.Help;
import eventsPackage.GuildMemberJoined;
import eventsPackage.GuildMemberLeave;
import eventsPackage.GuildMessageReceived;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
	public static JDA jda;
	//this prefix is for analyzing the message and make sure it's a command
	public static String prefix = "=";
	//the static ensures we can reference it from the any class
	//change this to change what the bot has in its activity
	public static String currentlyListening="you";

	//main method
	public static void main(String[] args) throws LoginException {
		//in the setToken "" goes the Bot Token accessed by discord dev

		//DO NOT SHARE TOKEN WITH ANYBODY
		jda = new JDABuilder(AccountType.BOT).setToken("").build();
		jda.getPresence().setStatus(OnlineStatus.ONLINE);
		jda.getPresence().setActivity(Activity.listening(currentlyListening));


		//so to speak this calls the commands jda.addEventListener
		jda.getSelfUser();
		
		jda.addEventListener(new BotInfo());
		//adding help call
		jda.addEventListener(new Help());
		
		jda.addEventListener(new Commands());
		
		//adding a call to the adding new users to server
		jda.addEventListener(new GuildMemberJoined());
		//para cuando se va
		jda.addEventListener(new GuildMemberLeave());
		//message received
		jda.addEventListener(new GuildMessageReceived());
	}
}
