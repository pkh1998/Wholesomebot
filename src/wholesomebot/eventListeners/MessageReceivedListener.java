package wholesomebot.eventListeners;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageReceivedListener extends ListenerAdapter {

    private String[] howAreYouReplies, howDoYouWorkReplies, whatAreYouDoingReplies, yourWelcomes;
    private Random random = new Random();

    public MessageReceivedListener(String[] howAreYouReplies, String[] howDoYouWorkReplies, String[] whatAreYouDoingReplies, String[] yourWelcomes){
        this.howAreYouReplies = howAreYouReplies;
        this.howDoYouWorkReplies = howDoYouWorkReplies;
        this.whatAreYouDoingReplies = whatAreYouDoingReplies;
        this.yourWelcomes = yourWelcomes;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContentDisplay().toLowerCase();

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
                channel.sendMessage("No problem :blush:").queue();
            }

            // if message is a variation of 'how are you wholesomebot'
            else if (msg.matches("(how are|how're)\\s+you\\s+((doing|today)\\s+)*(wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage(howAreYouReplies[random.nextInt(howAreYouReplies.length)]).queue();
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
                channel.sendMessage(howDoYouWorkReplies[random.nextInt(howDoYouWorkReplies.length)]).queue();
            }

            //if message is a variation of 'what are you up to wholesomebot
            else if (msg.matches("(what are|what're) you (up to|doing) (wholesomebot|<@380542695556251650>|wholesome)")) {
                channel.sendMessage(whatAreYouDoingReplies[random.nextInt(whatAreYouDoingReplies.length)]).queue();
            }
        }
        else
            System.out.println("no match found");
    }
}
