package me.whipmegrandma.particlegenerator.command.particles;

import me.whipmegrandma.particlegenerator.manager.TaskManager;
import me.whipmegrandma.particlegenerator.settings.Settings;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.List;

public final class ParticleGeneratorToggleoffSubCommand extends SimpleSubCommand {

	public ParticleGeneratorToggleoffSubCommand(SimpleCommandGroup parent) {
		super(parent, "toggleoff");

		this.setPermission("particlegenerator.toggleoff");
	}


	@Override
	protected void onCommand() {
		Settings.getInstance().toggleOff();
		TaskManager.cancel();

		tell("The particle runnable has been cancelled.");
	}

	@Override
	protected List<String> tabComplete() {
		return NO_COMPLETE;
	}
}
