package ebm.com.mce.gen.biomes;

import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.gen.biomes.dec.WorldGenGrass;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ShadowHive extends BiomeGenBase {
	public ShadowHive(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_Default);
		this.setTemperatureRainfall(.5f, .3f);
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.theBiomeDecorator.grassPerChunk = 1;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.generateLakes = false;

		this.topBlock = mod_ebm.shadowHoneycomb;
		this.fillerBlock = mod_ebm.shadowHoneycomb;
		this.biomeName = "Shadow Hive";
		this.waterColorMultiplier = 0;
		this.color = 0;
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		return 0;
	}

	public int getModdedBiomeFoliageColor(int original) {
		return 0;
	}

	public int getSkyColorByTemp(float f) {
		return 0;
	}

	public WorldGenerator getRandomWorldGenForGrass(Random ran) {
		return ran.nextInt(1) == 0 ? new WorldGenGrass(mod_ebm.beehive, 0) : new WorldGenGrass(mod_ebm.beehive, 0);
	}
}
