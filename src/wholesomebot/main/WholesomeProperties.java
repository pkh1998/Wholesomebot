package wholesomebot.main;

import java.io.*;
import java.util.Properties;

public class WholesomeProperties {

    private static Properties save = getProperties("resources/savedData.properties"), config = getProperties("resources/config.properties");
    private static OutputStream out;

    private static Properties getProperties(String path){
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(path));
        }catch (IOException e){
            System.out.println("could not find "+path.substring(path.lastIndexOf("/")+1)+"\n" + e);
        }
        System.out.println(path.substring(path.lastIndexOf("/")+1) + " loaded");
        return prop;
    }

    /*
     * Getting config data
     */

    public static String getToken(){
        return config.getProperty("token");
    }

    public static String getPrefix(){
        return config.getProperty("prefix");
    }

    public static String getPreviousGoodMorningUser(){
        return save.getProperty("prevGoodMorningUser");
    }

    public static String getMorningMessageTime(){
        return config.getProperty("morningMessageTime");
    }

    public static String getWholesomeMessageTime(){
        return config.getProperty("wholesomeMessageTime");
    }

    public static String getPublicChannel(){
        return config.getProperty("publicChannel");
    }

    public static String getWelcomeChannel(){
        return config.getProperty("welcomeChannel");
    }

    public static String getLastWholesomeMessage(){
        return save.getProperty("lastWholesomeMessage");
    }

    public static String getAdminRole(){
        return config.getProperty("adminRole");
    }

    public static void setPrefix(String prefix){
        config.setProperty("prefix", prefix);
        try{
            out = new FileOutputStream(new File("resources/config.properties"));
            config.store(out,"Changed Property");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void saveMorningMessageUser(String user){
        save.setProperty("morningUser", user);
        try{
            out = new FileOutputStream(new File("resources/savedData.properties"));
            save.store(out,"Changed Property");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void saveLastWholesomeMessage(String msg){
        save.setProperty("lastWholesomeMessage", msg);
        try{
            out = new FileOutputStream(new File("resources/savedData.properties"));
            save.store(out,"Changed Property");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
