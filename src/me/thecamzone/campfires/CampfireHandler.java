package me.thecamzone.campfires;

import org.bukkit.block.Campfire;

import java.util.HashMap;

public class CampfireHandler {

    private static HashMap<Campfire, CustomCampfire> campfires = new HashMap<>();

    public static void handleIgnition(Campfire campfire) {
        campfires.put(campfire, new CustomCampfire(campfire));
    }

    public static void remove(CustomCampfire customCampfire) {
        if(!customCampfire.getTimerTask().isCancelled()) {
            customCampfire.getTimerTask().cancel();
        }

        campfires.remove(customCampfire);
    }

}
