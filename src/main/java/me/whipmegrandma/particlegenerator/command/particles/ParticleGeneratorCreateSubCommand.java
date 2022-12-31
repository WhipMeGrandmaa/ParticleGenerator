package me.whipmegrandma.particlegenerator.command.particles;

import me.whipmegrandma.particlegenerator.settings.Particle;
import me.whipmegrandma.particlegenerator.settings.PlayerData;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;
import org.mineacademy.fo.region.Region;

import java.util.List;

public final class ParticleGeneratorCreateSubCommand extends SimpleSubCommand {

	public ParticleGeneratorCreateSubCommand(SimpleCommandGroup parent) {
		super(parent, "create");

		this.setMinArguments(1);
		this.setUsage("<name> [particle] [size] [strength]");
		this.setPermission("particlegenerator.create");
	}


	@Override
	protected void onCommand() {
		checkConsole();

		Player player = getPlayer();
		PlayerData cache = PlayerData.from(player);
		Region region = cache.getRegion();

		String name = args[0];

		checkBoolean(!Particle.isLoaded(name), "Particle generator " + name + " already exists!");

		Particle.create(name, null, null, null, null);

		tell("Successfully created particle generator " + name + ". Check out '/pg ?' to customize it.");

	}

	@Override
	protected List<String> tabComplete() {
		return NO_COMPLETE;
	}
}
