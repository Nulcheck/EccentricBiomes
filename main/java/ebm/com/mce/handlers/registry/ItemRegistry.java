package ebm.com.mce.handlers.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import ebm.com.mce.common.mod_ebm;

public class ItemRegistry {
	public static void registerItems() {
		// Sticks
		GameRegistry.registerItem(mod_ebm.mStick, "mStick");
		GameRegistry.registerItem(mod_ebm.deadStick, "deadStick");
		GameRegistry.registerItem(mod_ebm.mauveStick, "mauveStick");

		// Door Items
		GameRegistry.registerItem(mod_ebm.mDoorItem, "mDoorItem");
		GameRegistry.registerItem(mod_ebm.deadDoorItem, "deadDoorItem");
		GameRegistry.registerItem(mod_ebm.mauvewoodDoorItem, "mauveDoorItem");

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

		// Seeds
		GameRegistry.registerItem(mod_ebm.fireSeed, "FireSeed");

		// Records
		GameRegistry.registerItem(mod_ebm.cd_hskele, "cd_hskele");

		// Tools
		GameRegistry.registerItem(mod_ebm.erythonBattleAxe, "ErythonBattleAxe");
		GameRegistry.registerItem(mod_ebm.stingerSword, "stingerSword");
		GameRegistry.registerItem(mod_ebm.fireSword, "fireSword");

		GameRegistry.registerItem(mod_ebm.invsItem, "InvsItem");
	}
}
