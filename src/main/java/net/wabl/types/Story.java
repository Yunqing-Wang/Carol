package net.wabl.types;

import java.util.Vector;

public class Story {
    public int id;
    public String title;
    public String description;
    public Vector<Integer> items;
    public Vector<Integer> recipes;
    public String story;

    public Story(int id, String title, String description, String story, Vector<Integer> items,
                 Vector<Integer> recipes){
        this.id = id;
        this.title = title;
        this.description = description;
        this.story = story;
        this.items = items;
        this.recipes = recipes;
    }
}
