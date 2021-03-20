package net.wabl.types;

import java.util.UUID;
import java.util.Vector;

public class PlayerInventory {
    UUID id;
    int player;
    UUID game;
    Vector<Integer> inventory;

    public PlayerInventory(UUID id, int player, UUID game, Vector<Integer> inventory){
        this.id = id;
        this.player = player;
        this.game = game;
        this.inventory = inventory;
    }
}
