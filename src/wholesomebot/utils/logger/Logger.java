package wholesomebot.utils.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.BufferedWriter;

public final class Logger{

    private static DateFormat timeFormat = new SimpleDateFormat("HH:mm");
    private static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static void log(LogLevel logLevel, String msg){
        StringBuilder logMsg = new StringBuilder(timeFormat.format(new Date())).append(" - ");
        switch (logLevel){
            case INFO:
                logMsg.append("[INFO] - ");
                break;
            case NOTICE:
                logMsg.append("[NOTICE] - ");
                break;
            case WARNING:
                logMsg.append("[WARNING] - ");
                break;
            case ERROR:
                logMsg.append("[ERROR] - ");
                break;
        }

        logMsg.append(msg);
        System.out.println(logMsg);
        logToFile(logMsg.toString());
    }

    private static void logToFile(String msg){
        new File("logs").mkdir();

        try{
            String filename = "logs/" + dateFormat.format(new Date()) + ".log";
            BufferedWriter out = new BufferedWriter(new FileWriter(filename, true));
            out.append(msg);
            out.newLine();
            out.close();
        } catch (IOException e){
            System.out.println("[ERROR] - failed to write log to file");
            System.out.println(e.toString());
        }
    }
}