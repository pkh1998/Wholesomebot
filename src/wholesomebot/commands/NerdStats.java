package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

public class NerdStats extends Command {

    @Override
    public String description() {
        return "Just some nerdy stats about me and my system, haha.";
    }

    @Override
    public void sendMessage(MessageReceivedEvent event) {
        String stats = "";

        long millis = ManagementFactory.getRuntimeMXBean().getUptime();
        stats += "Wholesomebot uptime: " + String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));


        event.getChannel().sendMessage(stats).queue();
    }
}
