package ebm.com.mce.gen.biomes;

import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.gen.biomes.dec.WorldGenGrass;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Hive extends BiomeGenBase {
	public Hive(int id, boolean spawn) {
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

		this.fillerBlock = mod_ebm.beeswax;
		this.biomeName = "Hive";
		this.waterColorMultiplier = 15313687;
		this.color = 15313687;
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		return 15313687;
	}

	public int getModdedBiomeFoliageColor(int original) {
		return 15313687;
	}

	public int getSkyColorByTemp(float f) {
		return 15313687;
	}

	public void genTerrainBlocks(World world, Random rand, Block[] block, byte[] b, int x, int z, double d) {
		if (d > 1.75D) {
			this.topBlock = mod_ebm.beeswax;
		} else if (d > -0.95D) {
			this.topBlock = mod_ebm.honeycomb;
		}

		this.genBiomeTerrain(world, rand, block, b, x, z, d);
	}

	public WorldGenerator getRandomWorldGenForGrass(Random ran) {
		return ran.nextInt(1) == 0 ? new WorldGenGrass(mod_ebm.beehive, 0) : new WorldGenGrass(mod_ebm.beehive, 0);
	}
}
