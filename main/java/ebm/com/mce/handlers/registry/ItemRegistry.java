package ebm.com.mce.handlers.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import ebm.com.mce.common.mod_ebm;

public class ItemRegistry {
	public static void registerItems() {
		// Other
		GameRegistry.registerItem(mod_ebm.ebmWrench, "EBMWrench");
		GameRegistry.registerItem(mod_ebm.dymusPowder, "DymusPowder");
		GameRegistry.registerItem(mod_ebm.dymusBar, "DymusBar");
		GameRegistry.registerItem(mod_ebm.glassShard, "GlassShard");
		GameRegistry.registerItem(mod_ebm.dust, "Dust");
		GameRegistry.registerItem(mod_ebm.autil, "Autil");
		GameRegistry.registerItem(mod_ebm.erythonCube, "ECube");
		GameRegistry.registerItem(mod_ebm.amethystGrit, "amethystGrit");
		GameRegistry.registerItem(mod_ebm.honey, "honey");
		GameRegistry.registerItem(mod_ebm.crystalHoney, "crystalHoney");
		GameRegistry.registerItem(mod_ebm.bee, "bee");
		GameRegistry.registerItem(mod_ebm.stinger, "stinger");
		GameRegistry.registerItem(mod_ebm.pyreCrystal, "pyreCrystal");
		GameRegistry.registerItem(mod_ebm.bloodBone, "bloodBone");

		// Ingots
		GameRegistry.registerItem(mod_ebm.crimticIngot, "crimticIngot");
		GameRegistry.registerItem(mod_ebm.pyreIngot, "pyreIngot");

		// Nuggets
		GameRegistry.registerItem(mod_ebm.crimticNugget, "crimticNugget");

		// Dusts
		GameRegistry.registerItem(mod_ebm.crimticDust, "crimticDust");

		// Sticks
		GameRegistry.registerItem(mod_ebm.mStick, "mStick");
		GameRegistry.registerItem(mod_ebm.deadStick, "deadStick");
		GameRegistry.registerItem(mod_ebm.mauveStick, "mauveStick");

		// Door Items
		GameRegistry.registerItem(mod_ebm.mDoorItem, "mDoorItem");
		GameRegistry.registerItem(mod_ebm.deadDoorItem, "deadDoorItem");
		GameRegistry.registerItem(mod_ebm.mauvewoodDoorItem, "mauveDoorItem");

		// Seeds
		GameRegistry.registerItem(mod_ebm.fireSeed, "FireSeed");

		// Records
		GameRegistry.registerItem(mod_ebm.cd_hskele, "cd_hskele");

		// Tools
		GameRegistry.registerItem(mod_ebm.erythonBattleAxe, "ErythonBattleAxe");
		GameRegistry.registerItem(mod_ebm.stingerSword, "stingerSword");
		GameRegistry.registerItem(mod_ebm.fireSword, "fireSword");

		// Crimtic
		GameRegistry.registerItem(mod_ebm.crimticPick, "crimticPick");
		GameRegistry.registerItem(mod_ebm.crimticShovel, "cimticShovel");
		GameRegistry.registerItem(mod_ebm.crimticAxe, "cimticAxe");
		GameRegistry.registerItem(mod_ebm.crimticSword, "cimticSword");
		GameRegistry.registerItem(mod_ebm.crimticHoe, "cimticHoe");

		// Armor
		GameRegistry.registerItem(mod_ebm.crimticHelmet, "crimticHelmet");
		GameRegistry.registerItem(mod_ebm.crimticChest, "crimticChest");
		GameRegistry.registerItem(mod_ebm.crimticLegs, "crimticLegs");
		GameRegistry.registerItem(mod_ebm.crimticBoots, "crimticBoots");

		GameRegistry.registerItem(mod_ebm.invsItem, "InvsItem");
	}
}
