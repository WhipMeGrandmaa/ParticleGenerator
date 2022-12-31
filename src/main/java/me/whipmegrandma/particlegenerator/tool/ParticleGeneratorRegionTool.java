package me.whipmegrandma.particlegenerator.tool;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.whipmegrandma.particlegenerator.settings.PlayerData;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.visual.VisualTool;
import org.mineacademy.fo.visual.VisualizedRegion;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ParticleGeneratorRegionTool extends VisualTool {

	@Getter
	private static final ParticleGeneratorRegionTool instance = new ParticleGeneratorRegionTool();

	@Override
	protected CompMaterial getBlockMask(Block block, Player player) {
		return CompMaterial.DIAMOND_BLOCK;
	}

	@Override
	public ItemStack getItem() {
		return ItemCreator.of(CompMaterial.DIAMOND_AXE, "&dRegion Selector")
				.glow(true)
				.make();
	}

	@Override
	protected VisualizedRegion getVisualizedRegion(Player player) {
		return PlayerData.from(player).getRegion();
	}
}
