package me.whipmegrandma.particlegenerator.command;

import me.whipmegrandma.particlegenerator.menu.ParticleSettings;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.command.SimpleCommand;

@AutoRegister
public final class ParticleSettingsCommand extends SimpleCommand {

	public ParticleSettingsCommand() {
		super("particlesettings");

		this.setPermission("particlegenerator.particlesettings");
	}

	@Override
	protected void onCommand() {
		checkConsole();

		new ParticleSettings(getPlayer()).displayTo(getPlayer());
	}
}
