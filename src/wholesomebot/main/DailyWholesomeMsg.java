package wholesomebot.main;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.TextChannel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class DailyWholesomeMsg {

    public DailyWholesomeMsg(JDA jda, String[] wholesomeMsgs){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("resources/config.properties"));
        }catch (IOException e){
            System.out.println("could not find config file\n" + e);
        }
        TextChannel channel;
        channel = jda.getTextChannelById(properties.getProperty("publicChannel"));

        try {
            properties.load(new FileInputStream("resources/savedData.properties"));
        }catch (IOException e){
            System.out.println("could not find config file\n" + e);
        }

        String msg;
        do{
            msg = wholesomeMsgs[new Random().nextInt(wholesomeMsgs.length)];
        }while(msg!=properties.getProperty("prevWholesomeMsg"));

        properties.setProperty("prevWholesomeMsg", msg);

        channel.sendMessage(wholesomeMsgs[new Random().nextInt(wholesomeMsgs.length)]).queue();
    }
}
