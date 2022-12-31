package me.whipmegrandma.particlegenerator.command.particles;

import org.mineacademy.fo.Common;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.command.ReloadCommand;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.model.SimpleComponent;

import java.util.Arrays;
import java.util.List;

@AutoRegister
public final class ParticleGeneratorCommandGroup extends SimpleCommandGroup {

	public ParticleGeneratorCommandGroup() {
		super("particlegenerator|pg");
	}

	@Override
	protected void registerSubcommands() {
		registerSubcommand(new ParticleGeneratorCreateSubCommand(this));
		registerSubcommand(new ParticleGeneratorListSubCommand(this));
		registerSubcommand(new ParticleGeneratorRegiontoolSubCommand(this));
		registerSubcommand(new ParticleGeneratorDeleteSubCommand(this));
		registerSubcommand(new ParticleGeneratorSetparticleSubCommand(this));
		registerSubcommand(new ParticleGeneratorSetstrengthSubCommand(this));
		registerSubcommand(new ParticleGeneratorSetticksSubCommand(this));
		registerSubcommand(new ParticleGeneratorSetdistanceSubCommand(this));
		registerSubcommand(new ParticleGeneratorSetregionSubCommand(this));
		registerSubcommand(new ParticleGeneratorSetlocationSubCommand(this));
		registerSubcommand(new ParticleGeneratorInfoSubCommand(this));
		registerSubcommand(new ParticleGeneratorToggleoffSubCommand(this));
		registerSubcommand(new ParticleGeneratorToggleonSubCommand(this));
		registerSubcommand(new ReloadCommand());
	}

	@Override
	protected String[] getHelpHeader() {
		return new String[]{Common.colorize("{prefix} The following commands are available:")};
	}

	@Override
	protected List<SimpleComponent> getNoParamsHeader() {
		return Arrays.asList(SimpleComponent.of("{prefix} Use /particles ? to list the commands."));
	}
}
