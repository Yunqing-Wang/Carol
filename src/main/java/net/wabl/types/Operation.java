package net.wabl.types;

public class Operation {
    int id;
    int emoji;

    public Operation(int id, int emoji){
        this.id = id;
        this.emoji = emoji;
    }

    @Override
    public String toString(){
        return "id: " + id + ", emoji: " + emoji;
    }
}
