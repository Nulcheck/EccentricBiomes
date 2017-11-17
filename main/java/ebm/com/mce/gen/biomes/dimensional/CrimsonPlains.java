package ebm.com.mce.gen.biomes.dimensional;

import ebm.com.mce.handlers.dimension.biomes.CrimsonBiomes;
import net.minecraft.init.Blocks;

public class CrimsonPlains extends CrimsonBiomes {
	public CrimsonPlains(int id) {
		super(id);
		this.setHeight(height_LowPlains);
		this.setDisableRain();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.grassPerChunk = 10;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;

		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;
		this.biomeName = "Crimson Plains";
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
