package me.thecamzone.portals.blueprints;

import me.thecamzone.MCRPG;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.List;

public class Executor {
    private final int warmup;
    private final World warpTo;
    private final List<String> commands;
    private final List<World> worlds;
    private final List<String> messages;

    private int timeLeft = 0;
    private int taskID = -1;

    public Executor(int warmup, World warpTo, List<String> commands, List<World> worlds, List<String> messages) {
        this.warmup = warmup;
        this.warpTo = warpTo;
        this.commands = commands;
        this.worlds = worlds;
        this.messages = messages;

        timeLeft = warmup;
    }

    public void execute() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(MCRPG.plugin, () -> {
            if(timeLeft <= 0) {
                run();
                cancel();
                return;
            }

            Bukkit.getConsoleSender().sendMessage(timeLeft + "");

            timeLeft--;
        }, 0, 20);
    }

    public void cancel() {
        Bukkit.getScheduler().cancelTask(taskID);
    }

    private void run() {

    }

    public int getWarmup() {
        return warmup;
    }

    public World getWarpTo() {
        return warpTo;
    }

    public List<String> getCommands() {
        return commands;
    }

    public List<World> getWorlds() {
        return worlds;
    }

    public List<String> getMessages() {
        return messages;
    }
}
