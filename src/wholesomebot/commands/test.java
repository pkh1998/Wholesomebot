package wholesomebot.commands;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class test extends Command {
    public void onMessageReceived(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContentDisplay();
        if(!event.getAuthor().isBot()){
            if(msg.equalsIgnoreCase(prefix+"test")){
                channel.sendMessage("").queue();
            }
        }
    }
}
