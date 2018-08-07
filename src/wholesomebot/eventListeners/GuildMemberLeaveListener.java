package wholesomebot.eventListeners;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import wholesomebot.main.GoodMorningMsg;
import wholesomebot.main.WholesomeBot;
import wholesomebot.main.WholesomeProperties;

public class GuildMemberLeaveListener extends ListenerAdapter {

    public void onGuildMemberLeave(GuildMemberLeaveEvent event){
        TextChannel channel = WholesomeBot.jda.getTextChannelById(WholesomeProperties.getWelcomeChannel());
        channel.sendMessage("Bye " + event.getUser().getName() + ", we'll miss you :cry: ").queue();
        GoodMorningMsg.memberLeft(event.getMember().getUser().getId());
    }
}
