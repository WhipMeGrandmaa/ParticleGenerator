package me.whipmegrandma.particlegenerator.command.particles;

import me.whipmegrandma.particlegenerator.settings.Particle;
import me.whipmegrandma.particlegenerator.settings.PlayerData;
import org.bukkit.Location;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;
import org.mineacademy.fo.region.Region;

import java.util.List;

public final class ParticleGeneratorSetregionSubCommand extends SimpleSubCommand {

	public ParticleGeneratorSetregionSubCommand(SimpleCommandGroup parent) {
		super(parent, "setregion");

		this.setMinArguments(1);
		this.setUsage("<name>");
		this.setPermission("particlegenerator.setregion");
	}


	@Override
	protected void onCommand() {

		Particle particle = Particle.get(args[0]);
		PlayerData cache = PlayerData.from(getPlayer());
		Region region = cache.getRegion();

		checkBoolean(particle != null, args[0] + " is not a particle generator.");
		checkBoolean(region.isWhole(), "You must set 2 points with '/pg regiontool' before setting the region.");

		particle.setRegion(region);

		Location primary = region.getPrimary();
		Location secondary = region.getSecondary();
		String primaryLocation = primary != null ? primary.getWorld().getName() + " " + primary.getX() + ", " + primary.getY() + ", " + primary.getZ() : null;
		String secondaryLocation = secondary != null ? secondary.getWorld().getName() + " " + secondary.getX() + ", " + secondary.getY() + ", " + secondary.getZ() : null;

		tell("Changed the region of " + particle.getName() + " to " + primaryLocation + " " + secondaryLocation + ".");
	}

	@Override
	protected List<String> tabComplete() {

		if (args.length == 1)
			return completeLastWord(Particle.getAllNames());

		return NO_COMPLETE;
	}
}
