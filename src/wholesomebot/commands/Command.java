package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public abstract class Command{
    public abstract String description();
    public abstract void sendMessage(MessageReceivedEvent event);

}
