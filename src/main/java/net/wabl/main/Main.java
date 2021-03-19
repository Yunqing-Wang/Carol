package net.wabl.main;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.wabl.commands.EmojiListener;
import net.wabl.commands.GameListener;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        Dotenv dotenv = Dotenv.load();

        JDA jda = JDABuilder.createDefault(dotenv.get("TOKEN")).build();
        jda.addEventListener(new TestListener());
        jda.addEventListener(new EmojiListener());
        jda.addEventListener(new GameListener());
    }
}