package ebm.com.mce.gen.biomes;

import java.util.Random;

import ebm.com.mce.gen.trees.WorldGenGlassTree;
import net.minecraft.init.Blocks;
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

		this.topBlock = Blocks.glass;
		this.fillerBlock = Blocks.stone;
		this.worldGenGlassTree = new WorldGenGlassTree();
		this.biomeName = "Glassland";
	}

	public WorldGenAbstractTree func_150567_a(Random ran) {
		return (WorldGenAbstractTree) ((this.idfk == 1) && ran.nextInt(3) == 0
				? (this.idfk != 2 && ran.nextInt(13) != 0 ? worldGenGlassTree : worldGenGlassTree)
				: (ran.nextInt(3) == 0 ? worldGenGlassTree : worldGenGlassTree));
	}
}
