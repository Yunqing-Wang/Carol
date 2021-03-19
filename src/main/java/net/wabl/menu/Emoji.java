package net.wabl.menu;

public class Emoji {
    int id;
    String name;

    public Emoji(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "id: " + id + ", name: " + name;
    }
}
