package ebm.com.mce.gen.biomes;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class Slimy extends BiomeGenBase {
	public Slimy(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_PartiallySubmerged);
		this.setTemperatureRainfall(.5f, .3f);
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySlime.class, 1, 2, 4));
		this.theBiomeDecorator.grassPerChunk = 1;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.generateLakes = false;

		this.topBlock = Blocks.grass;
		this.fillerBlock = mod_ebm.blueDirt;
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

	/*public WorldGenerator getRandomWorldGenForGrass(Random ran) {
		return ran.nextInt(1) == 0 ? new WorldGenBeehive(mod_ebm.beehive) : new WorldGenBeehive(mod_ebm.beehive);
	}*/
}
