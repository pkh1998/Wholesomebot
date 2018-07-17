package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.main.ResponseMessages;

import java.util.Random;

public class CheerUpMessage extends Command {

    private String[] cheerUpMessages;

    public CheerUpMessage(){
        cheerUpMessages = ResponseMessages.getCheerUpMessages();
    }

    @Override
    public String description() {
        return "I'll send a message to try cheer you up or make you feel better.";
    }

    @Override
    public void sendMessage(MessageReceivedEvent event) {
        event.getChannel().sendMessage(cheerUpMessages[new Random().nextInt(cheerUpMessages.length)]).queue();
    }
}
