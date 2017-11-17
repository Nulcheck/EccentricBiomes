package ebm.com.mce.gen.biomes;

import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.gen.trees.WorldGenDeadTree;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DeadLand extends BiomeGenBase {
	private WorldGenerator worldGenDeadTree;
	int idfk = 1;

	public DeadLand(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_Default);
		this.setTemperatureRainfall(1f, 0f);
		this.enableRain = false;
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableMonsterList.addAll(spawnableMonsterList);
		this.theBiomeDecorator.deadBushPerChunk = 10;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = 1;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.generateLakes = false;
		this.worldGenDeadTree = new WorldGenDeadTree();

		this.topBlock = mod_ebm.deadGrass;
		this.fillerBlock = mod_ebm.deadDirt;
		this.biomeName = "Dead Land";
		this.color = 8218460;
		this.waterColorMultiplier = 8218460;
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		return 8218460;
	}

	public int getModdedBiomeFoliageColor(int color) {
		return 8218460;
	}

	public int getSkyColorByTemp(float f) {
		return 8218460;
	}

	public WorldGenAbstractTree func_150567_a(Random ran) {
		return (WorldGenAbstractTree) ((this.idfk == 1) && ran.nextInt(3) == 0
				? (this.idfk != 2 && ran.nextInt(13) != 0 ? worldGenDeadTree : worldGenDeadTree)
				: (ran.nextInt(3) == 0 ? worldGenDeadTree : worldGenDeadTree));
	}
}
