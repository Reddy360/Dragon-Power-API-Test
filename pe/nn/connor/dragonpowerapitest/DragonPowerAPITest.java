package pe.nn.connor.dragonpowerapitest;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import pe.nn.connor.dragonpower.DragonPower;
import pe.nn.connor.dragonpower.DragonPowerAPI;
import pe.nn.connor.dragonpower.dragons.Dragon;

public class DragonPowerAPITest extends JavaPlugin{
	private DragonPowerAPI api;
	@Override
	public void onEnable() {
		//Getting the plugin class of DragonPower
		Plugin plugin = Bukkit.getPluginManager().getPlugin("DragonPower");
		//If the plugin is not null, so if it exists
		if(plugin != null){
			DragonPower dragonPower = (DragonPower) plugin;
			api = dragonPower.getAPI();
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.DARK_RED + "You need to be a player!");
			return true;
		}
		Player player = (Player) sender;
		if(args.length == 1){
			if(args[0].equalsIgnoreCase("fire")){
				api.setDragon(player, api.getFireDragon());
			}else if(args[0].equalsIgnoreCase("custom")){
				api.setDragon(player, new CustomDragon());
			}else if(args[0].equalsIgnoreCase("whoami")){
				player.sendMessage(api.getDragon(player).getClass().getName());
			}else if(args[0].equalsIgnoreCase("whoisall")){
				HashMap<UUID, Dragon> dragons = api.getDragons();
				for(UUID key : dragons.keySet()){
					player.sendMessage(key.toString() + ": " + dragons.get(key).getClass().getName());
				}
			}
		}
		return true;
	}
}
