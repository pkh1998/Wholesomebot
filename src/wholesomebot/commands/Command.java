package wholesomebot.commands;

import net.dv8tion.jda.core.hooks.ListenerAdapter;
import wholesomebot.main.WholesomeProperties;

public class Command extends ListenerAdapter{

    protected static String prefix = WholesomeProperties.getConfigData("prefix");

    public void setPrefix(String prefix){
        Command.prefix = prefix;
        WholesomeProperties.setConfigProperties("prefix", prefix);
    }
}
