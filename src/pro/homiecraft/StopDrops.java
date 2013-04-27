package pro.homiecraft;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

/**
 * User: Stian
 * Date: 27.04.13
 * Time: 04:33
 */
public class StopDrops extends JavaPlugin {

    public static StopDrops pluginST;

    public void onDisable(){

    }

    public void onEnable(){

        pluginST = this;

        PluginManager pm = Bukkit.getPluginManager();
            pm.registerEvents(new PlayerListener(), this);

        initMetrics();

        if(!getDataFolder().exists()){
            getDataFolder().mkdir();
        }

        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.reloadConfig();

    }

    public void initMetrics(){
        try {
            Metrics metrics = new Metrics(this);

            metrics.start();
        } catch (IOException e) {
            // Failed to submit the stats :-(
        }
    }
}
