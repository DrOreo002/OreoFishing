package me.droreo002.oreofishing.objects;

import me.droreo002.oreofishing.OreoFishing;
import org.bukkit.entity.Player;

public class CustomTitle {

    private String title;
    private String sub_title;
    private int fade_in;
    private int fade_out;
    private int stay;

    public CustomTitle(String title, String sub_title, int fade_in, int fade_out, int stay) {
        this.title = title;
        this.sub_title = sub_title;
        this.fade_in = fade_in;
        this.fade_out = fade_out;
        this.stay = stay;
    }

    public void send(Player player) {
        player.sendTitle(OreoFishing.get().color(title), OreoFishing.get().color(sub_title), fade_in, stay, fade_out);
    }
}
