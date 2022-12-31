package me.whipmegrandma.particlegenerator.command.particles;

import me.whipmegrandma.particlegenerator.settings.Particle;
import me.whipmegrandma.particlegenerator.settings.PlayerData;
import org.bukkit.Location;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;
import org.mineacademy.fo.region.Region;

import java.util.List;

public final class ParticleGeneratorSetlocationSubCommand extends SimpleSubCommand {

	public ParticleGeneratorSetlocationSubCommand(SimpleCommandGroup parent) {
		super(parent, "setlocation");

		this.setMinArguments(1);
		this.setUsage("<name>");
		this.setPermission("particlegenerator.setlocation");
	}


	@Override
	protected void onCommand() {

		Particle particle = Particle.get(args[0]);
		PlayerData cache = PlayerData.from(getPlayer());
		Region region = cache.getRegion();

		Location primary = region.getPrimary();
		Location secondary = region.getSecondary();

		Boolean hasNeither = !region.hasPrimary() && !region.hasSecondary();

		checkBoolean(particle != null, args[0] + " is not a particle generator.");
		checkBoolean(!hasNeither, "You must set 1 point with '/pg regiontool' before setting the location.");
		checkBoolean(!region.isWhole(), "You must set only 1 point with '/pg regiontool' before setting the location.");

		particle.setLocation(primary != null ? primary : secondary);

		String primaryLocation = primary != null ? primary.getWorld().getName() + " " + primary.getX() + ", " + primary.getY() + ", " + primary.getZ() : null;
		String secondaryLocation = secondary != null ? secondary.getWorld().getName() + " " + secondary.getX() + ", " + secondary.getY() + ", " + secondary.getZ() + " " : null;

		tell("Changed the location of " + particle.getName() + " to " + (primary != null ? primaryLocation : secondaryLocation) + ".");
	}

	@Override
	protected List<String> tabComplete() {

		if (args.length == 1)
			return completeLastWord(Particle.getAllNames());

		return NO_COMPLETE;
	}
}
