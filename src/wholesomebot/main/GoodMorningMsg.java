package wholesomebot.main;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import org.apache.commons.lang3.ArrayUtils;
import java.util.Random;

public class GoodMorningMsg {

    public GoodMorningMsg(){
        TextChannel channel = WholesomeBot.jda.getTextChannelById(WholesomeProperties.getConfigData("publicChannel"));
        Guild guild = channel.getGuild();

        String lastUser = WholesomeProperties.getSaveData("prevGoodMorningUser");
        Member[] members = new Member[guild.getMembers().size()];
        for(int i=0; i<guild.getMembers().size(); i++){
            members[i] = guild.getMembers().get(i);
        }
        for (int i=0; i<members.length; i++) {
            if(members[i].getUser().getId().equalsIgnoreCase("203810322425839617") || members[i].getUser().getId().equalsIgnoreCase("203826445385072640") ||members[i].getNickname()==null){
                members = ArrayUtils.remove(members, i);
            }
        }

        String user;
        do{
            user = members[new Random().nextInt(members.length)].getUser().getId();
        }while(user.equals(lastUser) && user.equals(WholesomeBot.jda.getSelfUser().getId()));

        WholesomeProperties.setSaveProperties("prevGoodMorningUser", user);

        channel.sendMessage("Good morning <@" + user + ">, have a great day today :blush:").queue();
        System.out.println("Daily good morning message sent!");
    }
}
