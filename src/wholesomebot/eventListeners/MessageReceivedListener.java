package wholesomebot.eventListeners;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import wholesomebot.handlers.CommandHandler;
import wholesomebot.handlers.MessageHandler;
import wholesomebot.main.WholesomeProperties;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageReceivedListener extends ListenerAdapter {

    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private CommandHandler commandHandler = new CommandHandler();
    private MessageHandler messageHandler = new MessageHandler();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String msg = event.getMessage().getContentDisplay();

        //Logging the message
        System.out.println(dateFormat.format(new Date()) + " - " + (event.getMessage().isFromType(ChannelType.PRIVATE) ? "Pri" : "Pub") + " - " + event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay());

        if(event.getAuthor().isBot()){ //if the message event came from a bot
            return;
        }
        else if(msg.startsWith(WholesomeProperties.getPrefix())){ //if the message is a command, starting with the assigned prefix
            commandHandler.handleCommand(event);
        }
        else{ //if the message is just a standard message
            messageHandler.handleMessage(event);
        }
    }
}
