package me.droreo002.oreofishing.objects;

import com.google.common.escape.Escaper;
import org.bukkit.Sound;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

public class CustomSound implements ConfigurationSerializable {

    private Sound sound;
    private float volume;
    private float pitch;

    public CustomSound(String sound, float volume, float pitch) {
        try {
            this.sound = Sound.valueOf(sound);
        } catch (Exception e) {
            System.out.println("Cannot find sound name (" + sound + ")");
            return;
        }
        this.volume = volume;
        this.pitch = pitch;
    }

    public void play(Player player) {
        player.playSound(player.getLocation(), sound, volume, pitch);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("sound", sound.toString());
        map.put("volume", volume);
        map.put("pitch", pitch);
        return map;
    }

    public static CustomSound deserialize(Map<String, Object> map) {
        try {
            String sound = (String) map.get("sound");
            float volume = (float) map.get("volume");
            float pitch = (float) map.get("pitch");
            return new CustomSound(sound, volume, pitch);
        } catch (Exception e) {
            System.out.println("Error!. Cannot deserialize CustomSound class!");
            return null;
        }
    }
}
