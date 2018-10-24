package ebm.com.mce.gen.biomes;

import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.gen.trees.WorldGenAmethystTree;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class AmethystGrove extends BiomeGenBase {
	private WorldGenerator worldGenAmethystTree;
	int idfk = 1;

	public AmethystGrove(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_Default);
		this.setTemperatureRainfall(.5f, .8f);
		this.spawnableCreatureList.addAll(this.spawnableCreatureList);
		this.theBiomeDecorator.grassPerChunk = 4;
		this.theBiomeDecorator.mushroomsPerChunk = 3;
		this.theBiomeDecorator.treesPerChunk = 1;
		this.theBiomeDecorator.generateLakes = false;
		this.worldGenAmethystTree = new WorldGenAmethystTree(true);

		this.topBlock = mod_ebm.amethystCrust;
		this.fillerBlock = mod_ebm.amethystDirt;
		this.biomeName = "Amethyst Grove";
		this.waterColorMultiplier = 7089607;
		this.color = 7089607;
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		return 7089607;
	}

	public int getModdedBiomeFoliageColor(int original) {
		return 7089607;
	}
	
	public int getSkyColorByTemp(float f) {
		return 7089607;
	}

	public WorldGenerator getRandomWorldGenForGrass(Random ran) {
		return ran.nextInt(4) == 0 ? new WorldGenTallGrass(Blocks.tallgrass, 1)
				: new WorldGenTallGrass(Blocks.tallgrass, 1);
	}

	public WorldGenAbstractTree func_150567_a(Random ran) {
		return (WorldGenAbstractTree) ((this.idfk == 1) && ran.nextInt(3) == 0
				? (this.idfk != 2 && ran.nextInt(13) != 0 ? worldGenAmethystTree : worldGenAmethystTree)
				: (ran.nextInt(3) == 0 ? worldGenAmethystTree : worldGenAmethystTree));
	}
}
