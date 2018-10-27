package me.droreo002.oreofishing.enums;

import me.droreo002.oreofishing.OreoFishing;
import me.droreo002.oreofishing.objects.Placeholder;
import org.apache.commons.lang.Validate;
import org.bukkit.entity.Player;

import java.util.Map;

public enum FishingLang {

    COMMAND_NO_PERMISSION("command-no-permission", false, null);


    private String path;
    private boolean hasPlaceholder;
    private Placeholder placeholder;
    private OreoFishing main;

    FishingLang(String path, boolean hasPlaceholder, Placeholder placeholder) {
        this.path = path;
        this.hasPlaceholder = hasPlaceholder;
        this.placeholder = placeholder;
    }

    public void send(Player player) {
        String toSend = main.color(main.getLangFileManager().getLangFile().getString(path));
        Validate.notNull(toSend, "Cannot find message with the path of " + path + ". Please contact the developer!");
        if (hasPlaceholder) {
            player.sendMessage(toSend.replaceAll(placeholder.getFrom(), placeholder.getTo()));
        } else {
            player.sendMessage(toSend);
        }
    }

    public String getPath() {
        return path;
    }

    public boolean isHasPlaceholder() {
        return hasPlaceholder;
    }

    public Placeholder getPlaceholder() {
        return placeholder;
    }

    public OreoFishing getMain() {
        return main;
    }
}
