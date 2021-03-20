package net.wabl.types;

import java.util.List;


public class NewGame {
    String channel_id;
    List<Integer> inventory;

    public NewGame(String channel_id, List<Integer> inventory){
        this.channel_id = channel_id;
        this.inventory = inventory;
    }
}
