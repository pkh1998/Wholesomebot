package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.handlers.CommandHandler;
import wholesomebot.main.WholesomeProperties;

public class CommandEnabler extends Command {
    @Override
    public String description() {
        return "Allows you to enable or disable commands (Admin only)";
    }

    @Override
    public void sendMessage(MessageReceivedEvent event) {
        if(checkRole(WholesomeProperties.getAdminRole(), event.getMember())){
            String[] command = event.getMessage().getContentDisplay().split(" ");
            String commandName= command[1];
            String status = command[2];
            if(CommandHandler.getCommands().containsKey(commandName)){
                if(status.equalsIgnoreCase("enable")){
                    CommandHandler.getCommands().get(commandName).setStatus(true);
                    event.getChannel().sendMessage("Command: " + commandName + ", has been enabled.").queue();
                }
                else if(status.equalsIgnoreCase("disable")){
                    CommandHandler.getCommands().get(commandName).setStatus(false);
                    event.getChannel().sendMessage("Command: " + commandName + ", has been disabled.").queue();
                }
                else{
                    event.getChannel().sendMessage("ahhh, was that enable or disable?").queue();
                }
            }
            else{
                event.getChannel().sendMessage("Sorry, i couldn't complete that request, which command was it again you wanted?.").queue();
            }
        }
        else{
            event.getChannel().sendMessage("Sorry, this is an admin only command :confused:  ").queue();
        }
    }
}
