package wholesomebot.commands;

import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Command extends ListenerAdapter{

    protected static String prefix;

    public Command(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("resources/config.properties"));
        }catch (IOException e){
            System.out.println("could not find config file\n" + e);
        }
        prefix = properties.getProperty("prefix");
    }

    public void setPrefix(String prefix){
        Command.prefix = prefix;
    }
}
