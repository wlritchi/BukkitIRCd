package com.Jdbye.BukkitIRCd.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Jdbye.BukkitIRCd.BukkitIRCdPlugin;

public class IRCReloadCommand implements CommandExecutor{

	private BukkitIRCdPlugin thePlugin;

	public IRCReloadCommand(BukkitIRCdPlugin plugin) {
		this.thePlugin = plugin;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (sender instanceof Player){
			Player player = (Player) sender;
			if (player.hasPermission("bukkitircd.reload")) {
				thePlugin.pluginInit(true);
				BukkitIRCdPlugin.log.info("[BukkitIRCd] Configuration file reloaded.");
				player.sendMessage(ChatColor.RED + "Configuration file reloaded.");
			}
			else {
				player.sendMessage(ChatColor.RED + "You don't have access to that command.");
			}
			return true;
		}else{
			thePlugin.pluginInit(true);
			BukkitIRCdPlugin.log.info("[BukkitIRCd] Configuration file reloaded.");
			sender.sendMessage(ChatColor.RED + "Configuration file reloaded.");
			return true;
		}
	}

}