package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.core.ResponseMessages;

public class ReloadResponseMessages extends Command{

    @Override
    public String description() {
        return "Reloads the response messages to include any new lines";
    }

    @Override
    public void sendMessage(MessageReceivedEvent event) {
        ResponseMessages.reloadMessages();
    }
}
