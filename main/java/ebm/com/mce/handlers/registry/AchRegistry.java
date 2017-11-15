package ebm.com.mce.handlers.registry;

import cpw.mods.fml.common.registry.LanguageRegistry;
import ebm.com.mce.common.mod_ebm;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class AchRegistry {
	public static Achievement highLands;
	public static Achievement deathForest;
	public static Achievement obsidianForest;
	public static Achievement glassLand;
	public static Achievement arctic;
	public static Achievement snowyDesert;
	public static Achievement flamage;
	public static Achievement Void;
	public static Achievement fertile;
	public static Achievement bone;
	public static Achievement deadLand;
	public static Achievement autilField;
	public static Achievement amethyst;
	public static Achievement amethystGrove;
	public static Achievement hive;
	public static Achievement ocher;
	public static Achievement shadowHive;
	public static Achievement slimy;

	public static AchievementPage modPage;

	public static void registerAch() {
		// 1st # is horz, 2nd # is vert
		highLands = new Achievement("achievement.highLands", "highLands", -10, 0,
				Item.getItemFromBlock(mod_ebm.blueDirt), null).registerStat();

		deathForest = new Achievement("achievement.deathForest", "deathForest", -9, 0,
				Item.getItemFromBlock(Blocks.tallgrass), null).registerStat();

		obsidianForest = new Achievement("achievement.obsidianForest", "obsidianForest", -8, 0,
				Item.getItemFromBlock(Blocks.obsidian), null).registerStat();

		glassLand = new Achievement("achievement.glassLand", "glassLand", -7, 0, Item.getItemFromBlock(Blocks.glass),
				null).registerStat();

		arctic = new Achievement("achievement.arctic", "arctic", -6, 0, Item.getItemFromBlock(Blocks.packed_ice), null)
				.registerStat();

		snowyDesert = new Achievement("achievement.snowyDesert", "snowyDesert", -5, 0,
				Item.getItemFromBlock(Blocks.snow_layer), null).registerStat();

		flamage = new Achievement("achievement.flamage", "flamage", -4, 0, Item.getItemFromBlock(mod_ebm.flameStone),
				null).registerStat();

		Void = new Achievement("achievement.Void", "Void", -3, 0, mod_ebm.invsItem, null).registerStat();

		fertile = new Achievement("achievement.fertile", "fertile", -2, 0,
				Item.getItemFromBlock(mod_ebm.unstompableFarmland), null).registerStat();

		bone = new Achievement("achievement.bone", "bone", -1, 0, Item.getItemFromBlock(mod_ebm.boneBlock), null)
				.registerStat();

		deadLand = new Achievement("achievement.deadLand", "deadLand", 0, 0, Item.getItemFromBlock(mod_ebm.deadGrass),
				null).registerStat();

		autilField = new Achievement("achievement.autilField", "autilField", 1, 0,
				Item.getItemFromBlock(mod_ebm.autilBlock), null).registerStat();

		amethyst = new Achievement("achievement.amethyst", "amethyst", 2, 0,
				Item.getItemFromBlock(mod_ebm.amethystCrust), null).registerStat();

		amethystGrove = new Achievement("achievement.amethystGrove", "amethystGrove", 3, 0,
				Item.getItemFromBlock(mod_ebm.mauvewoodLog), null).registerStat();

		hive = new Achievement("achievement.hive", "hive", 4, 0, Item.getItemFromBlock(mod_ebm.honeycomb), null)
				.registerStat();

		ocher = new Achievement("achievement.ocher", "ocher", 5, 0, new ItemStack(Blocks.sand, 1, 1), null)
				.registerStat();

		shadowHive = new Achievement("achievement.shadowHive", "shadowHive", 6, 0,
				new ItemStack(mod_ebm.shadowHoneycomb), null).registerStat();

		slimy = new Achievement("achievement.slimy", "slimy", 7, 0, Item.getItemFromBlock(mod_ebm.slimeSpike), null)
				.registerStat();

		modPage = new AchievementPage("\u00A75Eccentric Biomes", highLands, deathForest, obsidianForest, glassLand,
				arctic, snowyDesert, flamage, Void, fertile, bone, deadLand, autilField, amethyst, amethystGrove, hive,
				ocher, shadowHive, slimy);
		AchievementPage.registerAchievementPage(modPage);
	}

	public static void addName(String ach, String lang, String name) {
		LanguageRegistry.instance().addStringLocalization("achievement." + ach, lang, name);
	}

	public static void addDesc(String ach, String lang, String desc) {
		LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", lang, desc);
	}

	public static void nameAch() {
		// Achievements
		addName("highLands", "en_US", "Super High Lands");
		addDesc("highLands", "en_US", "Just how high are you..?");

		addName("deathForest", "en_US", "Death Forest");
		addDesc("deathForest", "en_US", "So much red.. I wonder why.");

		addName("obsidianForest", "en_US", "Obsidian Forest");
		addDesc("obsidianForest", "en_US", "How did that obsidian get there?");

		addName("glassLand", "en_US", "Glassland");
		addDesc("glassLand", "en_US", "Watch out for broken glass!");

		addName("arctic", "en_US", "Arctic");
		addDesc("arctic", "en_US", "So.. Cold..");

		addName("snowyDesert", "en_US", "Snowy Desert");
		addDesc("snowyDesert", "en_US", "Wait, how?");

		addName("flamage", "en_US", "Flame On!");
		addDesc("flamage", "en_US", "Hell in the Overworld. Great.");

		addName("Void", "en_US", "Void");
		addDesc("Void", "en_US", "Where's the grass?");

		addName("fertile", "en_US", "Fertile");
		addDesc("fertile", "en_US", "Make farms everywhere!!");

		addName("bone", "en_US", "Mr. Bones");
		addDesc("bone", "en_US", "Quite a wild ride.");

		addName("deadLand", "en_US", "Dead Land");
		addDesc("deadLand", "en_US", "Quite dead.");

		addName("autilField", "en_US", "Autil Field");
		addDesc("autilField", "en_US", "I don't even know..");

		addName("amethyst", "en_US", "Amethyst Lands");
		addDesc("amethyst", "en_US", "Legend says there's lands made of amethyst. Not true.");

		addName("amethystGrove", "en_US", "Purple Wood!");
		addDesc("amethystGrove", "en_US", "Wait, not \"Amethyst Wood\" or something?");

		addName("hive", "en_US", "Buzz Off");
		addDesc("hive", "en_US", "Ouch, that stings!");

		addName("ocher", "en_US", "Orange!");
		addDesc("ocher", "en_US", "You're an apple!");

		addName("shadowHive", "en_US", "Black Bees?");
		addDesc("shadowHive", "en_US", "So dark, how do they see?");
		
		addName("slimy", "en_US", "Slime!");
		addDesc("slimy", "en_US", "Ew, it's slippery here.");
	}
}
