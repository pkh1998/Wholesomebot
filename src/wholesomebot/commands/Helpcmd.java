package wholesomebot.commands;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Helpcmd extends Command{

    public void onMessageReceived(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContentDisplay();

        String helpMsg = "Help is here! Here\'s a list of commands:";
        helpMsg += "\n!wholesome -Sends wholesome message";
        helpMsg += "\n!cheermeup -Sends a message to try help cheer you up";
        helpMsg += "\n!compliment -Sends you a compliment";
        helpMsg += "\n!quote -Sends a random quote";
        helpMsg += "\n!wholesomeimg -Sends a random wholesome image";
        helpMsg += "\n!info -Displays information about wholesomebot";
        helpMsg += "\n!choose [option | option | etc...] -Chooses between the options you provide";
        helpMsg += "\n!stats -Displays some statistics about wholesomebot";

        if(!event.getAuthor().isBot()){
            if(msg.equalsIgnoreCase(prefix+"recipe")){
                channel.sendMessage(helpMsg).queue();
            }
        }
    }
}
