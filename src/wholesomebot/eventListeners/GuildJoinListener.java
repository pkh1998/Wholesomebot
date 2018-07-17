package wholesomebot.eventListeners;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import wholesomebot.main.GoodMorningMsg;
import wholesomebot.main.WholesomeProperties;

public class GuildJoinListener extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        TextChannel channel = event.getJDA().getTextChannelById(WholesomeProperties.getWelcomeChannel());
        channel.sendMessage("hey there " + event.getMember().getAsMention() + ", Welcome to " + event.getGuild().getName() + " :blush:").queue();
        GoodMorningMsg.newMember();
    }
}
