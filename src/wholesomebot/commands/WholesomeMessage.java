package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.main.ResponseMessages;

import java.util.Random;

public class WholesomeMessage extends Command {

    private String[] wholesomeMsgs = ResponseMessages.getWholesomeMsgs();

    @Override
    public String description() {
        return "I'll send you a wholesome message.";
    }

    @Override
    public void sendMessage(MessageReceivedEvent event) {
        event.getChannel().sendMessage(wholesomeMsgs[new Random().nextInt(wholesomeMsgs.length)]).queue();
    }

    public static class GuildLeaveListener {
    }
}
