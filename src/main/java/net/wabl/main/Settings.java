package net.wabl.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Settings {
    public static final String IDENT = "!";
    public static final Gson GSON = new GsonBuilder().disableHtmlEscaping().setLenient()
            .setPrettyPrinting().create();
}
