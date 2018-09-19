package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.core.WholesomeProperties;

public class ChangePrefix extends Command{
    @Override
    public String description() {
        return "This lets you change the prefix i use to whatever you want. (admin use only, sorry)";
    }

    @Override
    public void sendMessage(MessageReceivedEvent event) {
        if(checkRole(WholesomeProperties.getAdminRole(), event.getMember())){
            String command = event.getMessage().getContentDisplay();
            if(command.length()=="!prefix".length()){
                event.getChannel().sendMessage("Uh oh, you forgot provide me with a prefix :open_mouth: ").queue();
            }
            else{
                String prefix = command.substring(command.indexOf(" "));
                WholesomeProperties.setPrefix(prefix);
                event.getChannel().sendMessage("I have changed the prefix to " + prefix).queue();
            }
        }
        else{
            event.getChannel().sendMessage("Sorry, this is an admin only command :confused:  ").queue();
        }
    }
}
