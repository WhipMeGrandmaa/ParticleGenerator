package me.whipmegrandma.particlegenerator.settings;

import lombok.Getter;
import org.mineacademy.fo.settings.YamlConfig;

@Getter
public class Settings extends YamlConfig {
	@Getter
	private static Settings instance;

	private Integer distance;
	private Integer ticks;
	private Boolean toggleOn;

	public Settings() {
		instance = this;

		this.loadConfiguration(NO_DEFAULT, "settings.yml");
	}

	@Override
	protected void onLoad() {
		this.distance = this.getInteger("Distance");
		this.ticks = this.getInteger("Ticks");
		this.toggleOn = this.getBoolean("Toggle_On");
	}

	@Override
	protected void onSave() {
		this.set("Distance", this.distance);
		this.set("Ticks", this.ticks);
		this.save("Toggle_On", this.toggleOn);
	}

	public void setDistance(Integer distance) {
		this.distance = distance;

		this.save();
	}

	public void setTicks(Integer ticks) {
		this.ticks = ticks;

		this.save();
	}

	public void toggleOff() {
		this.toggleOn = false;

		this.save();
	}

	public void toggleOn() {
		this.toggleOn = true;

		this.save();
	}

	public static Settings load() {
		return new Settings();
	}
}
