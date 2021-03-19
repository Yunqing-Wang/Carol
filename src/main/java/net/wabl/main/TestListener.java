package net.wabl.main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TestListener extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String args = event.getMessage().getContentRaw();
        String title = "Pudding";
        String description = "If they have no bread to eat, why don't they just have some pudding?";
        String ingredients = "Ingredients";
        String ingredientDes = "How does hunger taste, my life is only made out of egg, butter and honey.";
        String recipes = "Recipes";
        String operations = "Here are some operations...";
        String Inventar = "Inventar";


        if (args.startsWith("test")) {
            EmbedBuilder story = new EmbedBuilder();

            story.setTitle(title);
            story.setDescription(description);
            story.addField(ingredients, ingredientDes, false);
            story.addField(recipes, operations, false);
            story.setColor(0xffeb99);


            EmbedBuilder inventar = new EmbedBuilder();
            inventar.setTitle(Inventar);
            inventar.setColor(0xffeb99);

            event.getChannel().sendMessage(story.build()).queue();
            event.getChannel().sendMessage(inventar.build()).complete().addReaction("U+1F600").queue();

            story.clear();
            inventar.clear();
        }
    }
}
