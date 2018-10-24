package ebm.com.mce.gen.biomes.dimensional;

import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.handlers.dimension.biomes.CrimsonBiomes;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

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
		this.theBiomeDecorator.grassPerChunk = 1;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;

		this.topBlock = mod_ebm.crimsonGrass;
		this.fillerBlock = mod_ebm.crimsonDirt;
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
		return d0 < -0.1D ? 16735067 : 13444646;
	}

	public WorldGenerator getRandomWorldGenForGrass(Random ran) {
		return ran.nextInt(4) == 0 ? new WorldGenTallGrass(mod_ebm.crimsonBush, 0)
				: new WorldGenTallGrass(mod_ebm.crimsonTallGrass, 0);
	}
}
