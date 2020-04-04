package commands.Mathematical;

import java.awt.Color; 
import java.util.Random;

import mainPackage.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RandGenerator extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		int randNumInt;
		boolean upperBoundDigit=false;
		boolean lowerBoundDigit=false;
		String[]args =event.getMessage().getContentRaw().split("\\s+");
		//		System.out.println(args[0]);
		//		System.out.println(args[1]);
		//		System.out.println(args[2]);

		//the equalsIgnoreCase makes it so the lowercase or uppercase doesnt matter
		if (args[0].equalsIgnoreCase(Main.prefix + "random")) {
			EmbedBuilder randGenerator=new EmbedBuilder();
			//Both of these loops ensure that the bounds are a number
			//However this can be made more efficient if you learn to implement try/catch for the '.parseInt' below
			//			for(char c: args[2].toCharArray()) {
			//				if(!Character.isDigit(c)) {
			//					upperBoundDigit=false;
			//				}
			//			}
			//			for(char c: args[1].toCharArray()) {
			//				if(!Character.isDigit(c)) {
			//					lowerBoundDigit=false;
			//				}
			//			}
			////if the bounds are not a number show an error message
			//			if(upperBoundDigit==false || lowerBoundDigit==false) {
			//				randGenerator.setTitle("Random number");
			//				randGenerator.addField("Random Number generation error:", "Bounds are not integers. Try again.", false);
			//				randGenerator.setColor(Color.magenta);
			//			}


//Before the TRY/CATCH was implemented the above code was utilized to ensure that the parameters were numbers
			
				try {
					int upperBound=Integer.parseInt(args[2].trim());
					int lowerBound=Integer.parseInt(args[1].trim());
					Random randGen= new Random();
					//the plus one makes it inclusive
					randNumInt=randGen.nextInt(upperBound+1) + lowerBound;
					randGenerator.setTitle("Random number between " + lowerBound + " and " + upperBound + " is: " + randNumInt);
					randGenerator.setColor(Color.green);
				}
				catch(NumberFormatException e){
					randGenerator.setTitle("Error: Bounds are not integers");
					randGenerator.setColor(Color.red);
					
				}


			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(randGenerator.build()).queue();
		}
	}
}