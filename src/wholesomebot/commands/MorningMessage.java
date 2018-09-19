package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.core.GoodMorningMsg;
import wholesomebot.core.WholesomeProperties;

public class MorningMessage extends Command{
    @Override
    public String description() {
        return "Don't want a good morning message? Or want to be re-added to the list? use " + WholesomeProperties.getPrefix() + "morningmessage join/leave in order to join or leave the list.";
    }

    @Override
    public void sendMessage(MessageReceivedEvent event) {
        String action = event.getMessage().getContentDisplay().substring(event.getMessage().getContentDisplay().indexOf(" ")+1);
        System.out.println(action);
        String msg = "";
        if(action.equals("leave")){
            GoodMorningMsg.memberLeave(event.getAuthor().getId());
            msg = "I've removed you from the list :pensive: if you ever feel like rejoining, use " + WholesomeProperties.getPrefix() + "morningmessage join";
        }
        else if(action.equals("join")){
            GoodMorningMsg.memberJoin(event.getAuthor().getId());
            msg = "Awesome! I've added you to the list :blush: ";
        }
        else{
            msg = "Oops, didn't quite catch that, sorry.";
        }
        event.getChannel().sendMessage(msg).queue();
    }
}
