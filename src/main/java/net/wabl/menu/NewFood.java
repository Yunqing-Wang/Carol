package net.wabl.menu;

import javax.swing.text.html.Option;

public class NewFood {
    String name;
    Option description;
    int emoji;

    public NewFood(String name, Option description, int emoji){
        this.name = name;
        this.description = description;
        this.emoji = emoji;
    }
}
