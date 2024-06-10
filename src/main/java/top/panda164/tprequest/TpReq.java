package top.panda164.tprequest;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TpReq {
    boolean used;
    Player sender;
    boolean here;
    Player target;
    public TpReq(Player sender,boolean here,Player target)
    {
        this.sender=sender;
        this.here=here;
        this.target=target;
    }
    public static TpReq Query(Player sender,Player tar)
    {
        for(TpReq r : Tpa.reqs)
        {
            if((!r.used)&&r.target.getName().equals(tar.getName())&&r.sender.getName().equals(sender.getName()))return r;
        }
        return null;
    }
    public void tpAccept()
    {
        sender.spigot().sendMessage(new ComponentBuilder(target.getName())
                .color(ChatColor.GOLD)
                .bold(false)
                .append("接受了你的传送请求")
                .color(ChatColor.AQUA)
                .bold(false)
                .build());
        try {
            Location loc = target.getLocation();
            Location loc_here = sender.getLocation();

            if(!here)
            {
                sender.sendMessage(new ComponentBuilder("你将在")
                        .color(ChatColor.AQUA)
                        .bold(false)
                        .append("3")
                        .color(ChatColor.GOLD)
                        .bold(false)
                        .append("秒后传送")
                        .color(ChatColor.AQUA)
                        .bold(false)
                        .build());
                Thread.sleep(1000);
                sender.spigot().sendMessage(new ComponentBuilder("你将在")
                        .color(ChatColor.AQUA)
                        .bold(false)
                        .append("2")
                        .color(ChatColor.GOLD)
                        .bold(false)
                        .append("秒后传送")
                        .color(ChatColor.AQUA)
                        .bold(false)
                        .build());
                Thread.sleep(1000);
                sender.spigot().sendMessage(new ComponentBuilder("你将在")
                        .color(ChatColor.AQUA)
                        .bold(false)
                        .append("1")
                        .color(ChatColor.GOLD)
                        .bold(false)
                        .append("秒后传送")
                        .color(ChatColor.AQUA)
                        .bold(false)
                        .build());
                Thread.sleep(1000);
                sender.teleport(loc);
            }
            else
            {
                target.sendMessage(new ComponentBuilder("你将在")
                        .color(ChatColor.AQUA)
                        .bold(false)
                        .append("3")
                        .color(ChatColor.GOLD)
                        .bold(false)
                        .append("秒后传送")
                        .color(ChatColor.AQUA)
                        .bold(false)
                        .build());
                Thread.sleep(1000);
                target.spigot().sendMessage(new ComponentBuilder("你将在")
                        .color(ChatColor.AQUA)
                        .bold(false)
                        .append("2")
                        .color(ChatColor.GOLD)
                        .bold(false)
                        .append("秒后传送")
                        .color(ChatColor.AQUA)
                        .bold(false)
                        .build());
                Thread.sleep(1000);
                target.spigot().sendMessage(new ComponentBuilder("你将在")
                        .color(ChatColor.AQUA)
                        .bold(false)
                        .append("1")
                        .color(ChatColor.GOLD)
                        .bold(false)
                        .append("秒后传送")
                        .color(ChatColor.AQUA)
                        .bold(false)
                        .build());
                Thread.sleep(1000);
                target.teleport(loc_here);
            }

        }catch (InterruptedException e)
        {

        }
        this.used=true;
    }
    public void tpDeny()
    {
        target.spigot().sendMessage(new ComponentBuilder(sender.getName())
                .color(ChatColor.GOLD)
                .bold(false)
                .append("拒绝了你的传送请求")
                .color(ChatColor.AQUA)
                .bold(false)
                .build());
        this.used=true;
    }
    public void sendMsg()
    {
        String str;
        if(!here)
        {
            str="请求传送到你的位置";
        }
        else str="请求你传送到他的位置";
        ClickEvent clickYes = new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/tpaccept "+sender.getName());
        ClickEvent clickNo = new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/tpdeny "+sender.getName());
        TextComponent yes = new TextComponent("[✔]");
        yes.setColor(ChatColor.GREEN);
        yes.setClickEvent(clickYes);
        yes.setBold(false);
        TextComponent no = new TextComponent("[✘]");
        no.setColor(ChatColor.RED);
        no.setClickEvent(clickNo);
        no.setBold(false);
        target.spigot().sendMessage(new ComponentBuilder(sender.getName())
                .color(ChatColor.GOLD)
                .bold(false)
                .append(str)
                .color(ChatColor.AQUA)
                .bold(false)
                .build(),yes,no);
    }
    public void proc()
    {
        sendMsg();
    }
}
