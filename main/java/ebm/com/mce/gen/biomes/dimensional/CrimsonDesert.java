package ebm.com.mce.gen.biomes.dimensional;

import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.gen.biomes.dec.WorldGenCactus;
import ebm.com.mce.handlers.dimension.biomes.CrimsonBiomes;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CrimsonDesert extends CrimsonBiomes {
	public WorldGenerator deadBushGen;;

	public CrimsonDesert(int id) {
		super(id);
		this.setHeight(height_LowPlains);
		this.setDisableRain();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.deadBushPerChunk = 2;
		this.theBiomeDecorator.cactiPerChunk = 10;
		
		this.theBiomeDecorator.cactusGen = new WorldGenCactus();
		this.deadBushGen = new WorldGenDeadBush(mod_ebm.crimsonBush);
		
		this.topBlock = mod_ebm.crimsonSand;
		this.fillerBlock = mod_ebm.crimsonSand;
		this.biomeName = "Crimson Desert";
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
		return new WorldGenDeadBush(mod_ebm.crimsonBush);
	}
}
