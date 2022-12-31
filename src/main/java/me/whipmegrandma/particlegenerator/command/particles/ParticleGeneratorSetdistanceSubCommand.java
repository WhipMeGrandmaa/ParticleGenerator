package me.whipmegrandma.particlegenerator.command.particles;

import me.whipmegrandma.particlegenerator.settings.Settings;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.List;

public final class ParticleGeneratorSetdistanceSubCommand extends SimpleSubCommand {

	public ParticleGeneratorSetdistanceSubCommand(SimpleCommandGroup parent) {
		super(parent, "setdistance");

		this.setMinArguments(1);
		this.setUsage("<distance>");
		this.setPermission("particlegenerator.setdistance");
	}


	@Override
	protected void onCommand() {

		Integer distance = findNumber(0, "Distance must be a positive full number.");

		checkBoolean(distance > 0, "Distance must be a positive full number");

		Settings.getInstance().setDistance(distance);

		tell("Changed the distance between players and particles for the generators to work to " + distance + ".");
	}

	@Override
	protected List<String> tabComplete() {
		return NO_COMPLETE;
	}
}
