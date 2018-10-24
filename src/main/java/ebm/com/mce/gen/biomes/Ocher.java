package ebm.com.mce.gen.biomes;

import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.gen.feature.WorldGenBlockBlob;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Ocher extends BiomeGenBase {
	public WorldGenBlockBlob genBlobs = new WorldGenBlockBlob(Blocks.sand, 1, 0);

	public Ocher(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_Default);
		this.setTemperatureRainfall(.5f, .8f);
		this.spawnableCreatureList.clear();
		this.theBiomeDecorator.grassPerChunk = 4;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.generateLakes = false;

		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;
		this.biomeName = "Ocher";
		this.waterColorMultiplier = 15100972;
		this.color = 15100972;
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		return 15100972;
	}

	public int getModdedBiomeFoliageColor(int original) {
		return 15100972;
	}

	public int getSkyColorByTemp(float f) {
		return 15100972;
	}

	public WorldGenerator getRandomWorldGenForGrass(Random ran) {
		return ran.nextInt(4) == 0 ? new WorldGenTallGrass(mod_ebm.fireGrass, 0)
				: new WorldGenTallGrass(mod_ebm.fireGrass, 0);
	}

	public void decorate(World world, Random rand, int i, int j) {
		int l, k, m, n;
		m = i + rand.nextInt(16) + 8;
		n = j + rand.nextInt(16) + 8;
		k = rand.nextInt(3);

		for (l = 0; l < k; ++l) {
			this.genBlobs.generate(world, rand, m, world.getHeightValue(m, n), n);
		}
		super.decorate(world, rand, i, j);
	}
}
