package net.wabl.types;

public class Food {
    int id;
    String name;
    int emoji;
    String description;

    public Food(int id, String name, int emoji, String description){
        this.id = id;
        this.name = name;
        this.emoji = emoji;
        this.description = description;
    }

    @Override
    public String toString(){
        return "id: " + id + ", name: " + name + ", description: " + description + ", emoji: " + emoji;
    }
}
