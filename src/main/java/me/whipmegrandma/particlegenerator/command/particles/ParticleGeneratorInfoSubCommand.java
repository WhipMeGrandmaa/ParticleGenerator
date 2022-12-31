package me.whipmegrandma.particlegenerator.command.particles;

import me.whipmegrandma.particlegenerator.settings.Settings;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.List;

public final class ParticleGeneratorInfoSubCommand extends SimpleSubCommand {

	public ParticleGeneratorInfoSubCommand(SimpleCommandGroup parent) {
		super(parent, "info");

		this.setPermission("particlegenerator.info");
	}


	@Override
	protected void onCommand() {
		tell("The ticks are set to " + Settings.getInstance().getTicks() + " and the distance is set to " + Settings.getInstance().getDistance() + " blocks.");
	}

	@Override
	protected List<String> tabComplete() {
		return NO_COMPLETE;
	}
}
