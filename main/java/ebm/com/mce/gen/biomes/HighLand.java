package ebm.com.mce.gen.biomes;

import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class HighLand extends BiomeGenBase {
	public HighLand(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_Default);
		this.setTemperatureRainfall(.5f, .8f);
		this.spawnableCreatureList.addAll(this.spawnableCreatureList);
		this.theBiomeDecorator.grassPerChunk = 15;
		this.theBiomeDecorator.bigMushroomsPerChunk = 3;
		this.theBiomeDecorator.mushroomsPerChunk = 6;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.generateLakes = true;

		this.topBlock = Blocks.grass;
		this.fillerBlock = mod_ebm.blueDirt;
		this.biomeName = "High Lands";
		this.waterColorMultiplier = 8388564;
		this.color = 8388564;
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		return 8388564;
	}

	public int getModdedBiomeFoliageColor(int original) {
		return 8388564;
	}
	
	public int getSkyColorByTemp(float f) {
		return 8388564;
	}

	public WorldGenerator getRandomWorldGenForGrass(Random ran) {
		return ran.nextInt(4) == 0 ? new WorldGenTallGrass(Blocks.tallgrass, 2)
				: new WorldGenTallGrass(Blocks.tallgrass, 0);
	}
}
