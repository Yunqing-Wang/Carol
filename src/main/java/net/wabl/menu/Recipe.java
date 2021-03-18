package net.wabl.menu;

import java.util.List;
import java.util.Vector;

public class Recipe {
    int id;
    List<Integer> operation;
    int outcome;
    Vector<Integer> components;

    public Recipe(int id, List<Integer> operation, int outcome, Vector<Integer> components){
        this.id = id;
        this.operation = operation;
        this.outcome = outcome;
        this.components = components;
    }
}
