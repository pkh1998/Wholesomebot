package wholesomebot.commands;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import java.util.Random;

public class CheerUpMsgcmd extends Command {

    private String[] cheerUpMessages;

    public CheerUpMsgcmd(String[] array){
        cheerUpMessages = array;
    }

    public void onMessageReceived(MessageReceivedEvent event){

        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContentDisplay();

        if(!event.getAuthor().isBot()){
            if(msg.equalsIgnoreCase(prefix+"cheermeup")){
                channel.sendMessage(cheerUpMessages[new Random().nextInt(cheerUpMessages.length)]).queue();
            }
        }
    }
}
