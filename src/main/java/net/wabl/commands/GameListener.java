package net.wabl.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.wabl.main.Server;
import net.wabl.main.Settings;
import net.wabl.types.Game;
import net.wabl.types.NewGame;
import net.wabl.types.Player;
import net.wabl.types.Story;

import static net.wabl.main.Settings.GSON;

public class GameListener extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] message = e.getMessage().getContentRaw().split("\\s+");

        if(!message[0].equalsIgnoreCase(Settings.IDENT + "game")) {
            return;
        }

        if (message[1].equalsIgnoreCase("create")) {
            var channel = e.getChannel().getId();
            var story = GSON.fromJson(Server.get("stories/random", null), Story.class);
            var newGame = new NewGame(channel, story.items);

            var game = GSON.fromJson(Server.get("games", newGame), Game.class);
            e.getChannel().sendMessage(game.toString()).complete();
        } else if (message[1].equalsIgnoreCase("join")){
            var userId = e.getAuthor().getId();
            var channelId = e.getChannel().getId();

            var player = GSON.fromJson(Server.get("players/gc/" + userId, null), Player.class);
            var game = GSON.fromJson(Server.get("games/by-channel", channelId), Game.class);

            game = GSON.fromJson(Server.get("games/" + game.id + "/join/", player.id), Game.class);
            e.getChannel().sendMessage("Joined Game").complete();
        } else if (message[1].equalsIgnoreCase("leave")){
            var userId = e.getAuthor().getId();
            var channelId = e.getChannel().getId();

            var player = GSON.fromJson(Server.get("players/gc/" + userId, null), Player.class);
            var game = GSON.fromJson(Server.get("games/by-channel", channelId), Game.class);

            game = GSON.fromJson(Server.get("games/" + game.id + "/leave/", player.id), Game.class);
            e.getChannel().sendMessage("Joined Game").complete();
        } else if (message[1].equalsIgnoreCase("stop")){
            if (message.length < 3 || message[2] == null) {
                e.getChannel().sendMessage("No id given").complete();
            }
            String id = message[2];
            String response = Server.delete("games/" + id);
            boolean done = GSON.fromJson(response, Boolean.class);
            if (done) {
                e.getChannel().sendMessage("Stopped Game").complete();
            } else {
                e.getChannel().sendMessage("err").complete();
            }
        } else {
            e.getChannel().sendMessage("Command not complete").complete();
        }
    }
}
