package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.core.ResponseMessages;

import java.io.File;
import java.util.Random;

public class WholesomeImage extends Command {

    private File[] imgs = ResponseMessages.getImgs();

    @Override
    public String description() {
        return "I'll send you a nice wholesome image";
    }

    @Override
    public void sendMessage(MessageReceivedEvent event) {
        event.getChannel().sendFile(imgs[new Random().nextInt(imgs.length)]).queue();
    }
}