package ebm.com.mce.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import ebm.com.mce.handlers.registry.AchRegistry;
import net.minecraft.util.MathHelper;

public class AchievementHandler {
	// Biome achievements
	public static String highLands = "High Lands";
	public static String deathForest = "Death Forest";
	public static String obsidianForest = "Obsidian Forest";
	public static String glassLand = "Glassland";
	public static String arctic = "Arctic";
	public static String snowyDesert = "Snowy Desert";
	public static String flamage = "Flamage";
	public static String Void = "Void";
	public static String fertile = "Fertile";
	public static String bone = "Bone";
	public static String deadLand = "Dead Land";
	public static String autilField = "Autil Field";
	public static String amethyst = "Amethyst";
	public static String amethystGrove = "Amethyst Grove";
	public static String hive = "Hive";
	public static String ocher = "Ocher";
	public static String shadowHive = "Shadow Hive";

	@SubscribeEvent
	public void biomeAchievements(PlayerTickEvent e) {
		int px = MathHelper.floor_double(e.player.posX);
		int pz = MathHelper.floor_double(e.player.posZ);

		if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == highLands) {
			e.player.addStat(AchRegistry.highLands, 1);
		}

		else if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == deathForest) {
			e.player.addStat(AchRegistry.deathForest, 1);
		}

		else if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == obsidianForest) {
			e.player.addStat(AchRegistry.obsidianForest, 1);
		}

		else if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == glassLand) {
			e.player.addStat(AchRegistry.glassLand, 1);
		}

		else if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == arctic) {
			e.player.addStat(AchRegistry.arctic, 1);
		}

		else if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == snowyDesert) {
			e.player.addStat(AchRegistry.snowyDesert, 1);
		}

		else if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == flamage) {
			e.player.addStat(AchRegistry.flamage, 1);
		}

		else if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == Void) {
			e.player.addStat(AchRegistry.Void, 1);
		}

		else if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == fertile) {
			e.player.addStat(AchRegistry.fertile, 1);
		}

		else if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == bone) {
			e.player.addStat(AchRegistry.bone, 1);
		}

		else if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == deadLand) {
			e.player.addStat(AchRegistry.deadLand, 1);
		}

		else if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == autilField) {
			e.player.addStat(AchRegistry.autilField, 1);
		}

		else if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == amethyst) {
			e.player.addStat(AchRegistry.amethyst, 1);
		}

		else if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == amethystGrove) {
			e.player.addStat(AchRegistry.amethystGrove, 1);
		}

		else if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == hive) {
			e.player.addStat(AchRegistry.hive, 1);
		}

		else if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == ocher) {
			e.player.addStat(AchRegistry.ocher, 1);
		}

		else if (e.player.worldObj.getBiomeGenForCoords(px, pz).biomeName == shadowHive) {
			e.player.addStat(AchRegistry.shadowHive, 1);
		}
	}
}
