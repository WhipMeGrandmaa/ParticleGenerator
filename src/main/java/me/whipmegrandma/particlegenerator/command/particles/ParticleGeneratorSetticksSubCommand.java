package me.whipmegrandma.particlegenerator.command.particles;

import me.whipmegrandma.particlegenerator.manager.TaskManager;
import me.whipmegrandma.particlegenerator.settings.Settings;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.List;

public final class ParticleGeneratorSetticksSubCommand extends SimpleSubCommand {

	public ParticleGeneratorSetticksSubCommand(SimpleCommandGroup parent) {
		super(parent, "setticks");

		this.setMinArguments(1);
		this.setUsage("<ticks>");
		this.setPermission("particlegenerator.setticks");
	}


	@Override
	protected void onCommand() {

		Integer ticks = findNumber(0, "Ticks must be a positive full number.");

		checkBoolean(ticks > 0, "Ticks must be a positive full number");

		Settings.getInstance().setTicks(ticks);
		TaskManager.restart();

		tell("Changed the ticks of the task to " + ticks + ".");
	}

	@Override
	protected List<String> tabComplete() {
		return NO_COMPLETE;
	}
}
