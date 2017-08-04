package ebm.com.mce.gen.biomes;

import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Amethyst extends BiomeGenBase {
	public Amethyst(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_Default);
		this.setTemperatureRainfall(.5f, .8f);
		this.spawnableCreatureList.addAll(this.spawnableCreatureList);
		this.theBiomeDecorator.grassPerChunk = 4;
		this.theBiomeDecorator.mushroomsPerChunk = 3;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.generateLakes = false;

		this.topBlock = mod_ebm.amethystCrust;
		this.fillerBlock = mod_ebm.amethystDirt;
		this.biomeName = "Amethyst";
		this.waterColorMultiplier = 7089607;
		this.color = 7089607;
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		return 7089607;
	}

	public int getModdedBiomeFoliageColor(int original) {
		return 7089607;
	}

	public int getSkyColorByTemp(float f) {
		return 7089607;
	}

	public WorldGenerator getRandomWorldGenForGrass(Random ran) {
		return ran.nextInt(4) == 0 ? new WorldGenTallGrass(Blocks.tallgrass, 1)
				: new WorldGenTallGrass(Blocks.tallgrass, 1);
	}
}
