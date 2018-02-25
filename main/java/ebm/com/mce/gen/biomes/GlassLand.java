package ebm.com.mce.gen.biomes;

import java.util.Random;

import ebm.com.mce.gen.trees.WorldGenGlassTree;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GlassLand extends BiomeGenBase {
	private WorldGenerator worldGenGlassTree;
	int idfk = 1;

	public GlassLand(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_Default);
		this.setTemperatureRainfall(.6f, 0);
		this.theBiomeDecorator.treesPerChunk = 5;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.worldGenGlassTree = new WorldGenGlassTree(true);
		this.biomeName = "Glassland";
		
		this.fillerBlock = Blocks.glass;
	}

	public void genTerrainBlocks(World world, Random rand, Block[] block, byte[] b, int x, int z, double d) {
		if (d > rand.nextDouble() + 1d) {
			this.topBlock = Blocks.stained_glass;
			this.field_150604_aj = rand.nextInt(15);
		} else if (d > -rand.nextDouble() - 0.95d) {
			this.topBlock = Blocks.glass;
		}

		this.genBiomeTerrain(world, rand, block, b, x, z, d);
	}

	public WorldGenAbstractTree func_150567_a(Random ran) {
		return (WorldGenAbstractTree) ((this.idfk == 1) && ran.nextInt(3) == 0
				? (this.idfk != 2 && ran.nextInt(13) != 0 ? worldGenGlassTree : worldGenGlassTree)
				: (ran.nextInt(3) == 0 ? worldGenGlassTree : worldGenGlassTree));
	}
}
