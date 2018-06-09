package wholesomebot.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class ResponseMessages {
    private static String[] wholesomeMsgs = getMessages("resources/messages/wholesomeMessages.txt"),
            cheerUpMessages = getMessages("resources/messages/cheerUpMessages.txt"),
            compliments = getMessages("resources/messages/compliments.txt"),
            quotes = getMessages("resources/messages/quotes.txt"),
            howAreYouReplies = getMessages("resources/messages/howAreYouReplies.txt"),
            howDoYouWorkReplies = getMessages("resources/messages/howDoYouWorkReplies.txt"),
            whatAreYouDoingReplies = getMessages("resources/messages/whatAreYouDoingReplies.txt"),
            yourWelcomes = getMessages("resources/messages/yourWelcomes.txt"),
            presence = getMessages("resources/presence.txt");

    public static File[] imgs = new File("resources/pictures").listFiles();
    private static Scanner inputStream;

    private static String[] getMessages(String path){
        String[] msgs = new String[0];
        try{
            inputStream = new Scanner(new File(path));
        }catch(FileNotFoundException e){
            System.out.println("File \""+path+"\" not found");
        }
        while(inputStream.hasNextLine()){
            String line = inputStream.nextLine();
            if(!line.equalsIgnoreCase("")){
                msgs = increaseArraySize(msgs);
                msgs[msgs.length-1] = line;
            }
        }
        System.out.println("Array: " + path.substring(path.lastIndexOf("/")+1,path.length()-4) + " Successfully read");
        return msgs;
    }

    private static String[] increaseArraySize(String[] array){
        String[] newArray = new String[array.length+1];
        for(int i=0; i<array.length; i++){
            newArray[i] = array[i];
        }
        return newArray;
    }

    public static String[] getWholesomeMsgs(){
        return wholesomeMsgs;
    }

    public static String[] getCheerUpMessages() {
        return cheerUpMessages;
    }

    public static String[] getCompliments() {
        return compliments;
    }

    public static String[] getQuotes() {
        return quotes;
    }

    public static String[] getHowAreYouReplies() {
        return howAreYouReplies;
    }

    public static String[] getHowDoYouWorkReplies() {
        return howDoYouWorkReplies;
    }

    public static String[] getWhatAreYouDoingReplies() {
        return whatAreYouDoingReplies;
    }

    public static String[] getYourWelcomes() {
        return yourWelcomes;
    }

    public static String[] getPresence() {
        return presence;
    }

    public static File[] getImgs() {
        return imgs;
    }

    public static void reloadMessages(){
        wholesomeMsgs = getMessages("resources/messages/wholesomeMessages.txt");
        cheerUpMessages = getMessages("resources/messages/cheerUpMessages.txt");
        compliments = getMessages("resources/messages/compliments.txt");
        quotes = getMessages("resources/messages/quotes.txt");
        howAreYouReplies = getMessages("resources/messages/howAreYouReplies.txt");
        howDoYouWorkReplies = getMessages("resources/messages/howDoYouWorkReplies.txt");
        whatAreYouDoingReplies = getMessages("resources/messages/whatAreYouDoingReplies.txt");
        yourWelcomes = getMessages("resources/messages/yourWelcomes.txt");
        presence = getMessages("resources/presence.txt");
        System.out.println("Messages reloaded");
    }
}
