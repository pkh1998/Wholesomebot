package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.main.ResponseMessages;
import java.util.Random;

public class Quote extends Command{

    private String[] quotes = ResponseMessages.getQuotes();

    @Override
    public String description() {
        return "I'll send a random inspirational quote.";
    }

    @Override
    public void sendMessage(MessageReceivedEvent event) {
        event.getChannel().sendMessage(quotes[new Random().nextInt(quotes.length)]).queue();
    }
}
