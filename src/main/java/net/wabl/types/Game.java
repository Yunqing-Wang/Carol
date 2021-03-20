package net.wabl.types;

import java.util.UUID;
import java.util.Vector;

public class Game {
    public UUID id;
    public String channel_id;
    public Vector<Integer> players;
    public Vector<UUID> player_inventories;
    public Vector<Integer> inventory;

    public Game(UUID id, String channel_id, Vector<Integer> players,
                Vector<UUID> player_inventories, Vector<Integer> inventory){
        this.id = id;
        this.players = players;
        this.channel_id = channel_id;
        this.player_inventories = player_inventories;
        this.inventory = inventory;
    }
}
