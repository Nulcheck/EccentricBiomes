package ebm.com.mce.handlers.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.items.blocks.ItemFlameStone;
import ebm.com.mce.items.blocks.ItemFlameStoneDeactivated;
import ebm.com.mce.items.blocks.ItemFlameStoneMobs;
import ebm.com.mce.items.blocks.ItemFlameStonePlayers;
import ebm.com.mce.items.blocks.ItemSlimeSpike;
import ebm.com.mce.items.blocks.unbreak.ItemunAutilBrickPressurePlate;
import ebm.com.mce.items.blocks.unbreak.ItemunAutilBrickStairs;
import ebm.com.mce.items.blocks.unbreak.ItemunAutilBricks;
import ebm.com.mce.items.blocks.unbreak.ItemunAutilRod;
import ebm.com.mce.items.slabs.ItemSlabAmethyst;
import ebm.com.mce.items.slabs.ItemSlabAmethystBricks;
import ebm.com.mce.items.slabs.ItemSlabAmethystChisel;
import ebm.com.mce.items.slabs.ItemSlabAmethystOrnate;
import ebm.com.mce.items.slabs.ItemSlabAutil;
import ebm.com.mce.items.slabs.ItemSlabAutilBricks;
import ebm.com.mce.items.slabs.ItemSlabAutilChisel;
import ebm.com.mce.items.slabs.ItemSlabAutilOrnate;
import ebm.com.mce.items.slabs.ItemSlabBeeswax;
import ebm.com.mce.items.slabs.ItemSlabBeeswaxBricks;
import ebm.com.mce.items.slabs.ItemSlabBeeswaxChisel;
import ebm.com.mce.items.slabs.ItemSlabBeeswaxOrnate;
import ebm.com.mce.items.slabs.ItemSlabBone;
import ebm.com.mce.items.slabs.ItemSlabDeadWood;
import ebm.com.mce.items.slabs.ItemSlabDymus;
import ebm.com.mce.items.slabs.ItemSlabDymusBricks;
import ebm.com.mce.items.slabs.ItemSlabDymusChisel;
import ebm.com.mce.items.slabs.ItemSlabDymusOrnate;
import ebm.com.mce.items.slabs.ItemSlabMWood;
import ebm.com.mce.items.slabs.ItemSlabMauvewood;
import ebm.com.mce.items.slabs.ItemSlabunAutilBricks;

public class BlockRegistry {
	public static void registerBlocks() {
		// Other
		GameRegistry.registerBlock(mod_ebm.blueDirt, "BlueDirt");
		GameRegistry.registerBlock(mod_ebm.blueFarmland, "BlueFarmland");
		GameRegistry.registerBlock(mod_ebm.flameStone, ItemFlameStone.class, mod_ebm.flameStone.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.flameStoneDeactivated, ItemFlameStoneDeactivated.class,
				mod_ebm.flameStoneDeactivated.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.flameStoneBurnMobs, ItemFlameStoneMobs.class,
				mod_ebm.flameStoneBurnMobs.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.flameStoneBurnPlayers, ItemFlameStonePlayers.class,
				mod_ebm.flameStoneBurnPlayers.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.unstompableFarmland, "USFarmland");
		GameRegistry.registerBlock(mod_ebm.boneBlock, "BoneBlock");
		GameRegistry.registerBlock(mod_ebm.deadGrass, "DeadGrass");
		GameRegistry.registerBlock(mod_ebm.deadDirt, "DeadDirt");
		GameRegistry.registerBlock(mod_ebm.dymusBlock, "DymusBlock");
		GameRegistry.registerBlock(mod_ebm.autilBlock, "AutilBlock");
		GameRegistry.registerBlock(mod_ebm.autilBlockFull, "AutilBlockFull");
		GameRegistry.registerBlock(mod_ebm.autilRod, "AutilRod");
		GameRegistry.registerBlock(mod_ebm.amethystCrust, "AmethystCrust");
		GameRegistry.registerBlock(mod_ebm.amethystDirt, "AmethystDirt");
		GameRegistry.registerBlock(mod_ebm.honeycomb, "honeycomb");
		GameRegistry.registerBlock(mod_ebm.shadowHoneycomb, "shadowHoneycomb");
		GameRegistry.registerBlock(mod_ebm.beeswax, "beeswax");
		GameRegistry.registerBlock(mod_ebm.crystalHoneyBlock, "crystalHoneyBlock");
		GameRegistry.registerBlock(mod_ebm.slimyGrass, "slimeGrass");
		GameRegistry.registerBlock(mod_ebm.crimsonObsidian, "redObsidian");
		GameRegistry.registerBlock(mod_ebm.crimsonStone, "crimsonStone");

		// Fires
		GameRegistry.registerBlock(mod_ebm.crimsonFire, "crimsonFire");

		// Portals
		GameRegistry.registerBlock(mod_ebm.crimsonPortal, "crimsonPortal");

		// Planks
		GameRegistry.registerBlock(mod_ebm.mPlanks, "mPlanks");
		GameRegistry.registerBlock(mod_ebm.deadPlanks, "deadPlanks");
		GameRegistry.registerBlock(mod_ebm.mauvePlanks, "mauvePlanks");

		// Chests
		GameRegistry.registerBlock(mod_ebm.mChest, "mChest");
		GameRegistry.registerBlock(mod_ebm.mChestTrapped, "mChestTrapped");

		GameRegistry.registerBlock(mod_ebm.deadChest, "deadChest");
		GameRegistry.registerBlock(mod_ebm.deadChestTrapped, "deadChestTrapped");

		GameRegistry.registerBlock(mod_ebm.mauveChest, "mauveChest");
		GameRegistry.registerBlock(mod_ebm.mauveChestTrapped, "mauveChestTrapped");

		// Crafting Tables
		GameRegistry.registerBlock(mod_ebm.mCTable, "mWorkbench");
		GameRegistry.registerBlock(mod_ebm.deadCTable, "deadWorkbench");
		GameRegistry.registerBlock(mod_ebm.mauveCTable, "mauveWorkbench");

		// Fences
		GameRegistry.registerBlock(mod_ebm.mFence, "mFence");
		GameRegistry.registerBlock(mod_ebm.deadFence, "deadFence");
		GameRegistry.registerBlock(mod_ebm.mauveFence, "mauveFence");

		// Fence Gates
		GameRegistry.registerBlock(mod_ebm.mFenceGate, "mGate");
		GameRegistry.registerBlock(mod_ebm.deadFenceGate, "deadGate");
		GameRegistry.registerBlock(mod_ebm.mauveFenceGate, "mauveGate");

		// Doors
		GameRegistry.registerBlock(mod_ebm.mDoor, "mDoor");
		GameRegistry.registerBlock(mod_ebm.deadDoor, "deadDoor");
		GameRegistry.registerBlock(mod_ebm.mauvewoodDoor, "mauveDoor");

		// Unbreakable
		GameRegistry.registerBlock(mod_ebm.unAutilBricks, ItemunAutilBricks.class,
				mod_ebm.unAutilBricks.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.unAutilBrickStairs, ItemunAutilBrickStairs.class,
				mod_ebm.unAutilBrickStairs.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.unAutilBrickPressurePlate, ItemunAutilBrickPressurePlate.class,
				mod_ebm.unAutilBrickPressurePlate.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.unAutilBrickSlab, ItemSlabunAutilBricks.class,
				mod_ebm.unAutilBrickSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.unAutilBrickSlabDouble, ItemSlabunAutilBricks.class,
				mod_ebm.unAutilBrickSlabDouble.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.unAutilRod, ItemunAutilRod.class, mod_ebm.unAutilRod.getUnlocalizedName());

		// Fancy Shit
		GameRegistry.registerBlock(mod_ebm.dymusBricks, "DymusBricks");
		GameRegistry.registerBlock(mod_ebm.dymusOrnate, "DymusOrnate");
		GameRegistry.registerBlock(mod_ebm.dymusPillar, "DymusPillar");
		GameRegistry.registerBlock(mod_ebm.dymusChisel, "dymusChisel");
		GameRegistry.registerBlock(mod_ebm.autilBricks, "AutilBricks");
		GameRegistry.registerBlock(mod_ebm.autilOrnate, "AutilOrnate");
		GameRegistry.registerBlock(mod_ebm.autilPillar, "AutilPillar");
		GameRegistry.registerBlock(mod_ebm.autilChisel, "autilChisel");
		GameRegistry.registerBlock(mod_ebm.amethystBricks, "AmethystBricks");
		GameRegistry.registerBlock(mod_ebm.amethystOrnate, "AmethystOrnate");
		GameRegistry.registerBlock(mod_ebm.amethystPillar, "AmethystPillar");
		GameRegistry.registerBlock(mod_ebm.amethystChisel, "amethystChisel");
		GameRegistry.registerBlock(mod_ebm.beeswaxBricks, "BeeswaxBricks");
		GameRegistry.registerBlock(mod_ebm.beeswaxOrnate, "BeeswaxOrnate");
		GameRegistry.registerBlock(mod_ebm.beeswaxPillar, "BeeswaxPillar");
		GameRegistry.registerBlock(mod_ebm.beeswaxChisel, "beeswaxChisel");

		// Stairs
		// Wooden
		GameRegistry.registerBlock(mod_ebm.mWoodStairs, "mWoodStairs");
		GameRegistry.registerBlock(mod_ebm.deadWoodStairs, "deadWoodStairs");
		GameRegistry.registerBlock(mod_ebm.mauvewoodStairs, "mauvewoodStairs");

		// Rest
		GameRegistry.registerBlock(mod_ebm.dymusStairs, "DymusStairs");
		GameRegistry.registerBlock(mod_ebm.dymusBrickStairs, "DymusBrickStairs");
		GameRegistry.registerBlock(mod_ebm.dymusOrnateStairs, "DymusOrnateStairs");
		GameRegistry.registerBlock(mod_ebm.dymusChiselStairs, "dymusChiselStairs");
		GameRegistry.registerBlock(mod_ebm.autilStairs, "AutilStairs");
		GameRegistry.registerBlock(mod_ebm.autilBrickStairs, "AutilBrickStairs");
		GameRegistry.registerBlock(mod_ebm.autilOrnateStairs, "AutilOrnateStairs");
		GameRegistry.registerBlock(mod_ebm.autilChiselStairs, "autilChiselStairs");
		GameRegistry.registerBlock(mod_ebm.amethystStairs, "AmethystStairs");
		GameRegistry.registerBlock(mod_ebm.amethystBrickStairs, "AmethystBrickStairs");
		GameRegistry.registerBlock(mod_ebm.amethystOrnateStairs, "AmethystOrnateStairs");
		GameRegistry.registerBlock(mod_ebm.amethystChiselStairs, "amethystChiselStairs");
		GameRegistry.registerBlock(mod_ebm.boneStairs, "BoneStairs");
		GameRegistry.registerBlock(mod_ebm.beeswaxStairs, "BeeswaxStairs");
		GameRegistry.registerBlock(mod_ebm.beeswaxBrickStairs, "BeeswaxBrickStairs");
		GameRegistry.registerBlock(mod_ebm.beeswaxOrnateStairs, "BeeswaxOrnateStairs");
		GameRegistry.registerBlock(mod_ebm.beeswaxChiselStairs, "beeswaxChiselStairs");

		// Slabs
		// Wooden
		GameRegistry.registerBlock(mod_ebm.mWoodSlab, ItemSlabMWood.class, mod_ebm.mWoodSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.mWoodSlabDouble, ItemSlabMWood.class,
				mod_ebm.mWoodSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.deadWoodSlab, ItemSlabDeadWood.class,
				mod_ebm.deadWoodSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.deadWoodSlabDouble, ItemSlabDeadWood.class,
				mod_ebm.deadWoodSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.mauvewoodSlab, ItemSlabMauvewood.class,
				mod_ebm.mauvewoodSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.mauvewoodSlabDouble, ItemSlabMauvewood.class,
				mod_ebm.mauvewoodSlabDouble.getUnlocalizedName());

		// Rest
		GameRegistry.registerBlock(mod_ebm.dymusSlab, ItemSlabDymus.class, mod_ebm.dymusSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.dymusSlabDouble, ItemSlabDymus.class,
				mod_ebm.dymusSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.dymusBrickSlab, ItemSlabDymusBricks.class,
				mod_ebm.dymusBrickSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.dymusBrickSlabDouble, ItemSlabDymusBricks.class,
				mod_ebm.dymusBrickSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.dymusOrnateSlab, ItemSlabDymusOrnate.class,
				mod_ebm.dymusOrnateSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.dymusOrnateSlabDouble, ItemSlabDymusOrnate.class,
				mod_ebm.dymusOrnateSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.dymusChiselSlab, ItemSlabDymusChisel.class,
				mod_ebm.dymusChiselSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.dymusChiselSlabDouble, ItemSlabDymusChisel.class,
				mod_ebm.dymusChiselSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.autilSlab, ItemSlabAutil.class, mod_ebm.autilSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.autilSlabDouble, ItemSlabAutil.class,
				mod_ebm.autilSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.autilBrickSlab, ItemSlabAutilBricks.class,
				mod_ebm.autilBrickSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.autilBrickSlabDouble, ItemSlabAutilBricks.class,
				mod_ebm.autilBrickSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.autilOrnateSlab, ItemSlabAutilOrnate.class,
				mod_ebm.autilOrnateSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.autilOrnateSlabDouble, ItemSlabAutilOrnate.class,
				mod_ebm.autilOrnateSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.autilChiselSlab, ItemSlabAutilChisel.class,
				mod_ebm.autilChiselSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.autilChiselSlabDouble, ItemSlabAutilChisel.class,
				mod_ebm.autilChiselSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.amethystSlab, ItemSlabAmethyst.class,
				mod_ebm.amethystSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.amethystSlabDouble, ItemSlabAmethyst.class,
				mod_ebm.amethystSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.amethystBrickSlab, ItemSlabAmethystBricks.class,
				mod_ebm.amethystBrickSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.amethystBrickSlabDouble, ItemSlabAmethystBricks.class,
				mod_ebm.amethystBrickSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.amethystOrnateSlab, ItemSlabAmethystOrnate.class,
				mod_ebm.amethystOrnateSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.amethystOrnateSlabDouble, ItemSlabAmethystOrnate.class,
				mod_ebm.amethystOrnateSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.amethystChiselSlab, ItemSlabAmethystChisel.class,
				mod_ebm.amethystChiselSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.amethystChiselSlabDouble, ItemSlabAmethystChisel.class,
				mod_ebm.amethystChiselSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.boneSlab, ItemSlabBone.class, mod_ebm.boneSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.boneSlabDouble, ItemSlabBone.class,
				mod_ebm.boneSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.beeswaxSlab, ItemSlabBeeswax.class,
				mod_ebm.beeswaxSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.beeswaxSlabDouble, ItemSlabBeeswax.class,
				mod_ebm.beeswaxSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.beeswaxBrickSlab, ItemSlabBeeswaxBricks.class,
				mod_ebm.beeswaxBrickSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.beeswaxBrickSlabDouble, ItemSlabBeeswaxBricks.class,
				mod_ebm.beeswaxBrickSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.beeswaxOrnateSlab, ItemSlabBeeswaxOrnate.class,
				mod_ebm.beeswaxOrnateSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.beeswaxOrnateSlabDouble, ItemSlabBeeswaxOrnate.class,
				mod_ebm.beeswaxOrnateSlabDouble.getUnlocalizedName());

		GameRegistry.registerBlock(mod_ebm.beeswaxChiselSlab, ItemSlabBeeswaxChisel.class,
				mod_ebm.beeswaxChiselSlab.getUnlocalizedName());
		GameRegistry.registerBlock(mod_ebm.beeswaxChiselSlabDouble, ItemSlabBeeswaxChisel.class,
				mod_ebm.beeswaxChiselSlabDouble.getUnlocalizedName());

		// Logs
		GameRegistry.registerBlock(mod_ebm.glassLog, "GlassLog");
		GameRegistry.registerBlock(mod_ebm.boneLog, "BoneLog");
		GameRegistry.registerBlock(mod_ebm.mLog, "mLog");
		GameRegistry.registerBlock(mod_ebm.deadLog, "deadLog");
		GameRegistry.registerBlock(mod_ebm.mauvewoodLog, "MauvewoodLog");

		// Leaves
		GameRegistry.registerBlock(mod_ebm.glassLeaves, "GlassLeaves");
		GameRegistry.registerBlock(mod_ebm.mLeaves, "mLeaves");
		GameRegistry.registerBlock(mod_ebm.mauvewoodLeaves, "MauvewoodLeaves");

		// Saplings
		GameRegistry.registerBlock(mod_ebm.glassSapling, "GlassSapling");
		GameRegistry.registerBlock(mod_ebm.mSapling, "mSapling");
		GameRegistry.registerBlock(mod_ebm.mauvewoodSapling, "MauvewoodSapling");
		// GameRegistry.registerBlock(mod_ebm.boneSapling, "BoneSapling");

		// TODO: Plants
		GameRegistry.registerBlock(mod_ebm.beehive, "beehive");
		GameRegistry.registerBlock(mod_ebm.fireGrass, "fireGrass");
		GameRegistry.registerBlock(mod_ebm.slimeSpike, ItemSlimeSpike.class, "slimeSpike");

		// Crops
		GameRegistry.registerBlock(mod_ebm.pyreFlower, "PyreFlower");

		// Ladders
		GameRegistry.registerBlock(mod_ebm.mLadder, "mLadder");
		GameRegistry.registerBlock(mod_ebm.deadLadder, "deadLadder");
		GameRegistry.registerBlock(mod_ebm.mauveLadder, "mauveLadder");

		// Trapdoors
		GameRegistry.registerBlock(mod_ebm.mTDoor, "mTDoor");
		GameRegistry.registerBlock(mod_ebm.deadTDoor, "deadTDoor");
		GameRegistry.registerBlock(mod_ebm.mauveTDoor, "mauveTDoor");

		// Secret Trapdoors
		GameRegistry.registerBlock(mod_ebm.mSTDoor, "mSTDoor");
		GameRegistry.registerBlock(mod_ebm.deadSTDoor, "deadSTDoor");
		GameRegistry.registerBlock(mod_ebm.mauveSTDoor, "mauveSTDoor");

		// Pressure Plates
		GameRegistry.registerBlock(mod_ebm.mPlate, "mPlate");
		GameRegistry.registerBlock(mod_ebm.deadPlate, "deadPlate");
		GameRegistry.registerBlock(mod_ebm.mauvePlate, "mauvePlate");

		// Levers
		GameRegistry.registerBlock(mod_ebm.mLever, "mLever");
		GameRegistry.registerBlock(mod_ebm.deadLever, "deadLever");
		GameRegistry.registerBlock(mod_ebm.mauveLever, "mauveLever");

		// Buttons
		GameRegistry.registerBlock(mod_ebm.mButton, "mButton");
		GameRegistry.registerBlock(mod_ebm.deadButton, "deadButton");
		GameRegistry.registerBlock(mod_ebm.mauveButton, "mauveButton");

		// Torches
		GameRegistry.registerBlock(mod_ebm.mTorch, "mTorch");
		GameRegistry.registerBlock(mod_ebm.deadTorch, "deadTorch");
		GameRegistry.registerBlock(mod_ebm.mauveTorch, "mauveTorch");

		// Red Torches
		GameRegistry.registerBlock(mod_ebm.mTorchRed, "mTorchRed");
		GameRegistry.registerBlock(mod_ebm.deadTorchRed, "deadTorchRed");
		GameRegistry.registerBlock(mod_ebm.mauveTorchRed, "mauveTorchRed");

		// Red Torches Off
		GameRegistry.registerBlock(mod_ebm.mTorchRedOff, "mTorchRedOff");
		GameRegistry.registerBlock(mod_ebm.deadTorchRedOff, "deadTorchRedOff");
		GameRegistry.registerBlock(mod_ebm.mauveTorchRedOff, "mauveTorchRedOff");
	}
}
