package net.wabl.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.wabl.main.Server;
import net.wabl.main.Settings;
import net.wabl.menu.Emoji;
import net.wabl.menu.NewEmoji;

import static net.wabl.main.Settings.GSON;

public class EmojiListener extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] message = e.getMessage().getContentRaw().split("\\s+");

        if(!message[0].equalsIgnoreCase(Settings.IDENT + "emoji")) {
            return;
        }

        if (message[1].equalsIgnoreCase("add")) {
            if (message.length < 3 || message[2] == null) {
                e.getChannel().sendMessage("No emoji name given").complete();
            }
            String name = message[2];
            NewEmoji emoji = new NewEmoji(name);
            String response = Server.post("emojis", emoji);
            Emoji done = GSON.fromJson(response, Emoji.class);
            e.getChannel().sendMessage(done.toString()).complete();
        } else if (message[1].equalsIgnoreCase("update")){
            e.getChannel().sendMessage("Unimplemented").complete();
        } else if (message[1].equalsIgnoreCase("remove")){
            e.getChannel().sendMessage("Unimplemented").complete();
        } else {
            e.getChannel().sendMessage("Command not complete").complete();
        }
    }
}
