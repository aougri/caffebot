package me.solem.command;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class CopyAvatar implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event){
        if(event.getMessageContent().equalsIgnoreCase("!copyAvatar")){
            if(!event.getMessage().getAuthor().isBotOwner()){
                event.getChannel().sendMessage("You are not allowed to use this command!");
                return;
            }
            event.getApi()
                    .updateAvatar(event.getMessage().getAuthor().getAvatar())
                    .thenRun(()->event.getChannel().sendMessage("Ok, now I am using your avatar"))
                    .exceptionally(throwable -> {
                        event.getChannel().sendMessage("Something went wrong: " + throwable.getMessage());
                        return null;
                    });
        }
    }
}
