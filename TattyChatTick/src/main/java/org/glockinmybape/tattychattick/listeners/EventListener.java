package org.glockinmybape.tattychattick.listeners;

import java.util.Iterator;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.glockinmybape.tattychattick.TattyChatTick;

public class EventListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        int sec = p.getStatistic(Statistic.PLAY_ONE_TICK) / 20;
        if (sec < TattyChatTick.inst.getConfig().getInt("sec-need-time") && !p.hasPermission("tattychattick.bypass")) {
            e.setCancelled(true);
            Iterator var5 = TattyChatTick.inst.getConfig().getStringList("time-actions").iterator();

            while(var5.hasNext()) {
                String s = (String)var5.next();
                String sn;
                if (s.startsWith("[MESSAGE]")) {
                    sn = s.replace("[MESSAGE] ", "").replace("[MESSAGE]", "");
                    p.sendMessage(sn.replace("&", "§"));
                } else {
                    String[] split;
                    if (s.startsWith("[TITLE]")) {
                        sn = s.replace("[TITLE] ", "").replace("[TITLE]", "");
                        split = sn.split("%nl");
                        p.sendTitle(split[0].replace("&", "§"), split[1].replace("&", "§"));
                    } else if (s.startsWith("[SOUND]")) {
                        sn = s.replace("[SOUND] ", "").replace("[SOUND]", "");
                        split = sn.split(";");
                        Sound sound = Sound.valueOf(split[0]);
                        int volume = Integer.parseInt(split[1]);
                        int pitch = Integer.parseInt(split[2]);
                        p.playSound(p.getLocation(), sound, (float)volume, (float)pitch);
                    }
                }
            }
        }

    }
}
