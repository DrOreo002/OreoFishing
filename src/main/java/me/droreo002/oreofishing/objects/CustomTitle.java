package me.droreo002.oreofishing.objects;

import me.droreo002.oreofishing.OreoFishing;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class CustomTitle implements ConfigurationSerializable {

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

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("sub_title", sub_title);
        map.put("fade_in", fade_in);
        map.put("fade_out", fade_out);
        map.put("stay", stay);
        return map;
    }

    public static CustomTitle deserialize(Map<String, Object> map) {
        try {
            String title = (String) map.get("title");
            String sub_title = (String) map.get("sub_title");
            int fade_in = (int) map.get("fade_in");
            int fade_out = (int) map.get("fade_out");
            int stay = (int) map.get("stay");
            return new CustomTitle(title, sub_title, fade_in, fade_out, stay);
        } catch (Exception e) {
            System.out.println("Error!. Cannot deserialize CustomTitle class!");
            return null;
        }
    }

    public static CustomTitle createDefault() {
        return new CustomTitle("Hello", "World", 10, 20, 10);
    }
}
