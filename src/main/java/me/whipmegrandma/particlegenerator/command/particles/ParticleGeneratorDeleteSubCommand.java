package me.whipmegrandma.particlegenerator.command.particles;

import me.whipmegrandma.particlegenerator.settings.Particle;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.List;

public final class ParticleGeneratorDeleteSubCommand extends SimpleSubCommand {

	public ParticleGeneratorDeleteSubCommand(SimpleCommandGroup parent) {
		super(parent, "delete");

		this.setMinArguments(1);
		this.setUsage("<name>");
		this.setPermission("particlegenerator.delete");
	}


	@Override
	protected void onCommand() {

		String name = args[0];

		if (Particle.isLoaded(name)) {
			Particle.remove(name);

			tell("Successfully removed particle generator " + name + ".");
		} else
			tell("Particle generator " + name + " does not exist.");

	}

	@Override
	protected List<String> tabComplete() {
		return completeLastWord(Particle.getAllNames());
	}
}
