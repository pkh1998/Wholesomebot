package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.core.ResponseMessages;

import java.util.Random;

public class ComplimentMessage extends Command {

    private String[] compliments = ResponseMessages.getCompliments();

    @Override
    public String description() {
        return "I'll send you a compliment to make you happy.";
    }

    @Override
    public void sendMessage(MessageReceivedEvent event) {
        String comp = compliments[new Random().nextInt(compliments.length)];
        comp = comp.replace("%user%", event.getMember().getAsMention());
        event.getChannel().sendMessage(comp).queue();
    }
}