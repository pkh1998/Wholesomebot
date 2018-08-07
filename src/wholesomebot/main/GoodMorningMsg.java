package wholesomebot.main;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GoodMorningMsg {

    private TextChannel channel;

    private static ArrayList<String> members;
    private static HashMap<String, String> messagedUsers;


    public GoodMorningMsg(){
        channel = WholesomeBot.jda.getTextChannelById(WholesomeProperties.getPublicChannel());
        members = new ArrayList<>();
        messagedUsers = new HashMap<>();
        for(User user : WholesomeBot.jda.getUsers()){
            if(!user.getId().equals(WholesomeBot.jda.getSelfUser().getId())){
                members.add(user.getId());
                messagedUsers.put(user.getId(), "false");
            }
        }
    }

    public void sendMessage(){
        String user;
        do{
            user = members.get(new Random().nextInt(members.size()));
        }while(hasBeenMessaged(user));

        channel.sendMessage("Good morning <@" + user + ">, have a great day today :blush:").queue();

        WholesomeProperties.saveMorningMessageUser(user);
    }

    private boolean hasBeenMessaged(String user){
        if(messagedUsers.get(user).equalsIgnoreCase("false")){
            messagedUsers.replace(user, "true");
            return false;
        }
        else
            return true;
    }

    public static void memberJoin(String user){
        members.add(user);
        messagedUsers.put(user, "false");
    }

    public static void memberLeft(String member){
        members.remove(member);
        messagedUsers.remove(member);
    }
}
