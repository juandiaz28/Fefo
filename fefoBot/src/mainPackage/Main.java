package mainPackage;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
	public static JDA jda;
	public static String string="Idk";

	//main method
	public static void main(String[] args) throws LoginException {
		//in the setToken "" goes the Bot Token accesed by discord dev
		
		//DO NOT SHARE TOKEN WITH ANYBODY
		jda = new JDABuilder(AccountType.BOT).setToken("").build();
		jda.getPresence().setStatus(OnlineStatus.ONLINE);
		jda.getPresence().setActivity(Activity.listening("you"));
		
	}
}
