package net.wabl.menu;

import java.util.Vector;

public class NewRecipe {
    int id;
    int operation;
    int outcome;
    Vector<Integer> components;

    public NewRecipe(int id, int operation, int outcome, Vector<Integer> components){
        this.id = id;
        this.operation = operation;
        this.outcome = outcome;
        this.components = components;
    }
}
