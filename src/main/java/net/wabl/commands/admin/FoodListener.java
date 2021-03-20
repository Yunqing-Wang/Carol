package net.wabl.commands.admin;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.wabl.main.Server;
import net.wabl.main.Settings;
import net.wabl.types.Food;
import net.wabl.types.NewFood;

import static net.wabl.main.Settings.GSON;

public class FoodListener extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] message = e.getMessage().getContentRaw().split("\"\\s\"");

        if(!message[0].equalsIgnoreCase(Settings.IDENT + "food")) {
            return;
        }

        if (message[1].equalsIgnoreCase("add")) {
            var name = message[2];
            var emoji = Integer.parseInt(message[3]);
            String description;
            if (message.length < 5) {
                description = null;
            } else {
                description = message[4];
            }

            var newFood = new NewFood(name, emoji, description);

            String response = Server.post("foods", newFood);

            var done = GSON.fromJson(response, Food.class);
            e.getChannel().sendMessage(done.toString()).complete();
        } else if (message[1].equalsIgnoreCase("update")){
            var id = message[2];
            var name = message[3];
            var emoji = Integer.parseInt(message[4]);
            String description;
            if (message.length < 6) {
                description = null;
            } else {
                description = message[5];
            }

            var newFood = new NewFood(name, emoji, description);
            String response = Server.post("foods/" + id, newFood);

            var done = GSON.fromJson(response, Food.class);
            e.getChannel().sendMessage(done.toString()).complete();
        } else if (message[1].equalsIgnoreCase("remove")){
            if (message.length < 3 || message[2] == null) {
                e.getChannel().sendMessage("No id given").complete();
            }

            String id = message[2];
            String response = Server.delete("foods/" + id);

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
