package net.wabl.main;

import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Reactions extends ListenerAdapter {
    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent emoji) {
        /*if (emoji.getReactionEmote().getName().equals("U+1F600")) {
            emoji.getChannel().sendMessage("this is a test...").complete().addReaction("U+1F600").queue();
            emoji.getChannel().getHistory().getMessageById(emoji.getMessageId()).delete().queue();
        }*/
    }
}
