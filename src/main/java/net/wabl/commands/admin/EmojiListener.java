package net.wabl.commands.admin;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.wabl.main.Server;
import net.wabl.main.Settings;
import net.wabl.types.Emoji;
import net.wabl.types.NewEmoji;

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
            if (message.length < 4 || message[3] == null) {
                e.getChannel().sendMessage("No utf8 given").complete();
            }
            String name = message[2];
            String utf8 = message[3];
            NewEmoji emoji = new NewEmoji(name, utf8);
            String response = Server.post("emojis", emoji);
            Emoji done = GSON.fromJson(response, Emoji.class);
            e.getChannel().sendMessage(done.toString()).complete();
        } else if (message[1].equalsIgnoreCase("update")){
            if (message.length < 3 || message[2] == null) {
                e.getChannel().sendMessage("No id given").complete();
            }
            if (message.length < 4 || message[3] == null) {
                e.getChannel().sendMessage("No emoji name given").complete();
            }
            if (message.length < 5 || message[4] == null) {
                e.getChannel().sendMessage("No utf8 given").complete();
            }
            String id = message[2];
            String name = message[3];
            String utf8 = message[4];
            NewEmoji emoji = new NewEmoji(name, utf8);
            String response = Server.patch("emojis/" + id, emoji);
            Emoji done = GSON.fromJson(response, Emoji.class);
            e.getChannel().sendMessage(done.toString()).complete();
        } else if (message[1].equalsIgnoreCase("remove")){
            if (message.length < 3 || message[2] == null) {
                e.getChannel().sendMessage("No id given").complete();
            }
            String id = message[2];
            String response = Server.delete("emojis/" + id);
            boolean done = GSON.fromJson(response, Boolean.class);
            if (done) {
                e.getChannel().sendMessage("removed").complete();
            } else {
                e.getChannel().sendMessage("err").complete();
            }

        } else {
            e.getChannel().sendMessage("Command not complete").complete();
        }
    }
}
