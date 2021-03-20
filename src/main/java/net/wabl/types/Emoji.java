package net.wabl.types;

public class Emoji {
    int id;
    String name;
    String utf8;

    public Emoji(int id, String name, String utf8){
        this.id = id;
        this.name = name;
        this.utf8 = utf8;
    }

    public String toString() {
        return "id: " + id + ", name: " + name + ", utf8: " + utf8;
    }
}
