package net.wabl.commands.admin;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.wabl.main.Server;
import net.wabl.main.Settings;
import net.wabl.types.Recipe;
import net.wabl.types.NewRecipe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static net.wabl.main.Settings.GSON;

public class RecipeListener extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] message = e.getMessage().getContentRaw().split("\\s");

        if(!message[0].equalsIgnoreCase(Settings.IDENT + "recipe")) {
            return;
        }

        if (message[1].equalsIgnoreCase("add")) {
            var operation = Integer.parseInt(message[2]);
            var outcome = Integer.parseInt(message[3]);
            var components_string = message[4].split(",");
            List<Integer> components = Arrays.stream(components_string).map(Integer::parseInt).collect(Collectors.toList());
            var newFood = new NewRecipe(operation, outcome, components);

            String response = Server.post("recipes", newFood);

            var done = GSON.fromJson(response, Recipe.class);
            e.getChannel().sendMessage(done.toString()).complete();
        } else if (message[1].equalsIgnoreCase("update")){
            var id = message[2];
            var operation = Integer.parseInt(message[3]);
            var outcome = Integer.parseInt(message[4]);
            var components_string = message[5].split(",");
            List<Integer> components = Arrays.stream(components_string).map(Integer::parseInt).collect(Collectors.toList());
            var newFood = new NewRecipe(operation, outcome, components);

            String response = Server.patch("recipes/" + id, newFood);

            var done = GSON.fromJson(response, Recipe.class);
            e.getChannel().sendMessage(done.toString()).complete();
        } else if (message[1].equalsIgnoreCase("remove")){
            if (message.length < 3 || message[2] == null) {
                e.getChannel().sendMessage("No id given").complete();
            }

            String id = message[2];
            String response = Server.delete("recipes/" + id);

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
