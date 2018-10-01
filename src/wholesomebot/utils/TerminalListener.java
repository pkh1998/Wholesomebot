package wholesomebot.utils;

import java.util.Scanner;

import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.TextChannel;
import wholesomebot.core.WholesomeBot;
import wholesomebot.utils.logger.LogLevel;
import wholesomebot.utils.logger.Logger;

public class TerminalListener implements Runnable{

    public TerminalListener(){

    }

    public void run(){
        Scanner keyboard = new Scanner(System.in);
        while(true){
            String cmd = keyboard.nextLine();
            Logger.log(LogLevel.INFO, "terminal - " + cmd);
            try{
                runCommand(cmd);
            }catch (ArrayIndexOutOfBoundsException e){
                Logger.log(LogLevel.NOTICE, "invalid amount of arguments in terminal command");
            }
        }
    }

    private void runCommand(String command){
        String[] args = command.split(" ");
        String cmd = args[0];

        switch (cmd) {
            case "shutdown": //format: shutdown
                Logger.log(LogLevel.INFO, "Shutting bot down");
                WholesomeBot.jda.shutdown();
                System.exit(0);
                break;

            case "say": // format: sendMessage [channel ID] [message]
                TextChannel channel = WholesomeBot.jda.getTextChannelById(args[1]);

                channel.sendMessage(concatArray(args, 2)).queue();
                break;

            case "presence": //format: presence [playing/watching.txt/listening] [game name]
                switch (args[1]) {
                    case "playing":
                        WholesomeBot.jda.getPresence().setGame(Game.playing(concatArray(args, 2)));
                        break;
                    case "listening":
                        WholesomeBot.jda.getPresence().setGame(Game.listening(concatArray(args, 2)));
                        break;
                    case "watching":
                        WholesomeBot.jda.getPresence().setGame(Game.watching(concatArray(args, 2)));
                        break;
                    case "remove":
                        WholesomeBot.jda.getPresence().setGame(null);
                        break;
                    default:
                        Logger.log(LogLevel.NOTICE, "Invalid presence - " + "Used: " + args[1] + " Allowed: playing listening watching");
                }
                break;

            default:
                Logger.log(LogLevel.NOTICE, "Invalid command");
        }
    }

    private String concatArray(String[] array, int startIndex){
        StringBuilder val = new StringBuilder("");
        int i = startIndex;
        while(i!=array.length){
            val.append(array[i]).append(" ");
            i++;
        }
        return val.toString();
    }
}
