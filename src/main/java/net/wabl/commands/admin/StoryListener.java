package net.wabl.commands.admin;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.wabl.main.Server;
import net.wabl.main.Settings;
import net.wabl.types.Recipe;
import net.wabl.types.Story;
import net.wabl.types.NewStory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static net.wabl.main.Settings.GSON;

public class StoryListener extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] message = e.getMessage().getContentRaw().split("\"\\s\"");

        if(!message[0].equalsIgnoreCase(Settings.IDENT + "story")) {
            return;
        }

        if (message[1].equalsIgnoreCase("add")) {
            var title = message[2];
            var description = message[3];
            var story = message[4];
            var items_string = message[5].split(",");
            List<Integer> items = Arrays.stream(items_string).map(Integer::parseInt).collect(Collectors.toList());
            var recipes_string = message[6].split(",");
            List<Integer> recipes = Arrays.stream(recipes_string).map(Integer::parseInt).collect(Collectors.toList());

            var newStory = new NewStory(title, description, story, items, recipes);
            String response = Server.post("stories", newStory);

            var done = GSON.fromJson(response, Story.class);
            e.getChannel().sendMessage(done.toString()).complete();

        } else if (message[1].equalsIgnoreCase("update")){
            var id = message[2];
            var title = message[3];
            var description = message[4];
            var story = message[5];
            var items_string = message[6].split(",");
            List<Integer> items = Arrays.stream(items_string).map(Integer::parseInt).collect(Collectors.toList());
            var recipes_string = message[7].split(",");
            List<Integer> recipes = Arrays.stream(recipes_string).map(Integer::parseInt).collect(Collectors.toList());

            var newStory = new NewStory(title, description, story, items, recipes);
            String response = Server.patch("stories/" + id, newStory);

            var done = GSON.fromJson(response, Story.class);
            e.getChannel().sendMessage(done.toString()).complete();
        } else if (message[1].equalsIgnoreCase("remove")){
            if (message.length < 3 || message[2] == null) {
                e.getChannel().sendMessage("No id given").complete();
            }
            String id = message[2];
            String response = Server.delete("stories/" + id);
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
