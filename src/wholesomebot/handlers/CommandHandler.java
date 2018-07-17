package wholesomebot.handlers;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.commands.*;

import java.util.HashMap;

public final class CommandHandler {

    private static HashMap<String, Command> commands;

    public void handleCommand(MessageReceivedEvent event){
        String msg = event.getMessage().getContentDisplay().toLowerCase();
        String command = msg.substring(1, (msg.contains(" ")) ? msg.indexOf(" ") : msg.length());

        if(commands.containsKey(command)){
            commands.get(command).sendMessage(event);
        }
        else{
            event.getChannel().sendMessage("Sorry, i cant seem to find that command :confused: ").queue();
        }
    }

    public static HashMap<String, Command> getCommands() {
        return commands;
    }

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
        commands.put("prefix", new ChangePrefix());
    }
}
