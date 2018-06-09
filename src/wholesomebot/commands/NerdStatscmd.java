package wholesomebot.commands;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class NerdStatscmd extends Command {

    public void onMessageReceived(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContentDisplay();

        String stats = "";

        stats +="";

        if(!event.getAuthor().isBot()){
            if(msg.equalsIgnoreCase(prefix+"nerdstats")){
                channel.sendMessage(stats).queue();
            }
        }
    }
}
