package net.wabl.types;

import java.util.List;

public class NewStory {
    String title;
    String description;
    String story;
    List<Integer> items;
    List<Integer> recipes;


    public NewStory(String title, String description, String story, List<Integer> items,
                    List<Integer> recipes){
        this.title = title;
        this.description = description;
        this.story = story;
        this.items = items;
        this.recipes = recipes;
    }
}
