package net.wabl.main;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Reactions extends ListenerAdapter {
    public void createInventar(GuildMessageReceivedEvent event, GuildMessageReactionAddEvent emoji){
        String message = event.getMessage().getContentRaw();
        if(message.startsWith("Inventar")){

        }
    }
}
