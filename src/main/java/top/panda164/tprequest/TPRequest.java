package top.panda164.tprequest;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentStyle;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public final class TPRequest extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        CommandExecutor commandExec = new Tpa();
        Bukkit.getPluginCommand("tpa").setExecutor(commandExec);
        Bukkit.getPluginCommand("tphere").setExecutor(commandExec);
        Bukkit.getPluginCommand("tpaccept").setExecutor(commandExec);
        Bukkit.getPluginCommand("tpdeny").setExecutor(commandExec);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
