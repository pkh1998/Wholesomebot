package wholesomebot.main;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import wholesomebot.commands.*;
import wholesomebot.eventListeners.*;
import javax.security.auth.login.LoginException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class WholesomeBot {
    public static JDA jda;
    private Timer timer = new Timer();

    public static void main(String[] args){
        WholesomeBot intFace = new WholesomeBot();
        intFace.run();
    }

    private void run(){

        JDABuilder bot = new JDABuilder(AccountType.BOT);
        bot.setToken(WholesomeProperties.getConfigData("token"));
        bot.setAutoReconnect(true);

        bot.addEventListener(new ReadyListener(),
                new WholesomeMsgcmd(),
                new ComplimentMsgcmd(),
                new CheerUpMsgcmd(),
                new Quotecmd(),
                new GuildJoinListener(),
                new WholesomeImgcmd(),
                new Statscmd(),
                new Helpcmd(),
                new Choosecmd(),
                new PrivateMessageReceivedListener(),
                new MessageReceivedListener()
        );

        try{
            jda = bot.buildBlocking();
        }catch(LoginException | InterruptedException e){
            e.printStackTrace();
        }
        jda.getPresence().setGame(Game.playing(ResponseMessages.getPresence()[new Random().nextInt(ResponseMessages.getPresence().length)]));

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                DateFormat dateFormat = new SimpleDateFormat("HH");
                String date = dateFormat.format(new Date());

                if(date.equals(WholesomeProperties.getConfigData("goodMorningMsgTime"))){
                    System.out.println("Attempting to send daily good morning message...");
                    new GoodMorningMsg();
                }

                if(date.equals(WholesomeProperties.getConfigData("wholesomeMsgTime"))){
                    System.out.println("Attempting to send daily wholesome message...");
                    new DailyWholesomeMsg();
                }

            }
        }, 0,3600000);
    }
}
