package wholesomebot.main;

import net.dv8tion.jda.core.entities.TextChannel;
import java.util.Random;

public class DailyWholesomeMsg {

    public DailyWholesomeMsg(){
        TextChannel channel = WholesomeBot.jda.getTextChannelById(WholesomeProperties.getConfigData("publicChannel"));

        String msg;
        String prevmsg = WholesomeProperties.getSaveData("prevWholesomeMsg");
        do{
            msg = ResponseMessages.getWholesomeMsgs()[new Random().nextInt(ResponseMessages.getWholesomeMsgs().length)];
        }while(msg.equals(prevmsg));

        WholesomeProperties.setSaveProperties("prevWholesomeMsg", msg);
        channel.sendMessage(msg).queue();

        System.out.println("Daily wholesome message sent!");
    }
}
