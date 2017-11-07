package ebm.com.mce.handlers.registry;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryRegistry {
	public static void oreDictionary() {
		// Flamestone
		OreDictionary.registerOre("flameStone", new ItemStack(mod_ebm.flameStone));
		OreDictionary.registerOre("flameStone", new ItemStack(mod_ebm.flameStoneDeactivated));
		OreDictionary.registerOre("flameStone", new ItemStack(mod_ebm.flameStoneBurnMobs));
		OreDictionary.registerOre("flameStone", new ItemStack(mod_ebm.flameStoneBurnPlayers));

		// Dymus
		OreDictionary.registerOre("dymusFancy", new ItemStack(mod_ebm.dymusBricks));
		OreDictionary.registerOre("dymusFancy", new ItemStack(mod_ebm.dymusOrnate));
		OreDictionary.registerOre("dymusFancy", new ItemStack(mod_ebm.dymusPillar));
		//
		OreDictionary.registerOre("dymusSlab", new ItemStack(mod_ebm.dymusSlab));
		OreDictionary.registerOre("dymusSlab", new ItemStack(mod_ebm.dymusBrickSlab));
		OreDictionary.registerOre("dymusSlab", new ItemStack(mod_ebm.dymusOrnateSlab));
		//
		OreDictionary.registerOre("dymusStair", new ItemStack(mod_ebm.dymusStairs));
		OreDictionary.registerOre("dymusStair", new ItemStack(mod_ebm.dymusBrickStairs));
		OreDictionary.registerOre("dymusStair", new ItemStack(mod_ebm.dymusOrnateStairs));

		// Autil
		OreDictionary.registerOre("autilFancy", new ItemStack(mod_ebm.autilBricks));
		OreDictionary.registerOre("autilFancy", new ItemStack(mod_ebm.autilOrnate));
		OreDictionary.registerOre("autilFancy", new ItemStack(mod_ebm.autilPillar));
		//
		OreDictionary.registerOre("autilSlab", new ItemStack(mod_ebm.autilSlab));
		OreDictionary.registerOre("autilSlab", new ItemStack(mod_ebm.autilBrickSlab));
		OreDictionary.registerOre("autilSlab", new ItemStack(mod_ebm.autilOrnateSlab));
		//
		OreDictionary.registerOre("autilStair", new ItemStack(mod_ebm.autilStairs));
		OreDictionary.registerOre("autilStair", new ItemStack(mod_ebm.autilBrickStairs));
		OreDictionary.registerOre("autilStair", new ItemStack(mod_ebm.autilOrnateStairs));

		// Logs
		OreDictionary.registerOre("logGlass", new ItemStack(mod_ebm.glassLog));
		OreDictionary.registerOre("logBone", new ItemStack(mod_ebm.boneLog));
		OreDictionary.registerOre("logWood", new ItemStack(mod_ebm.mLog));
		OreDictionary.registerOre("logWood", new ItemStack(mod_ebm.deadLog));
		OreDictionary.registerOre("logWood", new ItemStack(mod_ebm.mauvewoodLog));

		// Planks
		OreDictionary.registerOre("plankWood", new ItemStack(mod_ebm.mPlanks));
		OreDictionary.registerOre("plankWood", new ItemStack(mod_ebm.deadPlanks));
		OreDictionary.registerOre("plankWood", new ItemStack(mod_ebm.mauvePlanks));

		// Trapdoors
		OreDictionary.registerOre("trapdoor", new ItemStack(mod_ebm.mTDoor));
		OreDictionary.registerOre("trapdoor", new ItemStack(mod_ebm.deadTDoor));
		OreDictionary.registerOre("trapdoor", new ItemStack(mod_ebm.mauveTDoor));

		// Secret Trapdoors
		OreDictionary.registerOre("secretTrapdoor", new ItemStack(mod_ebm.mSTDoor));
		OreDictionary.registerOre("secretTrapdoor", new ItemStack(mod_ebm.deadSTDoor));
		OreDictionary.registerOre("secretTrapdoor", new ItemStack(mod_ebm.mauveSTDoor));

		// Chests
		OreDictionary.registerOre("blockChest", new ItemStack(mod_ebm.mChest));
		OreDictionary.registerOre("blockChest", new ItemStack(mod_ebm.deadChest));
		OreDictionary.registerOre("blockChest", new ItemStack(mod_ebm.mauveChest));
		OreDictionary.registerOre("trappedChest", new ItemStack(mod_ebm.mChestTrapped));
		OreDictionary.registerOre("trappedChest", new ItemStack(mod_ebm.deadChestTrapped));
		OreDictionary.registerOre("trappedChest", new ItemStack(mod_ebm.mauveChestTrapped));

		// Door Items
		OreDictionary.registerOre("doorWood", new ItemStack(mod_ebm.mDoorItem));
		OreDictionary.registerOre("doorWood", new ItemStack(mod_ebm.deadDoorItem));
		OreDictionary.registerOre("doorWood", new ItemStack(mod_ebm.mauvewoodDoorItem));

		// Fences
		OreDictionary.registerOre("fenceWood", new ItemStack(mod_ebm.mFence));
		OreDictionary.registerOre("fenceWood", new ItemStack(mod_ebm.deadFence));
		OreDictionary.registerOre("fenceWood", new ItemStack(mod_ebm.mauveFence));

		// Fences Gates
		OreDictionary.registerOre("fenceWood", new ItemStack(mod_ebm.mFenceGate));
		OreDictionary.registerOre("fenceWood", new ItemStack(mod_ebm.deadFenceGate));
		OreDictionary.registerOre("fenceWood", new ItemStack(mod_ebm.mauveFenceGate));

		// Wooden Slabs
		OreDictionary.registerOre("slabWood", new ItemStack(mod_ebm.mWoodSlab));
		OreDictionary.registerOre("slabWood", new ItemStack(mod_ebm.deadWoodSlab));
		OreDictionary.registerOre("slabWood", new ItemStack(mod_ebm.mauvewoodSlab));

		// Wooden Stairs
		OreDictionary.registerOre("stairWood", new ItemStack(mod_ebm.mWoodStairs));
		OreDictionary.registerOre("stairWood", new ItemStack(mod_ebm.deadWoodStairs));
		OreDictionary.registerOre("stairWood", new ItemStack(mod_ebm.mauvewoodStairs));

		// Leaves
		OreDictionary.registerOre("treeLeaves", new ItemStack(mod_ebm.glassLeaves));
		OreDictionary.registerOre("treeLeaves", new ItemStack(mod_ebm.mLeaves));
		OreDictionary.registerOre("treeLeaves", new ItemStack(mod_ebm.mauvewoodLeaves));

		// Sapling
		OreDictionary.registerOre("treeSapling", new ItemStack(mod_ebm.glassSapling));
		OreDictionary.registerOre("treeSapling", new ItemStack(mod_ebm.boneSapling));
		OreDictionary.registerOre("treeSapling", new ItemStack(mod_ebm.mSapling));
		OreDictionary.registerOre("treeSapling", new ItemStack(mod_ebm.mauvewoodSapling));

		// Sticks
		OreDictionary.registerOre("stickWood", new ItemStack(mod_ebm.mStick));
		OreDictionary.registerOre("stickWood", new ItemStack(mod_ebm.deadStick));
		OreDictionary.registerOre("stickWood", new ItemStack(mod_ebm.mauveStick));

		// Ingots
		OreDictionary.registerOre("ingotDymus", new ItemStack(mod_ebm.dymusBar));

		// Dusts
		OreDictionary.registerOre("dustDymus", new ItemStack(mod_ebm.dymusPowder));
		OreDictionary.registerOre("dust", new ItemStack(mod_ebm.dust));
		OreDictionary.registerOre("dustAutil", new ItemStack(mod_ebm.autil));

		// Foods
		OreDictionary.registerOre("foodHoney", new ItemStack(mod_ebm.honey));
		OreDictionary.registerOre("foodCrystalHoney", new ItemStack(mod_ebm.crystalHoney));

		// Other
		// Blocks
		OreDictionary.registerOre("blockDymus", new ItemStack(mod_ebm.dymusBlock));
		OreDictionary.registerOre("blockAutil", new ItemStack(mod_ebm.autilBlock));
		OreDictionary.registerOre("blockBone", new ItemStack(mod_ebm.boneBlock));
		OreDictionary.registerOre("blockHoneycomb", new ItemStack(mod_ebm.honeycomb));
		OreDictionary.registerOre("blockBeeswax", new ItemStack(mod_ebm.beeswax));
		OreDictionary.registerOre("blockCrystalHoney", new ItemStack(mod_ebm.crystalHoneyBlock));

		// Items
		OreDictionary.registerOre("bee", new ItemStack(mod_ebm.bee));
		OreDictionary.registerOre("stinger", new ItemStack(mod_ebm.stinger));
	}
}
