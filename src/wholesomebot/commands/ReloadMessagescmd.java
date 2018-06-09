package wholesomebot.commands;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class ReloadMessagescmd extends Command {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContentDisplay();

        if(!event.getAuthor().isBot()){
            if( msg.equalsIgnoreCase(prefix+"reloadmessages")){
                channel.sendMessage("Messages have been reloaded").queue();
            }
        }
    }
}
