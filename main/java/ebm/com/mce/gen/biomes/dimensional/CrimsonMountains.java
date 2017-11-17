package ebm.com.mce.gen.biomes.dimensional;

import ebm.com.mce.handlers.dimension.biomes.CrimsonBiomes;
import net.minecraft.init.Blocks;

public class CrimsonMountains extends CrimsonBiomes {
	public CrimsonMountains(int id) {
		super(id);
		this.setHeight(height_MidHills);
		this.setDisableRain();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.grassPerChunk = 2;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;

		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;
		this.biomeName = "Crimson Mountains";
		this.color = 16735067;
	}

	public int getSkyColorByTemp(float f) {
		return 16735067;
	}

	public int getModdedBiomeFoliageColor(int original) {
		return 16735067;
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		double d0 = plantNoise.func_151601_a((double) x * 0.0225D, (double) z * 0.0225D);
		return d0 < -0.1D ? 16735067 : 15877959;
	}
}
