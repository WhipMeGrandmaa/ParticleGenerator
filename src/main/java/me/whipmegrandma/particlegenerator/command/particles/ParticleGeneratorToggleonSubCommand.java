package me.whipmegrandma.particlegenerator.command.particles;

import me.whipmegrandma.particlegenerator.manager.TaskManager;
import me.whipmegrandma.particlegenerator.settings.Settings;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.List;

public final class ParticleGeneratorToggleonSubCommand extends SimpleSubCommand {

	public ParticleGeneratorToggleonSubCommand(SimpleCommandGroup parent) {
		super(parent, "toggleon");

		this.setPermission("particlegenerator.toggleon");
	}


	@Override
	protected void onCommand() {
		Settings.getInstance().toggleOn();
		TaskManager.start();

		tell("The particle runnable has been started.");
	}

	@Override
	protected List<String> tabComplete() {
		return NO_COMPLETE;
	}
}
