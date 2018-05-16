package wholesomebot.eventListeners;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Properties;

public class GuildJoinListener extends ListenerAdapter {

    private Properties prop;

    public GuildJoinListener(Properties prop){
        this.prop = prop;
    }

    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        TextChannel channel = event.getJDA().getTextChannelById(prop.getProperty("welcomeChannel"));
        channel.sendMessage("hey there " + event.getMember().getAsMention() + ", Welcome to Good Vibes Only :blush:").queue();
    }
}
