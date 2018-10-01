package wholesomebot.eventListeners;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import wholesomebot.handlers.CommandHandler;
import wholesomebot.handlers.MessageHandler;
import wholesomebot.core.WholesomeProperties;
import wholesomebot.utils.logger.LogLevel;
import wholesomebot.utils.logger.Logger;

public class MessageReceivedListener extends ListenerAdapter {

    private MessageHandler messageHandler = new MessageHandler();
    private CommandHandler commandHandler = new CommandHandler();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        Logger.log(LogLevel.INFO, (event.isFromType(ChannelType.PRIVATE)) ? "Private" : "Public" + " - " + event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay());

        if(event.getAuthor().isBot()){ //if the message event came from a bot
            return;
        }
        else if(event.getMessage().getContentDisplay().startsWith(WholesomeProperties.getPrefix())){ //if the message is a command, starting with the assigned prefix
            commandHandler.handleCommand(event);
        }
        else{ //if the message is just a standard message
            messageHandler.handleMessage(event);
        }
    }
}
