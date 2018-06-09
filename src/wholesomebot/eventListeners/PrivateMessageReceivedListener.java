package wholesomebot.eventListeners;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import wholesomebot.main.WholesomeProperties;

public class PrivateMessageReceivedListener extends ListenerAdapter {

    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event){
        if(event.getAuthor().getId().equals("183037841192910848") || event.getAuthor().getId().equals("327731045653020673")){

            String msg = event.getMessage().getContentDisplay();

            if(msg.length()>8){
                if(msg.substring(0,7).equalsIgnoreCase("!repeat")){
                    TextChannel channel = event.getJDA().getTextChannelById(WholesomeProperties.getConfigData("publicChannel"));
                    channel.sendMessage(msg.substring(8,msg.length())).queue();
                }
            }
        }
    }
}
