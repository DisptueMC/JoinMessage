package cn.disputemc.civicxfb.listener;

import cn.disputemc.civicxfb.JoinMessage;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;


public class quickmessage implements Listener {
    private final JoinMessage plugin;

    public quickmessage(JoinMessage plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onquickmessage(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("MessageToggle",true)){
            event.setQuitMessage(plugin.getConfig().getString("QuickMessage").replace("{player_name}",event.getPlayer().getName()));
        } else if (plugin.getConfig().getBoolean("MessageToggle",false)) {
            event.setCancelled();
        }
    }
}
