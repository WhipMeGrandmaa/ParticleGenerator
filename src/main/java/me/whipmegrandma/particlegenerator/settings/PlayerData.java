package me.whipmegrandma.particlegenerator.settings;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.mineacademy.fo.settings.YamlConfig;
import org.mineacademy.fo.visual.VisualizedRegion;

import java.util.HashMap;
import java.util.UUID;

public class PlayerData extends YamlConfig {

	private static HashMap<UUID, PlayerData> loadedPlayers = new HashMap<>();

	private Boolean showParticleGenerator;
	@Getter
	private VisualizedRegion region = new VisualizedRegion();

	private PlayerData(UUID uuid) {
		this.loadConfiguration(NO_DEFAULT, "playerdata/" + uuid + ".yml");
	}

	@Override
	protected void onLoad() {
		this.showParticleGenerator = this.getBoolean("Show_Particles", true);

		if (!this.isSet("Show_Particles"))
			this.save();
	}

	@Override
	protected void onSave() {
		this.set("Show_Particles", this.showParticleGenerator);
	}

	public boolean canSee() {
		return this.showParticleGenerator;
	}

	public void changeCanSee() {
		this.showParticleGenerator = !this.showParticleGenerator;

		this.save();
	}

	public static PlayerData from(Player player) {
		UUID uuid = player.getUniqueId();
		PlayerData data = loadedPlayers.get(uuid);

		if (data == null) {
			data = new PlayerData(uuid);

			loadedPlayers.put(uuid, data);
		}

		return data;
	}

	public static void remove(Player player) {
		UUID uuid = player.getUniqueId();

		loadedPlayers.remove(uuid);
	}
}
