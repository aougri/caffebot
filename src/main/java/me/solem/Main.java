package me.solem;

import me.solem.command.UserInfo;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import me.solem.command.CopyAvatar;


public class Main {
    public static void main(String[] args) {
        String token = "token-here";
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        //Message Listener
        api.addMessageCreateListener(event -> {
           if (event.getMessageContent().equalsIgnoreCase("!ping")){
               event.getChannel().sendMessage("Pong!");
           }
           if (event.getMessageContent().equalsIgnoreCase("Hello!")){
               event.getChannel().sendMessage("Hello there!");
           }

        });

        api.addMessageCreateListener(new CopyAvatar());
        api.addMessageCreateListener(new UserInfo());



    System.out.println("You can invite the bot by using the link: " + api.createBotInvite());

    }
}