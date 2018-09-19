package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.core.ResponseMessages;

import java.util.Random;

public class SelfCare extends Command{

    private String[] selfCareMessages = ResponseMessages.getSelfCareMessages();

    @Override
    public String description() {
        return "Some tips and ideas on how to care for yourself and be happy.";
    }

    @Override
    public void sendMessage(MessageReceivedEvent event) {
        event.getChannel().sendMessage(selfCareMessages[new Random().nextInt(selfCareMessages.length)]).queue();
    }
}
