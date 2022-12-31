package me.whipmegrandma.particlegenerator.task;

import me.whipmegrandma.particlegenerator.settings.Particle;
import me.whipmegrandma.particlegenerator.settings.PlayerData;
import me.whipmegrandma.particlegenerator.settings.Settings;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.mineacademy.fo.RandomUtil;
import org.mineacademy.fo.remain.Remain;

import java.util.Set;

public class ParticleGeneratorTask extends BukkitRunnable {

	@Override
	public void run() {

		for (Player player : Remain.getOnlinePlayers())
			if (PlayerData.from(player).canSee())
				for (Particle particle : Particle.getAllItems()) {
					
					if (particle.getLocation() != null)
						this.atLocation(particle, player);

					if (particle.getRegion() != null)
						this.atRegion(particle, player);
				}
	}

	private void atLocation(Particle particle, Player player) {
		if (!player.getWorld().equals(particle.getLocation().getWorld()) || particle.getType() == null)
			return;

		Location particleLocation = particle.getLocation();
		Location playerLocation = player.getLocation();

		if (playerLocation.distance(particleLocation) < Settings.getInstance().getDistance())
			particle.getType().spawn(player, particleLocation);
	}

	private void atRegion(Particle particle, Player player) {
		if (!player.getWorld().equals(particle.getRegion().getWorld()) || particle.getType() == null || particle.getStrength() == null)
			return;

		Set<Location> boundingBlocks = particle.getRegion().getBoundingBox();

		Float strength = particle.getStrength();

		for (Location individualLocation : boundingBlocks)
			if (RandomUtil.chanceD(strength) && player.getLocation().distance(individualLocation) < Settings.getInstance().getDistance())
				particle.getType().spawn(player, individualLocation);

	}
}
