package net.wabl.main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Embed extends ListenerAdapter  {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String args = event.getMessage().getContentRaw();
        String title = "Pudding";
        String description = "If they have no bread to eat, why don't they just have some pudding?";
        String ingredients = "Ingredients";
        String ingredientDes = "How does hunger taste, my life is only made out of egg, butter and honey.";
        String recipes = "Recipes";
        String operations = "Here are some operations...";
        String Inventar = "Inventar";


        if(args.startsWith("test")){
            EmbedBuilder story = new EmbedBuilder();

            story.setTitle(title);
            story.setDescription(description);
            story.addField(ingredients, ingredientDes, false);
            story.addField(recipes, operations, false);
            story.setColor(0xffeb99);

            EmbedBuilder inventar = new EmbedBuilder();
            inventar.setTitle(Inventar);
            inventar.setColor(0xffeb99);

            //if(event.getMessage().getContentRaw().startsWith("Inventar")) {
                event.getChannel().sendMessage(story.build()).complete().addReaction().queue();
            //}

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(story.build()).queue();
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(inventar.build()).queue();
            story.clear();
            inventar.clear();
        }
    }
}
