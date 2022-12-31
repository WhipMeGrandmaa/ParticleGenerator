package me.whipmegrandma.particlegenerator.command.particles;

import me.whipmegrandma.particlegenerator.tool.ParticleGeneratorRegionTool;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.List;

public final class ParticleGeneratorRegiontoolSubCommand extends SimpleSubCommand {

	public ParticleGeneratorRegiontoolSubCommand(SimpleCommandGroup parent) {
		super(parent, "regiontool");

		this.setPermission("particlegenerator.regiontool");
	}


	@Override
	protected void onCommand() {
		ParticleGeneratorRegionTool.getInstance().give(getPlayer());

		tell("You've been given a region tool!");
	}

	@Override
	protected List<String> tabComplete() {
		return NO_COMPLETE;
	}
}
