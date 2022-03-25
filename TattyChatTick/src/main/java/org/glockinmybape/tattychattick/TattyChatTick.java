package org.glockinmybape.tattychattick;

import jdk.internal.org.jline.utils.Log;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.glockinmybape.tattychattick.listeners.EventListener;

import java.util.logging.Logger;

public class TattyChatTick extends JavaPlugin {
    public static TattyChatTick inst;


    public void onEnable() {
        this.saveDefaultConfig();
        inst = this;
        this.printLogo();
        this.getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    private void printLogo() {
        inst = this;
        Log.info("§b");
        Log.info("§b .----------------------------------------------------------. ");
        Log.info("§b| .-------------------------------------------------------. |");
        Log.info("§b| |             \t\t\t\t\t\t");
        Log.info("§b| |            §7Плагин: §bTattyMYSQL§8| §7Версия: §b1.0                ");
        Log.info("§b| |        §7Создан для §bTattyWorld §8- §7Разработал: §bglockinmybape\t");
        Log.info("§b| |                    §bvk.com/TattyWorld");
        Log.info("§b| |             \t\t\t\t\t\t");
        Log.info("§b| '-------------------------------------------------------'§b|");
        Log.info("§b'-----------------------------------------------------------'");
        Log.info("§b");
    }
}
