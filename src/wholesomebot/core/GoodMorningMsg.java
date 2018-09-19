package wholesomebot.core;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import wholesomebot.dataStructures.Map;

import java.util.Random;

public class GoodMorningMsg {

    private TextChannel channel;
    private static Map<String, String> members;
    private int numUsersMessaged;
    private String[] goodMorningMessages;

    public GoodMorningMsg(){
        channel = WholesomeBot.jda.getTextChannelById(WholesomeProperties.getPublicChannel());
        goodMorningMessages = ResponseMessages.getGoodMorningMessages();
        members = new Map<>();
        numUsersMessaged = 0;
        for(User user : WholesomeBot.jda.getUsers()){
            if(!user.getId().equals(WholesomeBot.jda.getSelfUser().getId())){
                members.append(user.getId(), "false");
            }
        }
    }

    public void sendMessage(){
        if(numUsersMessaged == members.size()){
            for(int i=0; i<members.size(); i++){
                members.replace(members.get(i), "false");
            }
            numUsersMessaged = 0;
        }

        String user;
        do{
            user = members.get(new Random().nextInt(members.size()));
        }while(hasBeenMessaged(user));
        numUsersMessaged++;

        //retrieves a random good morning message string from the array, then replaces %user% found in the string to the chosen members id. message is then sent
        channel.sendMessage(goodMorningMessages[new Random().nextInt(goodMorningMessages.length)].replace("%user%", "<@" + user + ">")).queue();
        WholesomeProperties.saveMorningMessageUser(user);
    }

    private boolean hasBeenMessaged(String user){
        if(members.getValue(user).equals("false")){
            members.replace(user, "true");
            return false;
        }
        else
            return true;
    }

    public static void memberJoin(String user){
        members.append(user, "false");
    }

    public static void memberLeave(String user){
        members.remove(user);
    }
}
