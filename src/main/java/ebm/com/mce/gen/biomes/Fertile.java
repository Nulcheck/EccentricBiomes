package ebm.com.mce.gen.biomes;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class Fertile extends BiomeGenBase {
	public Fertile(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_Default);
		this.setTemperatureRainfall(.5f, .5f);
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.theBiomeDecorator.generateLakes = true;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;

		this.topBlock = mod_ebm.unstompableFarmland;
		this.fillerBlock = Blocks.dirt;
		this.biomeName = "Fertile";
	}
}
