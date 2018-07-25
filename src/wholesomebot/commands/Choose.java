package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Random;

public class Choose extends Command {
    @Override
    public String description() {
        return "Give me some options to choose from and i will select one at random. eg !choose yes|no|maybe ";
    }

    @Override
    public void sendMessage(MessageReceivedEvent event) {
        String msg = event.getMessage().getContentDisplay();
        msg = msg.substring(msg.indexOf(" "), msg.length());
        String[] options = msg.split("\\|");

        //trims all whitespaces from the provided options
        for(int i=0; i<options.length; i++){
            options[i] = options[i].trim();
        }

        event.getChannel().sendMessage("I choose... " + options[new Random().nextInt(options.length)]).queue();
    }
}
