package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.handlers.CommandHandler;
import wholesomebot.main.WholesomeProperties;
import java.util.HashMap;

public class Help extends Command{

    @Override
    public String description() {
        return "I'll send this message that you're seeing right now, haha.";
    }

    @Override
    public void sendMessage(MessageReceivedEvent event) {
        String msg = "Here are all my commands :) \nDon't forget to put the " + WholesomeProperties.getPrefix() + " to tell me its a command.\n\n";

        //iterates though the command Hashmap to retrieve all the command names (Keys) and the command descriptions
        for(HashMap.Entry<String, Command> command : CommandHandler.getCommands().entrySet()){
            msg += command.getKey() + ": " + command.getValue().description() + "\n";
        }
        event.getChannel().sendMessage(msg).queue();
    }
}
