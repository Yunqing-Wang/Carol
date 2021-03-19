package net.wabl.menu;

import java.util.UUID;
import java.util.Vector;

public class Game {
    UUID id;
    String channel_id;
    Vector<Integer> players;
    Vector<UUID> player_inventories;
    Vector<Integer> inventory;

    public Game(UUID id, String channel_id, Vector<Integer> players,
                Vector<UUID> player_inventories, Vector<Integer> inventory){
        this.id = id;
        this.players = players;
        this.channel_id = channel_id;
        this.player_inventories = player_inventories;
        this.inventory = inventory;
    }

    @Override
    public String toString(){
        return "id: " + id + ", channel_id: " + channel_id + ", players: " + players.toString() + ", player_inventories: " +
                player_inventories + ", inventory: " + inventory;
    }
}
