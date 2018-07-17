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
        StringBuilder msg = new StringBuilder("Here are all my commands :) \nDon't forget to put the " + WholesomeProperties.getPrefix() + " to tell me its a command.\n\n");

        //iterates though the command Hashmap to retrieve all the command names (Keys) and the command descriptions
        for(HashMap.Entry<String, Command> command : CommandHandler.getCommands().entrySet()){
            msg.append("**").append(command.getKey()).append("**").append(": ").append(command.getValue().description()).append("\n\n");
        }
        event.getChannel().sendMessage(msg.toString()).queue();
    }
}
