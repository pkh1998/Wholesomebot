package wholesomebot.main;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import wholesomebot.commands.Command;
import wholesomebot.eventListeners.GuildJoinListener;
import wholesomebot.eventListeners.GuildMemberLeaveListener;
import wholesomebot.eventListeners.MessageReceivedListener;
import wholesomebot.eventListeners.ReadyListener;
import javax.security.auth.login.LoginException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class WholesomeBot {
    public static JDA jda;
    private Timer timer = new Timer();
    private GoodMorningMsg goodMorningMsg;
    private DailyWholesomeMsg dailyWholesomeMsg;

    public static void main(String[] args){
        WholesomeBot intFace = new WholesomeBot();
        intFace.run();
    }

    private void run(){

        JDABuilder bot = new JDABuilder(AccountType.BOT);
        bot.setToken(WholesomeProperties.getToken());
        bot.setAutoReconnect(true);

        bot.addEventListener(
                new ReadyListener(),
                new GuildJoinListener(),
                new MessageReceivedListener(),
                new GuildMemberLeaveListener()
        );

        try{
            jda = bot.buildBlocking();
        }catch(LoginException | InterruptedException e){
            e.printStackTrace();
        }
        jda.getPresence().setGame(Game.playing(ResponseMessages.getPresence()[new Random().nextInt(ResponseMessages.getPresence().length)]));
        goodMorningMsg = new GoodMorningMsg();
        dailyWholesomeMsg = new DailyWholesomeMsg();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                DateFormat dateFormat = new SimpleDateFormat("HH");
                String date = dateFormat.format(new Date());

                if(date.equals("08")){
                    jda.getPresence().setGame(Game.playing(ResponseMessages.getPresence()[new Random().nextInt(ResponseMessages.getPresence().length)]));
                }

                if(date.equals(WholesomeProperties.getMorningMessageTime())){
                    System.out.println("LOG: Sending daily good morning message...");
                    goodMorningMsg.sendMessage();
                }

                if(date.equals(WholesomeProperties.getWholesomeMessageTime())){
                    System.out.println("LOG: Sending daily wholesome message...");
                    dailyWholesomeMsg.sendDailyMessage();
                }

            }
        }, 0,3600000);
    }
}
