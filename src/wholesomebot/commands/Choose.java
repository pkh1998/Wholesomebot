package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import java.util.Random;

public class Choose extends Command {
    @Override
    public String description() {
        return "Give me some options to choose from and i will select one at random. ";
    }

    @Override
    public void sendMessage(MessageReceivedEvent event) {
        String msg = event.getMessage().getContentDisplay();
        msg = msg.substring(msg.indexOf(" "), msg.length());
        String[] options = msg.split("\\|");

        event.getChannel().sendMessage("I choose... " + options[new Random().nextInt(options.length)]).queue();
    }
}
