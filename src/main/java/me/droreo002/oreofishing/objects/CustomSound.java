package me.droreo002.oreofishing.objects;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class CustomSound {

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
}
