package me.whipmegrandma.particlegenerator.command.particles;

import me.whipmegrandma.particlegenerator.settings.Particle;
import me.whipmegrandma.particlegenerator.util.Parser;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.List;

public final class ParticleGeneratorSetstrengthSubCommand extends SimpleSubCommand {

	public ParticleGeneratorSetstrengthSubCommand(SimpleCommandGroup parent) {
		super(parent, "setstrength");

		this.setMinArguments(2);
		this.setUsage("<name> <strength>");
		this.setPermission("particlegenerator.setstrength");
	}


	@Override
	protected void onCommand() {

		Particle particle = Particle.get(args[0]);
		Float strength = Parser.parseFloat(args[1]);

		checkBoolean(particle.getLocation() == null, "You can only set strength for particle generators with regions, not locations.");
		checkBoolean(particle != null, args[0] + " is not a particle generator.");
		checkBoolean(strength != null && !(strength > 1) && !(strength < 0), "The strength must be between 0 and 1!");

		particle.setStrength(strength);

		tell("Changed the strength of " + particle.getName() + " to " + strength + ".");
	}

	@Override
	protected List<String> tabComplete() {
		if (args.length == 1)
			return completeLastWord(Particle.getAllNames());

		return NO_COMPLETE;
	}
}
