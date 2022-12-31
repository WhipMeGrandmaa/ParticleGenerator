package me.whipmegrandma.particlegenerator;

import me.whipmegrandma.particlegenerator.manager.TaskManager;
import me.whipmegrandma.particlegenerator.settings.Particle;
import me.whipmegrandma.particlegenerator.settings.Settings;
import org.mineacademy.fo.plugin.SimplePlugin;

public final class ParticleGenerator extends SimplePlugin {

	@Override
	protected void onPluginStart() {
	}

	@Override
	protected void onReloadablesStart() {
		Particle.loadParticles();
		Settings.load();

		if (Settings.getInstance().getToggleOn())
			TaskManager.start();
	}

	public static ParticleGenerator getInstance() {
		return (ParticleGenerator) SimplePlugin.getInstance();
	}

	@Override
	public int getMetricsPluginId() {
		return 17239;
	}
}
