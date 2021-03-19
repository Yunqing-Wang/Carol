package net.wabl.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.wabl.main.Server;
import net.wabl.main.Settings;

public class GameListener extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
//        String[] message = e.getMessage().getContentRaw().split("\\s+");
//
//        if(!message[0].equalsIgnoreCase(Settings.IDENT + "game")) {
//            return;
//        }
//
//        if (message[1].equalsIgnoreCase("create")) {
//            String re = Server.get("emojis", null);
//            String response = Server.post("games/", );
//
//            e.getChannel().sendMessage(response).complete();
//        } else if (message[1].equalsIgnoreCase("join")){
//            e.getChannel().sendMessage("Joining").complete();
//        } else if (message[1].equalsIgnoreCase("leave")){
//            e.getChannel().sendMessage("Joining").complete();
//        } else if (message[1].equalsIgnoreCase("stop")){
//
//            e.getChannel().sendMessage("Joining").complete();
//        } else {
//            e.getChannel().sendMessage("Command not complete").complete();
//        }
    }
}
