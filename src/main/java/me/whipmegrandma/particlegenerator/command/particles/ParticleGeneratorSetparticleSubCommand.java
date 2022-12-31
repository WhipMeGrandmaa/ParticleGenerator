package me.whipmegrandma.particlegenerator.command.particles;

import me.whipmegrandma.particlegenerator.settings.Particle;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;
import org.mineacademy.fo.remain.CompParticle;

import java.util.List;

public final class ParticleGeneratorSetparticleSubCommand extends SimpleSubCommand {

	public ParticleGeneratorSetparticleSubCommand(SimpleCommandGroup parent) {
		super(parent, "setparticle");

		this.setMinArguments(2);
		this.setUsage("<name> <particle>");
		this.setPermission("particlegenerator.setparticle");
	}


	@Override
	protected void onCommand() {

		Particle particle = Particle.get(args[0]);
		CompParticle name = this.findEnum(CompParticle.class, args[1].toUpperCase(), args[1] + " is not a particle!");

		checkBoolean(particle != null, args[0] + " is not a particle generator.");

		particle.setType(name);

		tell("Changed the particle of " + particle.getName() + " to " + name.name().toLowerCase() + ".");
	}

	@Override
	protected List<String> tabComplete() {

		if (args.length == 1)
			return completeLastWord(Particle.getAllNames());

		if (args.length == 2)
			return completeLastWord(CompParticle.values());

		return NO_COMPLETE;
	}
}
