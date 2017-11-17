package ebm.com.mce.gen.biomes.dimensional;

import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.gen.biomes.dec.WorldGenSuperSmallSpikes;
import ebm.com.mce.handlers.dimension.biomes.CrimsonBiomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class CrimsonObsidian extends CrimsonBiomes {
	public WorldGenSuperSmallSpikes genSpikes = new WorldGenSuperSmallSpikes();

	public CrimsonObsidian(int id) {
		super(id);
		this.setHeight(height_Default);
		this.setDisableRain();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.grassPerChunk = 3;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.genSpikes = new WorldGenSuperSmallSpikes();

		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;
		this.biomeName = "Crimson Obsidian Field";
		this.color = 16735067;
	}

	public int getSkyColorByTemp(float f) {
		return 16735067;
	}

	public int getModdedBiomeFoliageColor(int original) {
		return 16735067;
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		return 16735067;
	}

	public void decorate(World world, Random rand, int i, int j) {
		int k, m, n;
		this.genSpikes.blockA = mod_ebm.crimsonObsidian;

		m = i + rand.nextInt(16) + 1;
		n = j + rand.nextInt(16) + 1;

		for (k = 0; k < 3; ++k) {
			this.genSpikes.generate(world, rand, m, world.getHeightValue(m, n), n);
		}

		super.decorate(world, rand, i, j);
	}
}
