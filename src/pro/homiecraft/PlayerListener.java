package pro.homiecraft;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;

import java.util.List;

/**
 * User: Stian
 * Date: 27.04.13
 * Time: 04:34
 */
public class PlayerListener implements Listener {

    @EventHandler (priority = EventPriority.LOW)
    public void onItemDrop(PlayerDropItemEvent e){
        StopDrops.pluginST.reloadConfig();
        List<?> listWorlds = StopDrops.pluginST.getConfig().getList("StopDrops.DisableItemDropFor");

        Player player = e.getPlayer();
        String pWorld = player.getWorld().getName();

        if (listWorlds.contains(pWorld)){
            Item pInv = e.getItemDrop();
            pInv.remove();
        }
    }

}
