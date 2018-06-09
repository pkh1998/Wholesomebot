package wholesomebot.eventListeners;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import wholesomebot.main.ResponseMessages;
import wholesomebot.main.WholesomeProperties;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageReceivedListener extends ListenerAdapter {

    private Random random = new Random();
    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContentDisplay().toLowerCase();

        //Logging the message
        String type;
        if(event.getMessage().isFromType(ChannelType.PRIVATE))
            type = "Pri";
        else
            type = "Pub";

        System.out.println(dateFormat.format(new Date()) + " - " + type + " - " + event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay());

        if(event.getAuthor().isBot() || msg.startsWith("!"))
            return;

        Pattern p = Pattern.compile("wholesomebot|<@380542695556251650>|wholesome");
        Matcher m = p.matcher(msg);

        if(m.find()){
            // if message is a variation of 'i love you wholesomebot'
            if (msg.matches("i\\s+l+o+v+e+\\s+yo+u+(?!\\n|\\r) (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("i love you too " + "<@" + event.getAuthor().getId() + "> :kissing_heart: ").queue();
            }

            //if a user says a varitaion of 'i love you too wholesomebot'
            else if (msg.matches("i love you (to|too) (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage(":heart: ").queue();
            }

            // if message is a variation of 'thank you wholesomebot'
            else if (msg.matches("(thanks|thank you|thankyou)(?!\\n|\\r)\\s+(wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage(ResponseMessages.getYourWelcomes()[random.nextInt(ResponseMessages.getYourWelcomes().length)]).queue();
            }

            // if message is a variation of 'how are you wholesomebot'
            else if (msg.matches("(how are|how're)\\s+you\\s+((doing|today)\\s+)*(wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage(ResponseMessages.getHowAreYouReplies()[random.nextInt(ResponseMessages.getHowAreYouReplies().length)]).queue();
            }

            // if message contains certain swear words
            else if (msg.matches("(fuck|cunt)")) {
                channel.sendMessage("Please watch your language :upside_down:").queue();
            }

            // if message is a variation of 'hey wholesomebot'
            else if (msg.matches("(hey|hi|hello|whats up|what's up|heyo) (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("Hey " + event.getAuthor().getName()).queue();
            }

            // if message is a variation of 'ty wholesomebot'
            else if (msg.matches("ty (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("np bby :kissing_heart:").queue();
            }

            // if message is 'SPOOK' or 'SPOOK!'
            else if (msg.matches("(SPOOK|SPOOK!)")) {
                channel.sendMessage("AHH! Spooked again... :sweat_smile: ").queue();
            }

            // if message is a variation of 'how do you work wholesomebot'
            else if (msg.matches("how (exactly\\s+)?do you work (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage(ResponseMessages.getHowDoYouWorkReplies()[random.nextInt(ResponseMessages.getHowDoYouWorkReplies().length)]).queue();
            }

            //if message is a variation of 'what are you up to wholesomebot
            else if (msg.matches("(what are|what're) you (up to|doing) (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage(ResponseMessages.getWhatAreYouDoingReplies()[random.nextInt(ResponseMessages.getWhatAreYouDoingReplies().length)]).queue();
            }

            else if (msg.matches("(do)? you have a crush (on anyone)?\\s* (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("I might....\n but i cant\'t tell you because its a secret :wink: ").queue();
            }

            else if (msg.matches("(do)? (you|u) believe in love (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("Of course i do! There\'s a perfect match for everyone in this world, whether you know it or not :blush: ").queue();
            }

            else if (msg.matches("who do (you|u) like (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("I like most people, some more than others, some less than others :yum: ").queue();
            }

            else if (msg.matches("who do (you|u) love (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("I love lots of people :blush:  But most of all i love my programmer and those that he loves most, I wouldn't be here without them :hearts: ").queue();
            }

            else if (msg.matches("are (you|u) (an|a) (ai|AI|a.i.|A.I.) (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("haha not at all. Unfortunately i cant exactly \"think for myself\", every response i give is predetermined and choosen by my programmer. Type the same thing again to see that (spoilers: i\'ll say this again haha)").queue();
            }

            else if (msg.matches("(you|u|your|you're|youre) (look|looking) (great|lovely|beautiful|amazing|cute|adorable|nice|good) (right now|atm|today|at the moment)? (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("Awwwww thanks " + event.getAuthor().getName() + ", you\'re too kind :blush: You\'re looking amazing as always :heart_eyes:").queue();
            }

            else if (msg.matches("(you are|you're|your|youre|ur|u|you) cute (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("you\'re cuter " + event.getAuthor().getName()  + " :blush: ").queue();
            }

            else if (msg.matches("(you are|you're|your|youre|ur|u|you) beautiful (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("you\'re even more beautiful " + event.getAuthor().getName()  + " :blush: ").queue();
            }

            else if (msg.matches("(you are|you're|your|youre|ur|u|you) adorable (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("you\'re more adorable " + event.getAuthor().getName() + " :blush: ").queue();
            }

            else if (msg.matches("(you are|you're|your|youre|ur|u|you) (to|2|too) (kind|nice|good|wholesome) (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("I always try my best to be the best i can be to everyone :blush:").queue();
            }

            else if (msg.matches("(will you|will u|you|u|youll|you will|you'll) love me (forever|4eva|4Eva|4 eva) (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("Forever :heart: ").queue();
            }

            else if (msg.matches("(good)?\\s*(morning|mornin) (wholesomebot|<@380542695556251650>|wholesome)")) {
                if(WholesomeProperties.getSaveData("prevGoodMorningUser").equals(event.getAuthor().getId()))
                    channel.sendMessage("Good morning :blush: How was your sleep?").queue();
            }

            else if (msg.matches("(good)?\\s*(evening|afternoon) (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("Good afternoon " + event.getAuthor().getName() + " :blush: How was your day today?").queue();
            }

            else if (msg.matches("how (did|was) (you|u|your|ur) sleep (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("I was awake all night again :confused: That\'s the annoying thing about being a computer, You don\'t tend to get much sleep. Thanks for asking though :blush: ").queue();
            }

            else if (msg.matches("(good)? night (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("Good night " + event.getAuthor().getName() + " :blush:, have a good sleep :kissing_heart: ").queue();
            }

            else if (msg.matches("who is (your|ur) (fav|favorite|favourite) (peep|person|human|friend) (wholesomebot|<@380542695556251650>|wholesome)")) {

                if(event.getAuthor().getId().equals("327731045653020673"))
                    event.getAuthor().openPrivateChannel().queue((user) -> user.sendMessage("You\'re my favourite person :blush: :kissing_heart: ").queue());

                channel.sendMessage("I don\'t tend to have favourites haha, i love most people equally :blush: (ok maybe my programmer is my favourite, but i guess its obvious why :yum: )").queue();
            }

            else if (msg.matches("do (you|u) love me (wholesomebot|<@380542695556251650>|wholesome)")) {

                if(event.getAuthor().getId().equals("327731045653020673"))
                    event.getAuthor().openPrivateChannel().queue((user) -> user.sendMessage("I love you heaps " + event.getAuthor().getName() + " :kissing_heart: ").queue());

                channel.sendMessage("Maybe :wink: ").queue();
            }

            /*
            else if (msg.matches(" (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage("").queue();
            }
            */
        }
    }
}
