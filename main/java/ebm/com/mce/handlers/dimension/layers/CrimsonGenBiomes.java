package ebm.com.mce.handlers.dimension.layers;

import java.util.ArrayList;
import java.util.List;

import ebm.com.mce.handlers.registry.BiomeRegistry;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

public class CrimsonGenBiomes extends GenLayer {
	public static BiomeGenBase[] allowBiomes = { BiomeRegistry.CrimsonObsidian, BiomeRegistry.CrimsonPlains,
			BiomeRegistry.CrimsonForest, BiomeRegistry.CrimsonMountains };
	private List<BiomeEntry>[] biomes = new ArrayList[BiomeManager.BiomeType.values().length];

	public CrimsonGenBiomes(long seed) {
		super(seed);
	}

	public CrimsonGenBiomes(long seed, GenLayer gen) {
		super(seed);
		this.parent = gen;

		for (BiomeManager.BiomeType type : BiomeManager.BiomeType.values()) {
			com.google.common.collect.ImmutableList<BiomeEntry> biomesToAdd = BiomeManager.getBiomes(type);
			int idx = type.ordinal();

			if (biomes[idx] == null)
				biomes[idx] = new ArrayList<BiomeEntry>();
			if (biomesToAdd != null)
				biomes[idx].addAll(biomesToAdd);
		}
	}

	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);

		for (int dz = 0; dz < depth; dz++) {
			for (int dx = 0; dx < width; dx++) {
				this.initChunkSeed(dx + x, dz + z);
				dest[(dx + dz * width)] = this.allowBiomes[nextInt(this.allowBiomes.length)].biomeID;
			}
		}

		return dest;
	}
}
