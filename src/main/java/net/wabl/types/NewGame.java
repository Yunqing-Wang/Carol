package net.wabl.types;

import java.util.Vector;

public class NewGame {
    String channel_id;
    Vector<Integer> inventory;

    public NewGame(String channel_id, Vector<Integer> inventory){
        this.channel_id = channel_id;
        this.inventory = inventory;
    }
}
