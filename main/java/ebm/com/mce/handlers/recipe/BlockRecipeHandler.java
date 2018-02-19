package ebm.com.mce.handlers.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import ebm.com.mce.common.mod_ebm;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class BlockRecipeHandler {
	public static void registerCrafting() {
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.glass, 4), new ItemStack(mod_ebm.glassLog));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.boneBlock), "***", "***", "***", '*', new ItemStack(Items.bone));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.bloodBoneBlock), "***", "***", "***", '*',
				new ItemStack(mod_ebm.bloodBone));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.dymusBlock), "***", "***", "***", '*',
				new ItemStack(mod_ebm.dymusPowder));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.dymusBricks, 4), "**", "**", '*',
				new ItemStack(mod_ebm.dymusBlock));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.dymusOrnate), "b", "*", '*', new ItemStack(mod_ebm.dymusBlock),
				'b', new ItemStack(mod_ebm.dymusBar));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.dymusPillar, 3), "b*b", "b*b", "b*b", 'b',
				new ItemStack(mod_ebm.dymusBar), '*', new ItemStack(mod_ebm.dymusBlock));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.dymusStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.dymusBlock));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.dymusBrickStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.dymusBricks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.dymusOrnateStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.dymusOrnate));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.dymusSlab, 6), "***", '*', new ItemStack(mod_ebm.dymusBlock));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.dymusBrickSlab, 6), "***", '*',
				new ItemStack(mod_ebm.dymusBricks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.dymusOrnateSlab, 6), "***", '*',
				new ItemStack(mod_ebm.dymusOrnate));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.autilBlockFull), "**", "**", '*', new ItemStack(mod_ebm.autil));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.autilBricks, 4), "**", "**", '*',
				new ItemStack(mod_ebm.autilBlockFull));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.autilOrnate), "b", "*", '*', new ItemStack(mod_ebm.autilBlockFull),
				'b', new ItemStack(mod_ebm.autil));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.autilPillar, 3), "b*b", "b*b", "b*b", 'b',
				new ItemStack(mod_ebm.autil), '*', new ItemStack(mod_ebm.autilBlockFull));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.autilStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.autilBlockFull));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.autilBrickStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.autilBricks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.autilOrnateStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.autilOrnate));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.autilSlab, 6), "***", '*', new ItemStack(mod_ebm.autilBlockFull));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.autilBrickSlab, 6), "***", '*',
				new ItemStack(mod_ebm.autilBricks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.autilOrnateSlab, 6), "***", '*',
				new ItemStack(mod_ebm.autilOrnate));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_ebm.mPlanks, 4), new ItemStack(mod_ebm.mLog));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_ebm.deadPlanks, 4), new ItemStack(mod_ebm.deadLog));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_ebm.mauvePlanks, 4), new ItemStack(mod_ebm.mauvewoodLog));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.amethystBricks, 4), "**", "**", '*',
				new ItemStack(mod_ebm.amethystCrust));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.amethystOrnate), "b", "*", '*',
				new ItemStack(mod_ebm.amethystCrust), 'b', new ItemStack(mod_ebm.amethystGrit));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.amethystPillar, 3), "b*b", "b*b", "b*b", 'b',
				new ItemStack(mod_ebm.amethystGrit), '*', new ItemStack(mod_ebm.amethystCrust));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.amethystStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.amethystCrust));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.amethystBrickStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.amethystBricks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.amethystOrnateStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.amethystOrnate));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.amethystSlab, 6), "***", '*',
				new ItemStack(mod_ebm.amethystCrust));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.amethystBrickSlab, 6), "***", '*',
				new ItemStack(mod_ebm.amethystBricks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.amethystOrnateSlab, 6), "***", '*',
				new ItemStack(mod_ebm.amethystOrnate));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.deadWoodStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.deadPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.deadWoodSlab, 6), "***", '*', new ItemStack(mod_ebm.deadPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mWoodStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.mPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mWoodSlab, 6), "***", '*', new ItemStack(mod_ebm.mPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mauvewoodStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.mauvePlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mauvewoodSlab, 6), "***", '*', new ItemStack(mod_ebm.mauvePlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mFence, 2), "sss", "sss", 's', new ItemStack(mod_ebm.mStick));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.deadFence, 2), "sss", "sss", 's',
				new ItemStack(mod_ebm.deadStick));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mauveFence, 2), "sss", "sss", 's',
				new ItemStack(mod_ebm.mauveStick));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.crystalHoneyBlock), "***", "***", "***", '*',
				new ItemStack(mod_ebm.honey));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_ebm.crystalHoneyBlock), new ItemStack(mod_ebm.crystalHoney),
				new ItemStack(mod_ebm.crystalHoney), new ItemStack(mod_ebm.crystalHoney));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mTorch, 4), "c", "s", 'c', new ItemStack(Items.coal, 0), 's',
				new ItemStack(mod_ebm.mStick));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mTorch, 4), "c", "s", 'c', new ItemStack(Items.coal, 1, 1), 's',
				new ItemStack(mod_ebm.mStick));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.deadTorch, 4), "c", "s", 'c', new ItemStack(Items.coal, 0), 's',
				new ItemStack(mod_ebm.deadStick));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.deadTorch, 4), "c", "s", 'c', new ItemStack(Items.coal, 1, 1), 's',
				new ItemStack(mod_ebm.deadStick));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mauveTorch, 4), "c", "s", 'c', new ItemStack(Items.coal, 0), 's',
				new ItemStack(mod_ebm.mauveStick));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mauveTorch, 4), "c", "s", 'c', new ItemStack(Items.coal, 1, 1),
				's', new ItemStack(mod_ebm.mauveStick));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mTorchRed), "r", "s", 'r', new ItemStack(Items.redstone), 's',
				new ItemStack(mod_ebm.mStick));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.deadTorchRed), "r", "s", 'r', new ItemStack(Items.redstone), 's',
				new ItemStack(mod_ebm.deadStick));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mauveTorchRed), "r", "s", 'r', new ItemStack(Items.redstone), 's',
				new ItemStack(mod_ebm.mauveStick));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mChest), "***", "* *", "***", '*', new ItemStack(mod_ebm.mPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.deadChest), "***", "* *", "***", '*',
				new ItemStack(mod_ebm.deadPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mauveChest), "***", "* *", "***", '*',
				new ItemStack(mod_ebm.mauvePlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mFenceGate), "sws", "sws", 's', new ItemStack(mod_ebm.mStick), 'w',
				new ItemStack(mod_ebm.mPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.deadFenceGate), "sws", "sws", 's',
				new ItemStack(mod_ebm.deadStick), 'w', new ItemStack(mod_ebm.deadPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mauveFenceGate), "sws", "sws", 's',
				new ItemStack(mod_ebm.mauveStick), 'w', new ItemStack(mod_ebm.mauvePlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mTDoor, 2), "***", "***", '*', new ItemStack(mod_ebm.mPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.deadTDoor, 2), "***", "***", '*',
				new ItemStack(mod_ebm.deadPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mauveTDoor, 2), "***", "***", '*',
				new ItemStack(mod_ebm.mauvePlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mLever), "*", "c", '*', new ItemStack(mod_ebm.mStick), 'c',
				new ItemStack(Blocks.cobblestone));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.deadLever), "*", "c", '*', new ItemStack(mod_ebm.deadStick), 'c',
				new ItemStack(Blocks.cobblestone));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mauveLever), "*", "c", '*', new ItemStack(mod_ebm.mauveStick), 'c',
				new ItemStack(Blocks.cobblestone));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mPlate), "**", '*', new ItemStack(mod_ebm.mPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.deadPlate), "**", '*', new ItemStack(mod_ebm.deadPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mauvePlate), "**", '*', new ItemStack(mod_ebm.mauvePlanks));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_ebm.mButton), new ItemStack(mod_ebm.mPlanks));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_ebm.deadButton), new ItemStack(mod_ebm.deadPlanks));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_ebm.mauveButton), new ItemStack(mod_ebm.mauvePlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mLadder, 3), "s s", "sss", "s s", 's',
				new ItemStack(mod_ebm.mStick));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.deadLadder, 3), "s s", "sss", "s s", 's',
				new ItemStack(mod_ebm.deadStick));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mauveLadder, 3), "s s", "sss", "s s", 's',
				new ItemStack(mod_ebm.mauveStick));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mChestTrapped), "*", "-", '*', new ItemStack(mod_ebm.mChest), '-',
				new ItemStack(Blocks.tripwire_hook));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.deadChestTrapped), "*", "-", '*', new ItemStack(mod_ebm.deadChest),
				'-', new ItemStack(Blocks.tripwire_hook));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mauveChestTrapped), "*", "-", '*',
				new ItemStack(mod_ebm.mauveChest), '-', new ItemStack(Blocks.tripwire_hook));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mCTable), "**", "**", '*', new ItemStack(mod_ebm.mPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.deadCTable), "**", "**", '*', new ItemStack(mod_ebm.deadPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mauveCTable), "**", "**", '*', new ItemStack(mod_ebm.mauvePlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.honeycomb), "hb", "bh", 'h', new ItemStack(mod_ebm.honey), 'b',
				new ItemStack(mod_ebm.beeswax));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.honeycomb), "bh", "hb", 'h', new ItemStack(mod_ebm.honey), 'b',
				new ItemStack(mod_ebm.beeswax));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.boneSlab, 6), "***", '*', new ItemStack(mod_ebm.boneBlock));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.boneStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.boneBlock));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.beeswaxBricks, 4), "**", "**", '*',
				new ItemStack(mod_ebm.beeswax));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.beeswaxOrnate), "h", "*", 'h', new ItemStack(mod_ebm.honey), '*',
				new ItemStack(mod_ebm.beeswax));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.beeswaxPillar, 3), "*h*", "*h*", "*h*", 'h',
				new ItemStack(mod_ebm.honey), '*', new ItemStack(mod_ebm.beeswax));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.beeswaxStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.beeswax));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.beeswaxOrnateStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.beeswaxOrnate));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.beeswaxBrickStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.beeswaxBricks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.beeswaxSlab, 6), "***", '*', new ItemStack(mod_ebm.beeswax));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.beeswaxOrnateSlab, 6), "***", '*',
				new ItemStack(mod_ebm.beeswaxOrnate));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.beeswaxBrickSlab, 6), "***", '*',
				new ItemStack(mod_ebm.beeswaxBricks));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_ebm.flameStone), new ItemStack(Blocks.stone),
				new ItemStack(mod_ebm.pyreCrystal));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.dymusChisel), " i ", "ibi", " i ", 'i',
				new ItemStack(mod_ebm.dymusBar), 'b', new ItemStack(mod_ebm.dymusBlock));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.autilChisel), " i ", "ibi", " i ", 'i',
				new ItemStack(mod_ebm.autil), 'b', new ItemStack(mod_ebm.autilBlockFull));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.amethystChisel), " i ", "ibi", " i ", 'i',
				new ItemStack(mod_ebm.amethystGrit), 'b', new ItemStack(mod_ebm.amethystCrust));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.beeswaxChisel), " i ", "ibi", " i ", 'i',
				new ItemStack(mod_ebm.honey), 'b', new ItemStack(mod_ebm.beeswax));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.dymusChiselSlab, 6), "***", '*',
				new ItemStack(mod_ebm.dymusChisel));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.autilChiselSlab, 6), "***", '*',
				new ItemStack(mod_ebm.autilChisel));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.amethystChiselSlab, 6), "***", '*',
				new ItemStack(mod_ebm.amethystChisel));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.beeswaxChiselSlab, 6), "***", '*',
				new ItemStack(mod_ebm.beeswaxChisel));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.dymusChiselStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.dymusChisel));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.autilChiselStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.autilChisel));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.amethystChiselStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.amethystChisel));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.beeswaxChiselStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_ebm.beeswaxChisel));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.crimsonObsidian, 1), "rer", " o ", "rpr", 'r',
				new ItemStack(Items.dye, 1, 1), 'o', new ItemStack(Blocks.obsidian), 'e',
				new ItemStack(mod_ebm.erythonCube), 'p', new ItemStack(mod_ebm.pyreCrystal));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.crimsonObsidian, 1), "rpr", " o ", "rer", 'r',
				new ItemStack(Items.dye, 1, 1), 'o', new ItemStack(Blocks.obsidian), 'e',
				new ItemStack(mod_ebm.erythonCube), 'p', new ItemStack(mod_ebm.pyreCrystal));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.crimticBlock), "***", "***", "***", '*',
				new ItemStack(mod_ebm.crimticIngot));
	}

	public static void registerSmelting() {
	}
}
