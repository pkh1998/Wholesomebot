package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChangeLog extends Command {
    @Override
    public String description() {
        return "I'll tell you all about the recent changes made in the last update i had.";
    }

    @Override
    public void sendMessage(MessageReceivedEvent event) {
        StringBuilder changelog = new StringBuilder();
        Scanner stream = null;
        try{
            stream = new Scanner(new File("resources/Changelog.txt"));
        }catch(FileNotFoundException e){
            System.out.println("Could not find changelog.txt :/");
        }
        while(stream.hasNextLine()){
            String line = stream.nextLine();
            if(line.matches("-{5,}")){
                break;
            }
            if(line.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$") || line.equalsIgnoreCase("added") || line.equalsIgnoreCase("changed") || line.equalsIgnoreCase("removed")){
                line = "**" + line + "**";
            }

            changelog.append(line).append("\n");
        }
        event.getChannel().sendMessage(changelog.toString()).queue();
    }
}
