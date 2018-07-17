package wholesomebot.main;

import net.dv8tion.jda.core.entities.TextChannel;

import java.util.Random;

public class DailyWholesomeMsg {

    public DailyWholesomeMsg(){
        TextChannel channel = WholesomeBot.jda.getTextChannelById(WholesomeProperties.getPublicChannel());

        String msg;
        String prevmsg = WholesomeProperties.getLastWholesomeMessage();
        do{
            msg = ResponseMessages.getWholesomeMsgs()[new Random().nextInt(ResponseMessages.getWholesomeMsgs().length)];
        }while(msg.equals(prevmsg));

        WholesomeProperties.saveLastWholesomeMessage(msg);
        channel.sendMessage(msg).queue();

        System.out.println("Daily wholesome message sent!");
    }
}
