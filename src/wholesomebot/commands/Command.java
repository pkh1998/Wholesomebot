package wholesomebot.commands;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public abstract class Command{
    private boolean commandEnabled;

    public abstract String description();

    public abstract void sendMessage(MessageReceivedEvent event);

    public void setEnabled(boolean enabled){
        commandEnabled = enabled;
    }

    public boolean isEnabled(){
        return commandEnabled;
    }

    protected boolean checkRole(String role, Member member){
        boolean hasRole = false;
        for(Role memberRole : member.getRoles()){
            if(memberRole.getName().equals(role)){
                return true;
            }
        }
        return false;
    }

}
