package wholesomebot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import wholesomebot.core.WholesomeProperties;
import wholesomebot.utils.logger.LogLevel;
import wholesomebot.utils.logger.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;

public class Recipe extends Command {

    @Override
    public String description() {
        return "I'll show you a list of all the recipes i know.";
    }

    @Override
    public void sendMessage(MessageReceivedEvent event) {
        String msg = event.getMessage().getContentDisplay();
        if(msg.length()==(WholesomeProperties.getPrefix()+"recipe").length()){
            String recipeMsg = "Here's a list of all the recipes i know :blush: \n\n";
            recipeMsg += displayRecipes();
            event.getChannel().sendMessage(recipeMsg).queue();
        }
        else{
            String recipe = msg.substring(msg.indexOf(" ")+1, msg.length());
            event.getChannel().sendMessage(getRecipe(recipe)).queue();
            System.out.println(getRecipe(recipe));
        }
    }

    private String getRecipe(String recipeCmd){
        NodeList nList = getNodeList();
        for(int i=0; i< nList.getLength(); i++){
            Node node = nList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if(element.getAttribute("cmd").equalsIgnoreCase(recipeCmd)){
                    String recipe="";

                    recipe += "**Dish:** " + element.getElementsByTagName("dishName").item(0).getTextContent() + "\n";
                    recipe += "**Description:** " + element.getElementsByTagName("description").item(0).getTextContent() + "\n";
                    if(!element.getElementsByTagName("yield").item(0).getTextContent().equalsIgnoreCase("")){
                        recipe += "**Yield:** " + element.getElementsByTagName("yield").item(0).getTextContent() + "\n";
                    }
                    recipe += "\n";

                    recipe += "**Ingredients:**" + "\n";
                    NodeList childNode = element.getElementsByTagName("ingredientList");
                    Node cNode = childNode.item(0);
                    if (cNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) cNode;
                        for(int k=0; k<childElement.getElementsByTagName("ingredient").getLength(); k++){
                            recipe += childElement.getElementsByTagName("ingredient").item(k).getTextContent() + "\n";
                        }
                    }

                    recipe += "\n";
                    recipe += "**Equipment:**" + "\n";
                    childNode = element.getElementsByTagName("equipment");
                    cNode = childNode.item(0);
                    if (cNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) cNode;
                        for(int k=0; k<childElement.getElementsByTagName("item").getLength(); k++){
                            recipe += childElement.getElementsByTagName("item").item(k).getTextContent() + "\n";
                        }
                    }

                    recipe += "\n";
                    recipe += "**method:**" + "\n";
                    childNode = element.getElementsByTagName("method");
                    cNode = childNode.item(0);
                    if (cNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) cNode;
                        for(int k=0; k<childElement.getElementsByTagName("step").getLength(); k++){
                            recipe += "*Step " + (k+1) + "*: " + childElement.getElementsByTagName("step").item(k).getTextContent() + "\n";
                        }
                    }

                    childNode = element.getElementsByTagName("additionalNotes");
                    cNode = childNode.item(0);
                    if (cNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) cNode;
                        if(childElement.getElementsByTagName("note").getLength()==0){
                            recipe += "\n";
                            recipe += "**Additional notes:**" + "\n";
                            for(int k=0; k<childElement.getElementsByTagName("note").getLength(); k++){
                                recipe += childElement.getElementsByTagName("note").item(k).getTextContent() + "\n";
                            }
                        }
                    }

                    return recipe;
                }
            }
            else{
                return "I cant find that recipe sorry :confused: ";
            }
        }
        return "I cant find that recipe sorry :confused: ";
    }

    private String displayRecipes(){
        String recipes = "";
        NodeList nList = getNodeList();
        for(int i=0; i< nList.getLength(); i++){
            Node node = nList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                recipes += "**Dish:** " + eElement.getElementsByTagName("dishName").item(0).getTextContent() + "\n**cmd:** !recipe " + eElement.getAttribute("cmd");
                recipes += "\n\n";
            }
        }
        return recipes;
    }

    private NodeList getNodeList(){
        NodeList nList = null;
        try {
            File file = new File("resources/recipes.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(file);
            doc.getDocumentElement().normalize();
            nList = doc.getElementsByTagName("recipe");
        }catch(ParserConfigurationException | SAXException | IOException e){
            Logger.log(LogLevel.ERROR, e.toString());
        }

        return nList;
    }
}