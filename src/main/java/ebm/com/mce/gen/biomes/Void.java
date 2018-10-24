package ebm.com.mce.gen.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class Void extends BiomeGenBase {
	public Void(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_LowIslands);
		this.setTemperatureRainfall(.5f, .5f);
		this.theBiomeDecorator.treesPerChunk = -999;

		this.topBlock = Blocks.air;
		this.fillerBlock = Blocks.air;
		this.biomeName = "Void";
	}
}
