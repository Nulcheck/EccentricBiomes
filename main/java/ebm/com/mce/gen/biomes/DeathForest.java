package ebm.com.mce.gen.biomes;

import java.util.Random;

import ebm.com.mce.gen.trees.WorldGenMTree;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DeathForest extends BiomeGenBase {
	private WorldGenerator worldGenMTree;
	int idfk = 1;

	public DeathForest(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_LowPlains);
		this.setTemperatureRainfall(.5f, .5f);
		this.spawnableMonsterList.addAll(spawnableMonsterList);
		this.spawnableMonsterList.addAll(spawnableMonsterList);
		this.spawnableMonsterList.addAll(spawnableMonsterList);
		this.spawnableMonsterList.addAll(spawnableMonsterList);
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.treesPerChunk = 15;
		this.theBiomeDecorator.grassPerChunk = 20;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = 30;
		this.worldGenMTree = new WorldGenMTree(true);

		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;
		this.biomeName = "Death Forest";
		this.waterColorMultiplier = 10383921;
		this.color = 3801090;
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		return 3801090;
	}

	public int getModdedBiomeFoliageColor(int original) {
		return 3801090;
	}
	
	public int getSkyColorByTemp(float f) {
		return 3801090;
	}

	public WorldGenAbstractTree func_150567_a(Random ran) {
		return (WorldGenAbstractTree) ((this.idfk == 1) && ran.nextInt(3) == 0
				? (this.idfk != 2 && ran.nextInt(13) != 0 ? worldGenMTree : worldGenMTree)
				: (ran.nextInt(3) == 0 ? worldGenMTree : worldGenMTree));
	}
}