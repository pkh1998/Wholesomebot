package wholesomebot.commands;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.main.ResponseMessages;
import java.util.Random;

public class ComplimentMsgcmd extends Command {

    private String[] compliments = ResponseMessages.getCompliments();

    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContentDisplay();

        if(!event.getAuthor().isBot()){
            if(msg.equalsIgnoreCase(prefix+"compliment")){
                String comp = compliments[new Random().nextInt(compliments.length)];
                comp = comp.replace("%user%", "<@"+event.getAuthor().getId()+">");
                channel.sendMessage(comp).queue();
            }
        }
    }
}