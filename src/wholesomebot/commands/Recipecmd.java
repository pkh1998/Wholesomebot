package wholesomebot.commands;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class Recipecmd extends Command {

    public void onMessageReceived(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContentDisplay();

        if(!event.getAuthor().isBot()){
            if(msg.equalsIgnoreCase(prefix+"help")){
                channel.sendMessage(getRecipe()).queue();
            }
        }
    }

    private String getRecipe(){
        String recipe = "";

        File file = new File("resources/recipes/recipe.xml");


        return recipe;
    }
}
