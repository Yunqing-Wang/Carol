package net.wabl.menu;

public class Food {
    int id;
    String name;
    String description = "";
    int emoji;

    public Food(int id, String name, int emoji, String[] description){
        this.id = id;
        this.name = name;
        this.description = description[0];
        this.emoji = emoji;
    }
}
