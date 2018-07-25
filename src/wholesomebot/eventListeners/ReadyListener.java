package wholesomebot.eventListeners;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import wholesomebot.main.WholesomeProperties;

public class ReadyListener extends ListenerAdapter {

    public void onReady(ReadyEvent event){
        JDA jda = event.getJDA();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);

        jda.getTextChannelById(WholesomeProperties.getPublicChannel()).sendMessage("Hey everyone :blush: ").queue();

        System.out.println("Beep Boop i'm now online and ready to go :)");
    }
}
