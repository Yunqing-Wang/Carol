package net.wabl.menu;

import java.util.Vector;

public class NewStory {
    String titel;
    String description;
    Vector<Integer> items;
    Vector<Integer> recipes;
    String newStory;

    public NewStory(String titel, String description, Vector<Integer> items,
                 Vector<Integer> recipes, String newStory){
        this.titel = titel;
        this.description = description;
        this.items = items;
        this.recipes = recipes;
        this.newStory = newStory;
    }
}
