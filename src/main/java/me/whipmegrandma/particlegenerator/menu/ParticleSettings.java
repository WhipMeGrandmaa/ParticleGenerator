package me.whipmegrandma.particlegenerator.menu;

import me.whipmegrandma.particlegenerator.settings.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.annotation.Position;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

public class ParticleSettings extends Menu {

	@Position(4)
	private final Button toggle;

	public ParticleSettings(Player player) {
		this.setViewer(player);

		this.setTitle("Particle Settings");
		this.setSize(9);

		this.toggle = new Button() {
			@Override
			public void onClickedInMenu(Player player, Menu menu, ClickType click) {
				PlayerData cache = PlayerData.from(player);
				cache.changeCanSee();

				restartMenu(cache.canSee() ? "&aToggled On" : "&cToggled Off");
			}

			@Override
			public ItemStack getItem() {
				PlayerData cache = PlayerData.from(getViewer());
				boolean canSee = cache.canSee();

				if (canSee)
					return ItemCreator.of(CompMaterial.CLOCK, "&a&lOn", "", "Click to toggle off", "certain particle generators.").make();

				if (!canSee)
					return ItemCreator.of(CompMaterial.COMPASS, "&c&lOff", "", "Click to toggle on", "certain particle generators.").make();

				return null;
			}
		};
	}

	@Override
	public Menu newInstance() {
		return new ParticleSettings(this.getViewer());
	}
}
