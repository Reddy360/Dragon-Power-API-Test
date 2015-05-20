package pe.nn.connor.dragonpowerapitest;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import pe.nn.connor.dragonpower.dragons.Dragon;

public class CustomDragon implements Dragon {

	@Override
	public void onClick(Player arg0, PlayerInteractEvent arg1) {
		arg0.sendMessage("onClick");
	}

	@Override
	public void onDamage(Player arg0, EntityDamageEvent arg1) {
		arg0.sendMessage("onDamage");
	}

	@Override
	public void onEntityAttack(Player arg0, Entity arg1,
			EntityDamageByEntityEvent arg2) {
		arg0.sendMessage("onEntityAttack");
	}

	@Override
	public void onJump(Player arg0, PlayerMoveEvent arg1) {
		arg0.sendMessage("onJump");
	}

	@Override
	public void onMove(Player arg0, PlayerMoveEvent arg1) {
		arg0.sendMessage("onMove");
	}

}
