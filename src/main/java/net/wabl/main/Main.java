package net.wabl.main;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault("ODIxNDgzNzk3NjIyNjg1Njk2.YFEYZw.ZC-vI8NOZlH_rbgXlTsfRyM8qoc").build();
        jda.addEventListener(new Embed());
    }
}