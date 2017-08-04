package ebm.com.mce.handlers.registry;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.gen.biomes.Amethyst;
import ebm.com.mce.gen.biomes.AmethystGrove;
import ebm.com.mce.gen.biomes.Arctic;
import ebm.com.mce.gen.biomes.AutilField;
import ebm.com.mce.gen.biomes.Bone;
import ebm.com.mce.gen.biomes.DeadLand;
import ebm.com.mce.gen.biomes.DeathForest;
import ebm.com.mce.gen.biomes.Fertile;
import ebm.com.mce.gen.biomes.Flamage;
import ebm.com.mce.gen.biomes.GlassLand;
import ebm.com.mce.gen.biomes.HighLand;
import ebm.com.mce.gen.biomes.Hive;
import ebm.com.mce.gen.biomes.ObsidianForest;
import ebm.com.mce.gen.biomes.Ocher;
import ebm.com.mce.gen.biomes.ShadowHive;
import ebm.com.mce.gen.biomes.SnowyDesert;
import ebm.com.mce.gen.biomes.Void;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import sun.security.krb5.Config;
import sun.security.krb5.KrbException;

public class BiomeRegistry {
	public void main() {
		initBiome();
		try {
			registerBiome();
		} catch (KrbException e) {
			e.printStackTrace();
		}
	}

	public static BiomeGenBase HighLand;
	public static BiomeGenBase DeathForest;
	public static BiomeGenBase ObsidianForest;
	public static BiomeGenBase GlassLand;
	public static BiomeGenBase Arctic;
	public static BiomeGenBase SnowyDesert;
	public static BiomeGenBase Flamage;
	public static BiomeGenBase Void;
	public static BiomeGenBase Fertile;
	public static BiomeGenBase Bone;
	public static BiomeGenBase DeadLand;
	public static BiomeGenBase AutilField;
	public static BiomeGenBase Amethyst;
	public static BiomeGenBase AmethystGrove;
	public static BiomeGenBase Hive;
	public static BiomeGenBase Ocher;
	public static BiomeGenBase ShadowHive;

	public static void initBiome() {
		HighLand = new HighLand(mod_ebm.idHighLands, mod_ebm.spawnHighLands);
		DeathForest = new DeathForest(mod_ebm.idDeathForest, mod_ebm.spawnDeathForest);
		ObsidianForest = new ObsidianForest(mod_ebm.idObsidianForest, mod_ebm.spawnObsidianForest);
		GlassLand = new GlassLand(mod_ebm.idGlassland, mod_ebm.spawnGlassland);
		Arctic = new Arctic(mod_ebm.idArctic, mod_ebm.spawnArctic);
		SnowyDesert = new SnowyDesert(mod_ebm.idSnowyDesert, mod_ebm.spawnSnowyDesert);
		Flamage = new Flamage(mod_ebm.idFlamage, mod_ebm.spawnFlamage);
		Void = new Void(mod_ebm.idVoid, mod_ebm.spawnVoid);
		Fertile = new Fertile(mod_ebm.idFertile, mod_ebm.spawnFertile);
		Bone = new Bone(mod_ebm.idBone, mod_ebm.spawnBone);
		DeadLand = new DeadLand(mod_ebm.idDeadLand, mod_ebm.spawnDeadLand);
		AutilField = new AutilField(mod_ebm.idAutilField, mod_ebm.spawnAutilField);
		Amethyst = new Amethyst(mod_ebm.idAmethyst, mod_ebm.spawnAmethyst);
		AmethystGrove = new AmethystGrove(mod_ebm.idAmethystGrove, mod_ebm.spawnAmethystGrove);
		Hive = new Hive(mod_ebm.idHive, mod_ebm.spawnHive);
		Ocher = new Ocher(mod_ebm.idOcher, mod_ebm.spawnOcher);
		ShadowHive = new ShadowHive(mod_ebm.idShadowHive, mod_ebm.spawnShadowHive);
	}

	public static void registerBiome() throws KrbException {
		if (mod_ebm.spawnHighLands == true)
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(HighLand, 10));
		if (mod_ebm.spawnDeathForest == true)
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(DeathForest, 10));
		if (mod_ebm.spawnObsidianForest == true)
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(ObsidianForest, 10));
		if (mod_ebm.spawnArctic == true)
			BiomeManager.addBiome(BiomeType.ICY, new BiomeEntry(Arctic, 10));
		if (mod_ebm.spawnSnowyDesert == true)
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(SnowyDesert, 10));
		if (mod_ebm.spawnFlamage == true)
			BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Flamage, 10));
		if (mod_ebm.spawnVoid == true)
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Void, 10));
		if (mod_ebm.spawnFertile == true)
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Fertile, 10));
		if (mod_ebm.spawnBone == true)
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Bone, 10));
		if (mod_ebm.spawnDeadLand == true)
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(DeadLand, 10));
		if (mod_ebm.spawnAutilField == true)
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(AutilField, 10));
		if (mod_ebm.spawnAmethyst == true)
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Amethyst, 10));
		if (mod_ebm.spawnAmethystGrove == true)
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(AmethystGrove, 10));
		if (mod_ebm.spawnHive == true)
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Hive, 10));
		if (mod_ebm.spawnOcher == true)
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Ocher, 10));
		if (mod_ebm.spawnShadowHive == true){
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(ShadowHive, 100));
		}
	}
}
