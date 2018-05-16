package wholesomebot.main;

import wholesomebot.commands.*;
import wholesomebot.eventListeners.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class WholesomeBot {
    public static JDA jda;
    private String[] cheerUpMessages, wholesomeMsgs, compliments,quotes, howAreYouReplies, howDoYouWorkReplies, whatAreYouDoingReplies, yourWelcomes, presence;
    private Timer timer = new Timer();

    public static void main(String[] args){
        WholesomeBot intFace = new WholesomeBot();
        intFace.run();
    }

    public void run(){

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("resources/config.properties"));
        }catch (IOException e){
            System.out.println("could not find config file\n" + e);
        }

        JDABuilder bot = new JDABuilder(AccountType.BOT);
        bot.setToken(properties.getProperty("token"));
        bot.setAutoReconnect(true);

        fillArrays();
        bot.addEventListener(new ReadyListener(),
                new WholesomeMsgcmd(wholesomeMsgs),
                new ComplimentMsgcmd(compliments),
                new CheerUpMsgcmd(cheerUpMessages),
                new Quotecmd(quotes),
                new GuildJoinListener(properties),
                new MessageReceivedListener(howAreYouReplies, howDoYouWorkReplies, whatAreYouDoingReplies, yourWelcomes)
        );

        try{
            jda = bot.buildBlocking();
        }catch(LoginException | InterruptedException e){
            e.printStackTrace();
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                DateFormat dateFormat = new SimpleDateFormat("HH");
                dateFormat.format(new Date());

                if(dateFormat.format(new Date()).equals(properties.getProperty("goodMorningMsgTime"))){
                    new GoodMorningMsg(jda);
                }
                if(dateFormat.format(new Date()).equals(properties.getProperty("wholesomeMsgTime"))){
                    new DailyWholesomeMsg(jda, wholesomeMsgs);
                }
            }
        }, 0,3600000);
    }

    private void fillArrays(){

        Scanner inputStream=null;

        //Cheer up messages array
        cheerUpMessages = new String[0];
        try{
            inputStream = new Scanner(new File("resources/messages/cheerUpMessages.txt"));
        }catch(FileNotFoundException e){
            System.out.println("\"cheerUpMessages.txt\" not found");
        }
        while(inputStream.hasNextLine()){
            String line = inputStream.nextLine();
            if(!line.equalsIgnoreCase("")){
                cheerUpMessages = increaseArraySize(cheerUpMessages);
                cheerUpMessages[cheerUpMessages.length-1] = line;
            }
        }

        //wholesome messages array
        wholesomeMsgs = new String[0];
        try{
            inputStream = new Scanner(new File("resources/messages/wholesomeMessages.txt"));
        }catch(FileNotFoundException e){
            System.out.println("\"wholesomeMessages.txt\" not found");
        }
        while(inputStream.hasNextLine()){
            String line = inputStream.nextLine();
            if(!line.equalsIgnoreCase("")){
                wholesomeMsgs = increaseArraySize(wholesomeMsgs);
                wholesomeMsgs[wholesomeMsgs.length-1] = line;
            }
        }

        //compliments array
        compliments = new String[0];
        try{
            inputStream = new Scanner(new File("resources/messages/compliments.txt"));
        }catch(FileNotFoundException e){
            System.out.println("\"compliments.txt\" not found");
        }
        while(inputStream.hasNextLine()){
            String line = inputStream.nextLine();
            if(!line.equalsIgnoreCase("")){
                compliments = increaseArraySize(compliments);
                compliments[compliments.length-1] = line;
            }
        }

        //quotes array
        quotes = new String[0];
        try{
            inputStream = new Scanner(new File("resources/messages/quotes.txt"));
        }catch(FileNotFoundException e){
            System.out.println("\"quotes.txt\" not found");
        }
        while(inputStream.hasNextLine()){
            String line = inputStream.nextLine();
            if(!line.equalsIgnoreCase("")){
                quotes = increaseArraySize(quotes);
                quotes[quotes.length-1] = line;
            }
        }

        //how are you replies array
        howAreYouReplies = new String[0];
        try{
            inputStream = new Scanner(new File("resources/messages/howAreYouReplies.txt"));
        }catch(FileNotFoundException e){
            System.out.println("\"howAreYouReplies.txt\" not found");
        }
        while(inputStream.hasNextLine()){
            String line = inputStream.nextLine();
            if(!line.equalsIgnoreCase("")){
                howAreYouReplies = increaseArraySize(howAreYouReplies);
                howAreYouReplies[howAreYouReplies.length-1] = line;
            }
        }

        //how do you work replies array
        howDoYouWorkReplies = new String[0];
        try{
            inputStream = new Scanner(new File("resources/messages/howDoYouWorkReplies.txt"));
        }catch(FileNotFoundException e){
            System.out.println("\"howDoYouWorkReplies.txt\" not found");
        }
        while(inputStream.hasNextLine()){
            String line = inputStream.nextLine();
            if(!line.equalsIgnoreCase("")){
                howDoYouWorkReplies = increaseArraySize(howDoYouWorkReplies);
                howDoYouWorkReplies[howDoYouWorkReplies.length-1] = line;
            }
        }

        whatAreYouDoingReplies = new String[0];
        try{
            inputStream = new Scanner(new File("resources/messages/whatAreYouDoingReplies.txt"));
        }catch(FileNotFoundException e){
            System.out.println("\"whatAreYouDoingReplies.txt\" not found");
        }
        while(inputStream.hasNextLine()){
            String line = inputStream.nextLine();
            if(!line.equalsIgnoreCase("")){
                whatAreYouDoingReplies = increaseArraySize(whatAreYouDoingReplies);
                whatAreYouDoingReplies[whatAreYouDoingReplies.length-1] = line;
            }
        }

        yourWelcomes = new String[0];
        try{
            inputStream = new Scanner(new File("resources/messages/yourWelcomes.txt"));
        }catch(FileNotFoundException e){
            System.out.println("\"yourWelcomes.txt\" not found");
        }
        while(inputStream.hasNextLine()){
            String line = inputStream.nextLine();
            if(!line.equalsIgnoreCase("")){
                yourWelcomes = increaseArraySize(yourWelcomes);
                yourWelcomes[yourWelcomes.length-1] = line;
            }
        }

        presence = new String[0];
        try{
            inputStream = new Scanner(new File("resources/messages/presence.txt"));
        }catch(FileNotFoundException e){
            System.out.println("\"presence.txt\" not found");
        }
        while(inputStream.hasNextLine()){
            String line = inputStream.nextLine();
            if(!line.equalsIgnoreCase("")){
                presence = increaseArraySize(presence);
                presence[presence.length-1] = line;
            }
        }

        System.out.println("Arrays filled!");
    }

    private static String[] increaseArraySize(String[] array){
        String[] newArray = new String[array.length+1];
        for(int i=0; i<array.length; i++){
            newArray[i] = array[i];
        }
        return newArray;
    }
}
