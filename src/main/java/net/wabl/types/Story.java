package net.wabl.types;


import java.util.List;

public class Story {
    public int id;
    public String title;
    public String description;
    public List<Integer> items;
    public List<Integer> recipes;
    public String story;

    public Story(int id, String title, String description, String story, List<Integer> items,
                 List<Integer> recipes){
        this.id = id;
        this.title = title;
        this.description = description;
        this.story = story;
        this.items = items;
        this.recipes = recipes;
    }

    @Override
    public String toString(){
        return "id: ";
    }
}
