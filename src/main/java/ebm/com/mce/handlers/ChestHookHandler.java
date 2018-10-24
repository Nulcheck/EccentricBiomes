package ebm.com.mce.handlers;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class ChestHookHandler {
	public static void addHooks() {
		// Par1 is min, par2 is max, par3 is weight. Golden apple is rarity 1,
		// 100 is rarity of iron ingots.
		// Mineshaft
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.erythonCube), 1, 2, 15));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.autil), 1, 2, 5));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.dymusBar), 1, 2, 5));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.dymusPowder), 1, 2, 5));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.cd_hskele), 1, 1, 5));

		// Dungeon
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.erythonCube), 1, 2, 15));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.autil), 1, 2, 5));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.dymusBar), 1, 2, 5));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.dymusPowder), 1, 2, 5));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.erythonBattleAxe), 1, 1, 1));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.cd_hskele), 1, 1, 5));

		// Pyramid
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.erythonCube), 1, 2, 15));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.autil), 1, 2, 5));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.dymusBar), 1, 2, 5));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.dymusPowder), 1, 2, 5));

		// Jungle
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.erythonCube), 1, 2, 15));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.autil), 1, 2, 5));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.dymusBar), 1, 2, 5));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.dymusPowder), 1, 2, 5));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.cd_hskele), 1, 1, 5));

		// Blacksmith
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.erythonBattleAxe), 1, 1, 1));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.autil), 1, 2, 5));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.dymusBar), 1, 2, 5));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_ebm.dymusPowder), 1, 2, 5));
	}
}
