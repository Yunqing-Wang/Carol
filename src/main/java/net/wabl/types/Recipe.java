package net.wabl.types;

import java.util.List;

public class Recipe {
    int id;
    int operation;
    int outcome;
    List<Integer> components;

    public Recipe(int id, int operation, int outcome, List<Integer> components){
        this.id = id;
        this.operation = operation;
        this.outcome = outcome;
        this.components = components;
    }

    @Override
    public String toString(){
       return "id: " + id + ", operation: " + operation + ", outcome: " + outcome + ", components: " + components.toString();
    }
}
