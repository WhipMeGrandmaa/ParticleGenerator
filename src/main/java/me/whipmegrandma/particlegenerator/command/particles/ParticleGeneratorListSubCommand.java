package me.whipmegrandma.particlegenerator.command.particles;

import me.whipmegrandma.particlegenerator.settings.Particle;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;
import org.mineacademy.fo.model.ChatPaginator;
import org.mineacademy.fo.model.SimpleComponent;
import org.mineacademy.fo.region.Region;

import java.util.ArrayList;
import java.util.List;

public final class ParticleGeneratorListSubCommand extends SimpleSubCommand {

	public ParticleGeneratorListSubCommand(SimpleCommandGroup parent) {
		super(parent, "list");

		this.setPermission("particlegenerator.list");
	}


	@Override
	protected void onCommand() {
		List<SimpleComponent> pages = new ArrayList<>();

		for (Particle particle : Particle.getAllItems()) {
			String name = particle.getName();
			String type = particle.getType().toString().toLowerCase();

			Region region = particle.getRegion();

			Location primary = region != null ? particle.getRegion().getPrimary() : null;
			Location secondary = region != null ? particle.getRegion().getSecondary() : null;
			String primaryLocation = primary != null ? primary.getWorld().getName() + " " + primary.getX() + ", " + primary.getY() + ", " + primary.getZ() : null;
			String secondaryLocation = secondary != null ? secondary.getWorld().getName() + " " + secondary.getX() + ", " + secondary.getY() + ", " + secondary.getZ() : null;

			Location location = particle.getLocation();
			String locationString = location != null ? location.getWorld().getName() + " " + location.getX() + ", " + location.getY() + ", " + location.getZ() : null;

			Float strength = particle.getStrength();

			
			List<String> data = new ArrayList<>();
			data.add("&fName: &7" + name);
			data.add("&fType: &7" + type);

			if (region != null) {
				data.add("&fRegion: &7");
				data.add("&7- " + primaryLocation);
				data.add("&7- " + secondaryLocation);
			}

			if (location != null)
				data.add("&fLocation: &7" + locationString);

			if (strength != null)
				data.add("&fStrength: &7" + strength);

			pages.add(SimpleComponent.of("&7- &f" + name).onHover(data));
		}

		new ChatPaginator(10, ChatColor.DARK_GRAY)
				.setHeader(
						"&8" + Common.chatLineSmooth(),
						"<center>&c&lParticle Generators",
						"&8" + Common.chatLineSmooth()
				).setPages(pages)
				.send(sender);
	}

	@Override
	protected List<String> tabComplete() {
		return NO_COMPLETE;
	}
}
