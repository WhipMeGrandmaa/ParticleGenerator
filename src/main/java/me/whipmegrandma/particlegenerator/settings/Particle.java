package me.whipmegrandma.particlegenerator.settings;

import lombok.Getter;
import org.bukkit.Location;
import org.mineacademy.fo.ReflectionUtil;
import org.mineacademy.fo.region.Region;
import org.mineacademy.fo.remain.CompParticle;
import org.mineacademy.fo.settings.ConfigItems;
import org.mineacademy.fo.settings.YamlConfig;

import java.util.Collection;
import java.util.Set;

@Getter
public class Particle extends YamlConfig {

	private static ConfigItems<Particle> loadedParticles = ConfigItems.fromFolder("particles", Particle.class);

	private CompParticle type;
	private Location location;
	private Region region;
	private Float strength;

	private Particle(String name) {
		this(name, null, null, null, null);
	}

	private Particle(String name, CompParticle particle, Location location, Region region, Float strength) {
		this.type = particle;
		this.location = location;
		this.region = region;
		this.strength = strength;

		this.loadConfiguration(NO_DEFAULT, "particles/" + name + ".yml");
	}

	@Override
	protected void onLoad() {

		if (this.type == null) {

			this.type = this.isSet("Type") ? ReflectionUtil.lookupEnumSilent(CompParticle.class, this.getString("Type").toUpperCase()) : null;
			this.location = this.isSet("Location") ? this.get("Location", Location.class).add(0.5, 0.5, 0.5) : null;
			this.region = this.isSet("Region") ? this.get("Region", Region.class) : null;
			this.strength = this.get("Strength", Float.class);

		} else
			this.save();
	}

	@Override
	protected void onSave() {
		this.set("Type", this.type);
		this.set("Location", this.location);
		this.set("Region", this.region);
		this.set("Strength", this.strength);
	}

	public void setStrength(Float strength) {
		this.strength = strength;

		this.save();
	}

	public void setType(CompParticle type) {
		this.type = type;

		this.save();
	}

	public void setRegion(Region region) {
		this.region = region;
		this.location = null;

		this.save();
	}

	public void setLocation(Location location) {
		this.location = location.add(0.5, 0.5, 0.5);
		this.region = null;
		this.strength = null;

		this.save();
	}

	public static Particle get(String name) {
		return loadedParticles.findItem(name);
	}

	public static Collection<Particle> getAllItems() {
		return loadedParticles.getItems();
	}

	public static Set<String> getAllNames() {
		return loadedParticles.getItemNames();
	}

	public static boolean isLoaded(String name) {
		return loadedParticles.isItemLoaded(name);
	}

	public static void create(String name, CompParticle particle, Location location, Region region, Float strength) {
		loadedParticles.loadOrCreateItem(name, () -> new Particle(name, particle, location, region, strength));
	}

	public static void create(String name) {
		loadedParticles.loadOrCreateItem(name, () -> new Particle(name));
	}

	public static void remove(String name) {
		loadedParticles.removeItemByName(name);
	}

	public static void loadParticles() {
		loadedParticles.loadItems();
	}
}
