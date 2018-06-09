package wholesomebot.commands;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.main.ResponseMessages;
import java.util.Random;

public class WholesomeMsgcmd extends Command {

    private String[] wholesomeMsgs = ResponseMessages.getWholesomeMsgs();

    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContentDisplay();

        if(!event.getAuthor().isBot()){
            if( msg.equalsIgnoreCase(prefix+"wholesome")){
                channel.sendMessage(wholesomeMsgs[new Random().nextInt(wholesomeMsgs.length)]).queue();
            }
        }
    }
}
