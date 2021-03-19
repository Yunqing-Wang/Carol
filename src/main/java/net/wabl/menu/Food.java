package net.wabl.menu;

import javax.swing.text.html.Option;

public class Food {
    int id;
    String name;
    Option description;
    int emoji;

    public Food(int id, String name, int emoji, Option description){
        this.id = id;
        this.name = name;
        this.description = description;
        this.emoji = emoji;
    }

    @Override
    public String toString(){
        return "id: " + id + ", name: " + name + ", description: " + description + ", emoji: " + emoji;
    }
}
