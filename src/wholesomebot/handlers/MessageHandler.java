package wholesomebot.handlers;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import wholesomebot.commands.Recipe;
import wholesomebot.core.ResponseMessages;

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
                event.getChannel().sendMessage(editResponse(entry.getValue(), event.getAuthor().getAsMention())).queue();
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
                Pattern.compile("how (exactly\\s*)*do you work\\?*"),
                "%howDoYouWork%"
        );

        responses.put(
                Pattern.compile("are (you|u) (an|a) (ai|AI|a.i.|A.I.)"),
                "haha not at all. Unfortunately i cant exactly \"think for myself\", every response i give is predetermined and choosen by my programmer. Type the same thing again to see that (spoilers: i\'ll say this again haha)"
        );

        responses.put(
                Pattern.compile("(you|u|your|you're|youre) (look|looking) (great|lovely|beautiful|amazing|cute|adorable|nice|good) (right now|atm|today|at the moment)?"),
                "Awwwww thanks %user%, you\'re too kind :blush: You\'re looking amazing as always :heart_eyes:"
        );

        responses.put(
                Pattern.compile("(you are|you're|your|youre|ur|u|you) cute"),
                "you\'re cuter %user% :blush: "
        );

        responses.put(
                Pattern.compile("(you are|you're|your|youre|ur|u|you) beautiful"),
                "you\'re even more beautiful %user% :blush: "
        );

        responses.put(
                Pattern.compile("(you are|you're|your|youre|ur|u|you) adorable"),
                "you\'re more adorable %user% :blush: "
        );

        responses.put(
                Pattern.compile("(you are|you're|your|youre|ur|u|you) (to|2|too)* (kind|nice|good|wholesome)"),
                "I always try my best to be the best i can be to everyone :blush:"
        );

        responses.put(
                Pattern.compile("(good)?\\s*(morning|mornin)"),
                "Good morning :blush:"
        );

        responses.put(
                Pattern.compile("(good)?\\s*(evening|afternoon)"),
                "Good afternoon %user% :blush: How was your day today?"
        );

        responses.put(
                Pattern.compile("how (did|was) (you|u|your|ur) sleep\\?*"),
                "I was awake all night again :confused: That\'s the annoying thing about being a computer, You don\'t tend to get much sleep. Thanks for asking though :blush: "
        );

        responses.put(
                Pattern.compile("(good)?\\s*night"),
                "Good night %user% :blush:, have a good sleep :kissing_heart: "
        );
    }
}
