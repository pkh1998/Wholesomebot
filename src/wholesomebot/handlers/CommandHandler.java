package wholesomebot.handlers;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.commands.*;

import java.util.HashMap;

public class CommandHandler {

    private static HashMap<String, Command> commands;

    public CommandHandler(){
        commands = new HashMap<>();
        commands.put("cheermeup", new CheerUpMessage());
        commands.put("choose", new Choose());
        commands.put("compliment", new ComplimentMessage());
        commands.put("help", new Help());
        commands.put("nerdstats", new NerdStats());
        commands.put("quote", new Quote());
        commands.put("recipe", new Recipe());
        commands.put("wholesomeimg", new WholesomeImage());
        commands.put("wholesome", new WholesomeMessage());
    }

    public void handleCommand(MessageReceivedEvent event){
        String msg = event.getMessage().getContentDisplay();
        String command = msg.substring(1, (msg.contains(" ")) ? msg.indexOf(" ") : msg.length());

        if(commands.containsKey(command)){
            commands.get(command).sendMessage(event);
        }
    }

    public static HashMap<String, Command> getCommands() {
        return commands;
    }
}
