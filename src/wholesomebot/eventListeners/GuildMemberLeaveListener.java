package wholesomebot.eventListeners;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import wholesomebot.core.GoodMorningMsg;
import wholesomebot.core.WholesomeBot;
import wholesomebot.core.WholesomeProperties;
import wholesomebot.utils.logger.LogLevel;
import wholesomebot.utils.logger.Logger;

public class GuildMemberLeaveListener extends ListenerAdapter {

    public void onGuildMemberLeave(GuildMemberLeaveEvent event){
        TextChannel channel = WholesomeBot.jda.getTextChannelById(WholesomeProperties.getWelcomeChannel());
        channel.sendMessage("Bye " + event.getUser().getName() + ", we'll miss you :cry: ").queue();
        GoodMorningMsg.memberLeave(event.getMember().getUser().getId());
        Logger.log(LogLevel.INFO, event.getMember().getNickname() + " has left " + event.getGuild().getName());
    }
}
