package wholesomebot.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WholesomeProperties {

    private static Properties saveProperties = getProperties("resources/savedData.properties"), configProperties = getProperties("resources/config.properties");

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

    public static void reloadProperties(){
        saveProperties = getProperties("resources/savedData.properties");
        configProperties = getProperties("resources/config.properties");
    }

    public static String getSaveData(String key){
        return saveProperties.getProperty(key);
    }

    public static String getConfigData(String key){
        return configProperties.getProperty(key);
    }

    public static void setSaveProperties(String key, String value) {
        saveProperties.setProperty(key, value);
    }

    public static void setConfigProperties(String key, String value){
        configProperties.setProperty(key, value);
    }
}
