package wholesomebot.eventListeners;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import wholesomebot.core.GoodMorningMsg;
import wholesomebot.core.WholesomeProperties;
import wholesomebot.utils.logger.LogLevel;
import wholesomebot.utils.logger.Logger;

public class GuildMemberJoinListener extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        TextChannel channel = event.getJDA().getTextChannelById(WholesomeProperties.getWelcomeChannel());
        channel.sendMessage("hey there " + event.getMember().getAsMention() + ", Welcome to " + event.getGuild().getName() + " :blush:").queue();
        GoodMorningMsg.memberJoin(event.getUser().getId());
        Logger.log(LogLevel.INFO, event.getMember().getNickname() + " has joined " + event.getGuild().getName());
    }
}
