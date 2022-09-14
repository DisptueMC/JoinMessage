package cn.disputemc.civicxfb.listener;

import cn.disputemc.civicxfb.JoinMessage;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;

public class joinmessage implements Listener {
    private final JoinMessage plugin;
    public joinmessage(JoinMessage plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onplayerjoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("MessageToggle",true)) {
            for (Player player1 : Server.getInstance().getOnlinePlayers().values()){
                player1.sendTip(plugin.getConfig().getString("JoinTipMessage").replace("{player_name}",event.getPlayer().getName()));
            }
            event.setJoinMessage(plugin.getConfig().getString("JoinMessage").replace("{player_name}",event.getPlayer().getName()));
        } else if (plugin.getConfig().getBoolean("MessageToggle",false)) {
            event.setCancelled();
        }
        if (plugin.getConfig().getBoolean("MessageInfoToggle",true)){
            event.getPlayer().sendMessage(plugin.getConfig().getString("MessageInfo").replace("{player_name}",event.getPlayer().getName()));
        } else if (plugin.getConfig().getBoolean("MessageInfoToggle",false)) {
            event.setCancelled();
        }
        if (plugin.getConfig().getBoolean("TitleToggle",true)){
            player.sendTitle(plugin.getConfig().getString("TitleMessage").replace("{player_name}",event.getPlayer().getName()),plugin.getConfig().getString("SubTitleMessage").replace("{player_name}",event.getPlayer().getName()));
        } else if (plugin.getConfig().getBoolean("TitleToggle",false)){
            event.setCancelled();
        }
    }
}
