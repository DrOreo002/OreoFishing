package me.droreo002.oreofishing.objects;

import org.bukkit.inventory.ItemStack;

public class FishingReward {

    /*
    Useful data (Java)
     */
    private String name;
    private String broadcast;
    private String message;
    /*
    Useful data (Custom object)

     */
    /*
    Rewards data
     */
    private ItemStack item;
    private String command;
    /*
    Booleans
     */
    private boolean useItem;
    private boolean useCommand;
    private boolean useBroadcast;
    private boolean useMessage;
}
