package net.wabl.menu;

import java.util.Vector;

public class Story {
    int id;
    String titel;
    String description;
    Vector<Integer> items;
    Vector<Integer> recipes;
    String story;

    public Story(int id, String titel, String description, Vector<Integer> items,
                 Vector<Integer> recipes, String story){
        this.id = id;
        this.titel = titel;
        this.description = description;
        this.items = items;
        this.recipes = recipes;
        this.story = story;
    }
}
