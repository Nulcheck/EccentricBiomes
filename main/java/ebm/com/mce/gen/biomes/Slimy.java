package ebm.com.mce.gen.biomes;

import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Slimy extends BiomeGenBase {
	public Slimy(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_PartiallySubmerged);
		this.setTemperatureRainfall(.5f, .3f);
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySlime.class, 1, 2, 4));
		this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySlime.class, 1, 2, 4));
		this.theBiomeDecorator.grassPerChunk = 3;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.generateLakes = false;

		this.topBlock = mod_ebm.slimyGrass;
		this.fillerBlock = Blocks.dirt;
		this.biomeName = "Slimy";
		this.waterColorMultiplier = 42222;
		this.color = 12380500;
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		double d0 = plantNoise.func_151601_a((double) x * 0.0225D, (double) z * 0.0225D);
		return d0 < -0.1D ? 12380500 : 42222;
	}

	public int getModdedBiomeFoliageColor(int original) {
		return 12380500;
	}

	public int getSkyColorByTemp(float f) {
		return 12380500;
	}

	public WorldGenerator getRandomWorldGenForGrass(Random ran) {
		return ran.nextInt(4) == 0 ? new WorldGenTallGrass(mod_ebm.slimeSpike, 1)
				: new WorldGenTallGrass(mod_ebm.slimeSpike, 0);
	}
}
