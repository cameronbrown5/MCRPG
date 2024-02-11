package me.thecamzone.campfires;

import me.thecamzone.MCRPG;
import me.thecamzone.utilities.files.DataFile;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

public class HealthUtil {

    private static Double startingHealth = 10D;
    private static Double maxHealth = 40D;
    private static Double defaultRegenMax = 6D;

    public static void setPlayerMaxHealth(Player player, Double health) {
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);

        Bukkit.getScheduler().scheduleSyncDelayedTask(MCRPG.plugin, () -> {
            player.setHealth(health);
        }, 5);
    }

    public static void setPlayerMaxHealth(Player player, Double health, boolean save) {
        setPlayerMaxHealth(player, health);

        if(save) {
            DataFile.get().set("player-info." + player.getUniqueId() + ".maxHealth", health);
            DataFile.save();
        }
    }

    public static Double getPlayerMaxHealth(Player player) {
        return player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
    }

    public static Double getStartingHealth() {
        return startingHealth;
    }

    public static void setStartingHealth(Double startingHealth) {
        HealthUtil.startingHealth = startingHealth;
    }

    public static Double getMaxHealth() {
        return maxHealth;
    }

    public static void setMaxHealth(Double maxHealth) {
        HealthUtil.maxHealth = maxHealth;
    }

    public static Double getDefaultRegenMax() {
        return defaultRegenMax;
    }

    public static void setDefaultRegenMax(Double defaultRegenMax) {
        HealthUtil.defaultRegenMax = defaultRegenMax;
    }
}
