package ebm.com.mce.gen.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class SnowyDesert extends BiomeGenBase {
	public SnowyDesert(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_Default);
		this.setTemperatureRainfall(0f, 1f);
		this.enableSnow = true;
		this.setDisableRain();
		this.spawnableCreatureList.clear();
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.deadBushPerChunk = 2;
		this.theBiomeDecorator.reedsPerChunk = 50;
		this.theBiomeDecorator.cactiPerChunk = 10;

		this.topBlock = Blocks.sand;
		this.fillerBlock = Blocks.sand;
		this.biomeName = "Snowy Desert";
		this.waterColorMultiplier = 16421912;
		this.color = 16421912;
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		return 16421912;
	}

	public int getModdedBiomeFoliageColor(int col) {
		return 16421912;
	}
}
