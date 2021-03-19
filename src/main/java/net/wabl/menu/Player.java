package net.wabl.menu;

public class Player {
    int id;
    String discord_id;

    public Player(int id, String discord_id){
        this.id = id;
        this.discord_id = discord_id;
    }

    @Override
    public String toString(){
        return "id: " + id + ", discord_id: " + discord_id;
    }
}
