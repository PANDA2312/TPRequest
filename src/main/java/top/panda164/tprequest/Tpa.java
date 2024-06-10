package top.panda164.tprequest;

import it.unimi.dsi.fastutil.Pair;
import jdk.internal.joptsimple.util.KeyValuePair;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import java.util.*;
import com.google.common.collect.ImmutableMap;
import org.bukkit.entity.Player.Spigot;
public class Tpa implements CommandExecutor {
    public static List<TpReq> reqs= new ArrayList<>();
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(label.equals("tpa"))
        {
            if(commandSender instanceof Player)
            {
                TpReq req= new TpReq((Player) commandSender,false,Bukkit.getPlayer(args[0]));
                reqs.add(req);
                req.proc();
            }

        }
        if(label.equals("tphere"))
        {
            if(commandSender instanceof Player)
            {
                TpReq req= new TpReq((Player) commandSender,true,Bukkit.getPlayer(args[0]));
                reqs.add(req);
                req.proc();
            }
        }
        if(label.equals("tpaccept"))
        {
            if(commandSender instanceof Player)
            {
                Player p =(Player)commandSender;
                TpReq r = TpReq.Query(Bukkit.getPlayer(args[0]),p);
                if(r==null||r.used)
                {
                    p.spigot().sendMessage(new ComponentBuilder("你没有来自该玩家的传送请求").color(ChatColor.RED).bold(false).build());
                    return false;
                }
                r.tpAccept();
            }
        }
        if(label.equals("tpdeny"))
        {
            if(commandSender instanceof Player)
            {
                Player p =(Player)commandSender;
                TpReq r = TpReq.Query(Bukkit.getPlayer(args[0]),p);
                if(r==null||r.used)
                {
                    p.spigot().sendMessage(new ComponentBuilder("你没有来自该玩家的传送请求").color(ChatColor.RED).bold(false).build());
                    return false;
                }
                r.tpDeny();
            }
        }
        return false;
    }
}
