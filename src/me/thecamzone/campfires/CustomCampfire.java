package me.thecamzone.campfires;

import me.thecamzone.MCRPG;
import org.bukkit.Location;
import org.bukkit.block.Campfire;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Collection;
import java.util.Random;

public class CustomCampfire {

    private final CustomCampfire instance;
    private final org.bukkit.block.data.type.Campfire campfireData;
    private final BukkitTask timerTask;
    private final BukkitTask radiusTask;

    private int timeLeft = 20;

    public CustomCampfire(final Campfire campfire) {
        instance = this;

        campfireData = (org.bukkit.block.data.type.Campfire) campfire.getBlockData();

        new BukkitRunnable() {
            @Override
            public void run() {
                campfireData.setLit(true);
                campfire.getBlock().setBlockData(campfireData);
            }
        }.runTaskLater(MCRPG.plugin, 1L);

        Random random = new Random();
        int randomInt = random.nextInt(20);
        randomInt = randomInt - 10;
        timeLeft += randomInt;

        Location loc = campfire.getLocation();

        timerTask = new BukkitRunnable() {
            @Override
            public void run() {
                timeLeft--;

                if(timeLeft <= 0) {
                    campfireData.setLit(false);
                    campfire.getBlock().setBlockData(campfireData);

                    CampfireHandler.remove(instance);
                    radiusTask.cancel();
                    this.cancel();
                }
            }
        }.runTaskTimer(MCRPG.plugin, 0L, 20L);

        radiusTask = new BukkitRunnable() {
            @Override
            public void run() {
                Collection<Entity> entities = loc.getWorld().getNearbyEntities(loc, 5, 3 ,5);

                for(Entity e : entities) {
                    LivingEntity entity;
                    if (!(e instanceof LivingEntity)) {
                        continue;
                    }

                    entity = (LivingEntity) e;

                    entity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 50, 0, false, false, false));
                }
            }
        }.runTaskTimer(MCRPG.plugin, 0L, 40L);
    }

    public BukkitTask getTimerTask() {
        return timerTask;
    }

    public BukkitTask getRadiusTask() {
        return radiusTask;
    }
}
