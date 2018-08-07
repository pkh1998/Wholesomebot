package wholesomebot.commands;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public abstract class Command{
    private boolean enabled;

    public Command() {
        enabled = true;
    }

    public abstract String description();

    public abstract void sendMessage(MessageReceivedEvent event);

    public void setStatus(boolean enabled){
        this.enabled = enabled;
    }

    public boolean isEnabled(){
        return enabled;
    }

    protected boolean checkRole(String role, Member member){
        for(Role memberRole : member.getRoles()){
            if(memberRole.getName().equals(role)){
                return true;
            }
        }
        return false;
    }

}
