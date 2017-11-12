package ebm.com.mce.gen.biomes;

import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.gen.biomes.dec.WorldGenBeehive;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Slimy extends BiomeGenBase {
	public Slimy(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_PartiallySubmerged);
		this.setTemperatureRainfall(.5f, .3f);
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySlime.class, 1, 2, 4));
		this.theBiomeDecorator.grassPerChunk = 3;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.generateLakes = false;

		this.topBlock = mod_ebm.slimyGrass;
		this.fillerBlock = Blocks.dirt;
		this.biomeName = "Slimy";
		this.waterColorMultiplier = 14745518;
		this.color = 12380500;
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		return 12380500;
	}

	public int getModdedBiomeFoliageColor(int original) {
		return 12380500;
	}

	public int getSkyColorByTemp(float f) {
		return 12380500;
	}

	public WorldGenerator getRandomWorldGenForGrass(Random ran) {
		return ran.nextInt(1) == 0 ? new WorldGenBeehive(mod_ebm.slimeSpike) : new WorldGenBeehive(mod_ebm.slimeSpike);
	}
}
