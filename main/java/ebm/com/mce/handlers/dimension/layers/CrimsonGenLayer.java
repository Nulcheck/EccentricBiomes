package ebm.com.mce.handlers.dimension.layers;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class CrimsonGenLayer extends GenLayer {
	public CrimsonGenLayer(long seed) {
		super(seed);
	}

	public static GenLayer[] makeTheWorld(long seed, WorldType type) {
		GenLayer biomes = new CrimsonGenBiomes(1L);
		biomes = new GenLayerZoom(1000L, biomes);
		biomes = new GenLayerZoom(1001L, biomes);
		biomes = new GenLayerZoom(1002L, biomes);
		GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);
		biomes.initWorldGenSeed(seed);
		genlayervoronoizoom.initWorldGenSeed(seed);
		return new GenLayer[] { biomes, genlayervoronoizoom };
	}

	public int[] getInts(int i, int j, int k, int l) {
		return null;
	}
}
