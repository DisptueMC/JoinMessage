package cn.disputemc.civicxfb;

import cn.disputemc.civicxfb.listener.joinmessage;
import cn.disputemc.civicxfb.listener.quickmessage;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class JoinMessage extends PluginBase {
    /**
     * onLoad()
     * 表示插件开始加载时状态
     */
    @Override
    public void onLoad() {
        this.getLogger().info(TextFormat.WHITE + "插件正在加载中...请稍等");
    }
   /**
    * onEnable()
    * 表示插件加载完毕时状态
    */
    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.WHITE + "插件加载完毕");
        this.getServer().getPluginManager().registerEvents(new joinmessage(this),this);
        this.getServer().getPluginManager().registerEvents(new quickmessage(this),this);
        this.saveDefaultConfig();
    }
    /**
     * onDisable()
     * 表示插件关闭状态
     */
    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.YELLOW+ "插件已关闭！");
    }
}
