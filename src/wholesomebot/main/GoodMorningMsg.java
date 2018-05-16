package wholesomebot.main;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class GoodMorningMsg {
    public GoodMorningMsg(JDA jda){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("resources/config.properties"));
        }catch (IOException e){
            System.out.println("could not find config file\n" + e);
        }
        TextChannel channel;
        channel = jda.getTextChannelById(properties.getProperty("publicChannel"));
        Guild guild = channel.getGuild();

        try {
            properties.load(new FileInputStream("resources/savedData.properties"));
        }catch (IOException e){
            System.out.println("could not find config file\n" + e);
        }

        String lastUser = properties.getProperty("prevGoodMorningUser");
        List<Member> members = guild.getMembers();

        String user;
        do{
            user = members.get(new Random().nextInt(members.size())).getUser().getId();
        }while(user!=lastUser && user!=jda.getSelfUser().getId() && user!="203810322425839617");

        properties.setProperty("prevGoodMorningUser", user);

        channel.sendMessage("Good morning <@" + user + ">, have a great day today :blush:").queue();
    }
}
