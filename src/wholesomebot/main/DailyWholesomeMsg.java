package wholesomebot.main;

import net.dv8tion.jda.core.entities.TextChannel;
import java.util.Random;

public class DailyWholesomeMsg {

    private TextChannel channel;

    public DailyWholesomeMsg(){
        channel = WholesomeBot.jda.getTextChannelById(WholesomeProperties.getPublicChannel());
    }

    public void sendDailyMessage(){

        String dailyMessage;
        do{
            dailyMessage = ResponseMessages.getWholesomeMsgs()[new Random().nextInt(ResponseMessages.getWholesomeMsgs().length)];
        }while(dailyMessage.equals(WholesomeProperties.getLastWholesomeMessage()));

        WholesomeProperties.saveLastWholesomeMessage(dailyMessage);
        channel.sendMessage(dailyMessage).queue();

        System.out.println("Daily wholesome message sent!");
    }
}
