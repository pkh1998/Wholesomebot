package wholesomebot.handlers;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.main.ResponseMessages;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class MessageHandler {

    private HashMap<Pattern, String> responses;
    private Pattern wholesomebot;

    public void handleMessage(MessageReceivedEvent event){
        String msg = event.getMessage().getContentDisplay();
        if(!wholesomebot.matcher(msg).find()){
            return;
        }

        for(Map.Entry<Pattern, String> entry : responses.entrySet()){
            if(entry.getKey().matcher(msg).find()){
                event.getChannel().sendMessage(editResponse(entry.getValue(), event.getAuthor().getName())).queue();
                break;
            }
        }
    }

    private String editResponse(String rawResponse, String user){
        String response = rawResponse;
        switch (rawResponse){
            case "%yourWelcome%": response = ResponseMessages.getYourWelcomes()[new Random().nextInt(ResponseMessages.getYourWelcomes().length)];
                break;
            case "%howAreYou%": response = ResponseMessages.getHowAreYouReplies()[new Random().nextInt(ResponseMessages.getHowAreYouReplies().length)];
                break;
            case "%whatAreYouDoing%": response = ResponseMessages.getWhatAreYouDoingReplies()[new Random().nextInt(ResponseMessages.getWhatAreYouDoingReplies().length)];
                break;
            case "%howDoYouWork%": response = ResponseMessages.getHowDoYouWorkReplies()[new Random().nextInt(ResponseMessages.getHowDoYouWorkReplies().length)];
                break;
        }
        response = response.replace("%user%", user);
        return response;
    }

    public MessageHandler(){

        responses = new HashMap<>();
        wholesomebot = Pattern.compile("wholesomebot|<@380542695556251650>|wholesome");

        //if message is a variation of 'i love you wholesomebot'
        responses.put(
                Pattern.compile("i\\s+l+o+v+e+\\s+yo+u+"),
                "i love you too %user% :kissing_heart: "
        );

        //if a user says a variation of 'i love you too wholesomebot'
        responses.put(
                Pattern.compile("i love you (to|too)"),
                ":heart: "
        );

        //if message is a variation of 'thank you wholesomebot'
        responses.put(
                Pattern.compile("(thanks|thank you|thankyou)"),
                "%yourWelcome%"
        );

        //if message is a variation of 'how are you wholesomebot'
        responses.put(
                Pattern.compile("(how are|how're)\\s+you\\s+((doing|today)\\s+)*"),
                "%howAreYou%"
        );

        //if message contains certain swear words
        responses.put(
                Pattern.compile("(fuck|cunt)"),
                "Please watch your language :upside_down:"
        );

        //if message is a variation of 'hey wholesomebot'
        responses.put(
                Pattern.compile("(hey|hi|hello|whats up|what's up|heyo)"),
                "Hey %user%"
        );

        //if message is a variation of 'ty wholesomebot'
        responses.put(
                Pattern.compile("ty"),
                "np bby :kissing_heart:"
        );

        //if message is 'SPOOK'
        responses.put(
                Pattern.compile("SPOOK"),
                "AHH! Spooked again... :sweat_smile: "
        );

        //if message is a variation of 'what are you up to wholesomebot
        responses.put(
                Pattern.compile("(what are|what're|what) you (up to|doing)"),
                "%whatAreYouDoing%"
        );

        //if message is a variation of 'how do you work wholesomebot'
        responses.put(
                Pattern.compile("how (exactly)? do you work\\??"),
                "%howDoYouWork%"
        );
    }
}
