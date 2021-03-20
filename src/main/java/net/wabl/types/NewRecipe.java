package net.wabl.types;

import java.util.List;

public class NewRecipe {
    int operation;
    int outcome;
    List<Integer> components;

    public NewRecipe(int operation, int outcome, List<Integer> components){
        this.operation = operation;
        this.outcome = outcome;
        this.components = components;
    }
}
