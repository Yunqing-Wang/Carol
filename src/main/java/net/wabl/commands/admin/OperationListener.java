package net.wabl.commands.admin;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.wabl.main.Server;
import net.wabl.main.Settings;
import net.wabl.types.Operation;
import net.wabl.types.NewOperation;

import static net.wabl.main.Settings.GSON;

public class OperationListener extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] message = e.getMessage().getContentRaw().split("\\s+");

        if(!message[0].equalsIgnoreCase(Settings.IDENT + "operation")) {
            return;
        }

        if (message[1].equalsIgnoreCase("add")) {
            if (message.length < 3 || message[2] == null) {
                e.getChannel().sendMessage("No emoji name given").complete();
            }

            var emoji = message[2];
            var operation = new NewOperation(Integer.parseInt(emoji));

            String response = Server.post("operations", operation);

            var done = GSON.fromJson(response, Operation.class);
            e.getChannel().sendMessage(done.toString()).complete();
        } else if (message[1].equalsIgnoreCase("update")){
            if (message.length < 3 || message[2] == null) {
                e.getChannel().sendMessage("No id given").complete();
            }
            if (message.length < 4 || message[3] == null) {
                e.getChannel().sendMessage("No operation name given").complete();
            }

            var id = message[2];
            var emoji = message[3];
            var operation = new NewOperation(Integer.parseInt(emoji));

            var response = Server.patch("operations/" + id, operation);

            var done = GSON.fromJson(response, Operation.class);
            e.getChannel().sendMessage(done.toString()).complete();
        } else if (message[1].equalsIgnoreCase("remove")){
            if (message.length < 3 || message[2] == null) {
                e.getChannel().sendMessage("No id given").complete();
            }

            var id = message[2];

            var response = Server.delete("operations/" + id);

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
