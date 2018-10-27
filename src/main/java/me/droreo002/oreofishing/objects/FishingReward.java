package me.droreo002.oreofishing.objects;

import javafx.beans.binding.ObjectExpression;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FishingReward implements ConfigurationSerializable {

    /*
    Useful data (Java)
     */
    private String name;
    /*
    Useful data (Custom object)
     */
    private CustomTitle customTitle;
    private CustomSound customSound;
    /*
    Rewards data
     */
    private String displayName;
    private List<ItemStack> item;
    private String broadcastMessage;
    private String catchMessage;
    private String command;
    private String permission;
    private List<String> desc;
    /*
    Booleans
     */
    private boolean useItem;
    private boolean useCommand;
    private boolean useBroadcast;
    private boolean useMessage;
    private boolean usePermission;
    private boolean useTitle;
    private boolean useSound;

    public FishingReward(String name, CustomTitle customTitle, CustomSound customSound, String displayName, List<ItemStack> item, String broadcastMessage, String catchMessage, String command, String permission, List<String> desc, boolean useItem, boolean useCommand, boolean useBroadcast, boolean useMessage, boolean usePermission, boolean useTitle, boolean useSound) {
        this.name = name;
        this.customTitle = customTitle;
        this.customSound = customSound;
        this.displayName = displayName;
        this.item = item;
        this.broadcastMessage = broadcastMessage;
        this.catchMessage = catchMessage;
        this.command = command;
        this.permission = permission;
        this.desc = desc;
        this.useItem = useItem;
        this.useCommand = useCommand;
        this.useBroadcast = useBroadcast;
        this.useMessage = useMessage;
        this.usePermission = usePermission;
        this.useTitle = useTitle;
        this.useSound = useSound;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        // String
        map.put("name", name);
        map.put("broadcastMessage", broadcastMessage);
        map.put("catchMessage", catchMessage);
        map.put("command", command);
        map.put("permission", permission);
        map.put("desc", desc);
        map.put("displayName", displayName);

        // Booleans
        map.put("useItem", useItem);
        map.put("useCommand", useCommand);
        map.put("useBroadcast", useBroadcast);
        map.put("useMessage", useMessage);
        map.put("usePermission", usePermission);
        map.put("useTitle", useTitle);
        map.put("useSound", useSound);

        // Objects
        map.put("customTitle", customTitle);
        map.put("customSound", customSound);
        map.put("item", item);
        return map;
    }

    public static FishingReward deserialize(Map<String, Object> map) {
        try {
            // Strings
            String name = (String) map.get("name");
            String broadcastMessage = (String) map.get("broadcastMessage");
            String catchMessage = (String) map.get("catchMessage");
            String command = (String) map.get("command");
            String permission = (String) map.get("permission");
            List<String> desc = (List<String>) map.get("desc");
            String displayName = (String) map.get("displayName");

            // Booleans
            boolean useItem = (boolean) map.get("useItem");
            boolean useCommand = (boolean) map.get("useCommand");
            boolean useBroadcast = (boolean) map.get("useBroadcast");
            boolean useMessage = (boolean) map.get("useMessage");
            boolean usePermission = (boolean) map.get("usePermission");
            boolean useSound = (boolean) map.get("useSound");
            boolean useTitle = (boolean) map.get("useTitle");

            // Objects
            CustomTitle customTitle = (CustomTitle) map.get("customTitle");
            CustomSound customSound = (CustomSound) map.get("customSound");
            List<ItemStack> item = (List<ItemStack>) map.get("item");

            return new FishingReward(name, customTitle, customSound, displayName, item, broadcastMessage,
                    catchMessage, command, permission, desc, useItem, useCommand, useBroadcast, useMessage,
                    usePermission, useTitle, useSound);
        } catch (Exception e) {
            System.out.println("Error on deserialize(ing) FishingReward class!");
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public CustomTitle getCustomTitle() {
        return customTitle;
    }

    public CustomSound getCustomSound() {
        return customSound;
    }

    public List<ItemStack> getItem() {
        return item;
    }

    public String getBroadcastMessage() {
        return broadcastMessage;
    }

    public String getCatchMessage() {
        return catchMessage;
    }

    public String getCommand() {
        return command;
    }

    public String getPermission() {
        return permission;
    }

    public boolean isUseItem() {
        return useItem;
    }

    public boolean isUseCommand() {
        return useCommand;
    }

    public boolean isUseBroadcast() {
        return useBroadcast;
    }

    public boolean isUseMessage() {
        return useMessage;
    }

    public boolean isUsePermission() {
        return usePermission;
    }

    public boolean isUseTitle() {
        return useTitle;
    }

    public boolean isUseSound() {
        return useSound;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomTitle(CustomTitle customTitle) {
        this.customTitle = customTitle;
    }

    public void setCustomSound(CustomSound customSound) {
        this.customSound = customSound;
    }

    public void setItem(List<ItemStack> item) {
        this.item = item;
    }

    public void setBroadcastMessage(String broadcastMessage) {
        this.broadcastMessage = broadcastMessage;
    }

    public void setCatchMessage(String catchMessage) {
        this.catchMessage = catchMessage;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public void setUseItem(boolean useItem) {
        this.useItem = useItem;
    }

    public void setUseCommand(boolean useCommand) {
        this.useCommand = useCommand;
    }

    public void setUseBroadcast(boolean useBroadcast) {
        this.useBroadcast = useBroadcast;
    }

    public void setUseMessage(boolean useMessage) {
        this.useMessage = useMessage;
    }

    public void setUsePermission(boolean usePermission) {
        this.usePermission = usePermission;
    }

    public void setUseTitle(boolean useTitle) {
        this.useTitle = useTitle;
    }

    public void setUseSound(boolean useSound) {
        this.useSound = useSound;
    }
}
