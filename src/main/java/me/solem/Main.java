package me.solem;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;


public class Main {
    public static void main(String[] args) {
        String token = "OTc4ODk4MzM4NjU1MTE3MzEy.GEWshs.yXn5xzjQnPWdEHOL3swpBUtNsDXZyc-F9CvYiw";
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        //Message Listener
        api.addMessageCreateListener(event -> {
           if (event.getMessageContent().equalsIgnoreCase("!ping")){
               event.getChannel().sendMessage("Pong!");
           }

        });

    System.out.println("You can invite the bot by using the link: " + api.createBotInvite());

    }
}