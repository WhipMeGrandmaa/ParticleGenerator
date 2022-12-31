package me.whipmegrandma.particlegenerator.manager;

import me.whipmegrandma.particlegenerator.settings.Settings;
import me.whipmegrandma.particlegenerator.task.ParticleGeneratorTask;
import org.bukkit.scheduler.BukkitTask;
import org.mineacademy.fo.Common;

public class TaskManager {

	private static BukkitTask task;

	public static void cancel() {
		if (task != null && !task.isCancelled()) {
			task.cancel();
			task = null;
		}
	}

	public static void start() {
		put(Common.runTimer(Settings.getInstance().getTicks(), new ParticleGeneratorTask()));
	}

	public static void restart() {
		cancel();

		start();
	}

	private static void put(BukkitTask particleTask) {
		task = particleTask;
	}
}
