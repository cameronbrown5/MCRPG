package me.thecamzone.Utilities;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import me.thecamzone.Engine.Main;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Objects;

public class NBTAPI {

    public static @Nullable String getNBT(@Nonnull ItemStack item, String key) {
        Objects.requireNonNull(item,"item must not be null");
        if(!item.hasItemMeta()) return null;
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(Main.plugin, key);
        if(pdc.has(namespacedKey, PersistentDataType.STRING)) {
            return pdc.get(namespacedKey, PersistentDataType.STRING);
        }
        return null;
    }

    public static @Nullable String getNBT(@Nonnull Entity entity, String key) {
        Objects.requireNonNull(entity,"entity must not be null");
        PersistentDataContainer pdc = entity.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(Main.plugin, key);
        if(pdc.has(namespacedKey, PersistentDataType.STRING)) {
            return pdc.get(namespacedKey, PersistentDataType.STRING);
        }
        return null;
    }

    public static void addNBT(@Nonnull ItemStack item, String key, String value) {
        Objects.requireNonNull(item,"item must not be null");
        ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(Main.plugin, key);
        pdc.set(namespacedKey, PersistentDataType.STRING, value);
        item.setItemMeta(meta);
    }

    public static void addNBT(@Nonnull Entity entity, String key, String value) {
        Objects.requireNonNull(entity,"entity must not be null");
        PersistentDataContainer pdc = entity.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(Main.plugin, key);
        pdc.set(namespacedKey, PersistentDataType.STRING, value);
    }

    public static boolean hasNBT(@Nonnull ItemStack item, String key) {
        Objects.requireNonNull(item,"item must not be null");
        if(!item.hasItemMeta()) return false;
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        return pdc.has(new NamespacedKey(Main.plugin, key),PersistentDataType.STRING);
    }

    public static boolean hasNBT(@Nonnull Entity entity, String key) {
        Objects.requireNonNull(entity,"entity must not be null");
        PersistentDataContainer pdc = entity.getPersistentDataContainer();
        return pdc.has(new NamespacedKey(Main.plugin ,key),PersistentDataType.STRING);
    }

    public static void removeNBT(@Nonnull ItemStack item, String key) {
        Objects.requireNonNull(item,"item must not be null");
        if(!item.hasItemMeta()) return;
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        pdc.remove(new NamespacedKey(Main.plugin, key));
        item.setItemMeta(meta);
    }

    public static void removeNBT(@Nonnull Entity entity, String key) {
        Objects.requireNonNull(entity,"entity must not be null");
        PersistentDataContainer pdc = entity.getPersistentDataContainer();
        pdc.remove(new NamespacedKey(Main.plugin, key));
    }

    public static HashMap<String,String> getAllValues(@Nonnull ItemStack item) {
        Objects.requireNonNull(item,"item must not be null");
        HashMap<String,String> map = new HashMap<>();
        if(!item.hasItemMeta()) return map;
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        for(NamespacedKey key : pdc.getKeys()) {
            map.put(key.toString(),pdc.get(key,PersistentDataType.STRING));
        }
        return map;
    }

}
