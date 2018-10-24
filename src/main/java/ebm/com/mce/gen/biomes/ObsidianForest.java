package ebm.com.mce.gen.biomes;

import java.util.Random;

import ebm.com.mce.gen.biomes.dec.WorldGenSpikes;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class ObsidianForest extends BiomeGenBase {
	public WorldGenSpikes genSpikes = new WorldGenSpikes();

	public ObsidianForest(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_Default);
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = 5;
		this.theBiomeDecorator.generateLakes = true;
		this.genSpikes = new WorldGenSpikes();

		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;
		this.biomeName = "Obsidian Forest";
		this.color = 6381921;
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		double d0 = plantNoise.func_151601_a((double) x * 0.0225D, (double) z * 0.0225D);
		return d0 < -0.1D ? 6381921 : 8681104;
	}

	public void decorate(World world, Random rand, int i, int j) {
		int k, m, n;
		this.genSpikes.blockA = Blocks.obsidian;

		m = i + rand.nextInt(16) + 8;
		n = j + rand.nextInt(16) + 8;

		for (k = 0; k < 3; ++k) {
			this.genSpikes.generate(world, rand, m, world.getHeightValue(m, n), n);
		}

		super.decorate(world, rand, i, j);
	}
	
	public int getSkyColorByTemp(float f) {
		return 8681104;
	}
}
