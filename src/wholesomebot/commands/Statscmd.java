package wholesomebot.commands;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.main.WholesomeProperties;
import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

public class Statscmd extends Command {
    public void onMessageReceived(MessageReceivedEvent event){

        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContentDisplay();

        long millis = ManagementFactory.getRuntimeMXBean().getUptime();
        String time = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

        String stats = "WholesomeBot uptime: " + time;
        stats += "\nLast wholesome message: " + WholesomeProperties.getSaveData("prevWholesomeMsg");

        if(!event.getAuthor().isBot()){
            if(msg.equalsIgnoreCase(prefix+"stats")){
                channel.sendMessage(stats).queue();
            }
        }
    }
}
