package me.thecamzone.engine;

import me.thecamzone.events.OnInteract;
import me.thecamzone.events.OnPlayerDeath;
import me.thecamzone.events.OnRegainHealth;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
  private OnRegainHealth onRegainHealth = new OnRegainHealth();
  
  private OnPlayerDeath onPlayerDeath = new OnPlayerDeath();
  
  private OnInteract onInteract = new OnInteract();
  
  public void onEnable() {
    getServer().getPluginManager().registerEvents((Listener)this.onRegainHealth, (Plugin)this);
    getServer().getPluginManager().registerEvents((Listener)this.onPlayerDeath, (Plugin)this);
    getServer().getPluginManager().registerEvents((Listener)this.onInteract, (Plugin)this);
  }
}
