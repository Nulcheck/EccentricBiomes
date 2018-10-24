package ebm.com.mce.handlers.dimension.biomes;

import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.gen.biomes.dimensional.CrimsonDesert;
import ebm.com.mce.gen.biomes.dimensional.CrimsonForest;
import ebm.com.mce.gen.biomes.dimensional.CrimsonMountains;
import ebm.com.mce.gen.biomes.dimensional.CrimsonObsidian;
import ebm.com.mce.gen.biomes.dimensional.CrimsonPlains;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class CrimsonBiomes extends BiomeGenBase {
	public static BiomeGenBase crimsonObsidian;
	public static BiomeGenBase crimsonPlains;
	public static BiomeGenBase crimsonForest;
	public static BiomeGenBase crimsonMountains;
	public static BiomeGenBase crimsonDesert;

	public CrimsonBiomes(int id) {
		super(id);
	}

	static {
		crimsonObsidian = (new CrimsonObsidian(mod_ebm.idCrimsonObsidian).setBiomeName("Crimson Obsidian Field"));
		crimsonPlains = (new CrimsonPlains(mod_ebm.idCrimsonPlains).setBiomeName("Crimson Plains"));
		crimsonForest = (new CrimsonForest(mod_ebm.idCrimsonForest).setBiomeName("Crimson Forest"));
		crimsonMountains = (new CrimsonMountains(mod_ebm.idCrimsonMountains).setBiomeName("Crimson Mountains"));
		crimsonDesert = (new CrimsonDesert(mod_ebm.idCrimsonDesert).setBiomeName("Crimson Desert"));
	}

	public static void registerWithBiomeDictionary() {
		BiomeDictionary.registerBiomeType(crimsonObsidian, Type.HOT);
		BiomeDictionary.registerBiomeType(crimsonPlains, Type.HOT);
		BiomeDictionary.registerBiomeType(crimsonForest, Type.HOT);
		BiomeDictionary.registerBiomeType(crimsonMountains, Type.HOT);
		BiomeDictionary.registerBiomeType(crimsonDesert, Type.HOT);
		BiomeDictionary.registerAllBiomes();
	}

	public void genTerrainBlocks(World world, Random rand, Block[] block, byte[] b, int x, int y, double z) {
		this.genBiomeModdedTerrain(world, rand, block, b, x, y, z);
	}

	/**
	 * Replaces custom Stone to allow top/filler blocks to work in dimension.
	 * 
	 * @param world
	 * @param random
	 * @param replacableBlock
	 * @param aByte
	 * @param x
	 * @param y
	 * @param z
	 */
	public void genBiomeModdedTerrain(World world, Random rand, Block[] replacableBlock, byte[] aByte, int x,
			int y, double z) {
		Block block = this.topBlock;
		byte b0 = (byte) (this.field_150604_aj & 255);
		Block block1 = this.fillerBlock;
		int k = -1;
		int l = (int) (z / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
		int i1 = x & 15;
		int j1 = y & 15;
		int k1 = replacableBlock.length / 256;

		for (int l1 = 255; l1 >= 0; --l1) {
			int i2 = (j1 * 16 + i1) * k1 + l1;

			if (l1 <= 0 + rand.nextInt(5)) {
				replacableBlock[i2] = Blocks.bedrock;
			} else {
				Block block2 = replacableBlock[i2];

				if (block2 != null && block2.getMaterial() != Material.air) {
					if (block2 == mod_ebm.crimsonStone) {
						if (k == -1) {
							if (l <= 0) {
								block = null;
								b0 = 0;
								block1 = mod_ebm.crimsonStone;
							} else if (l1 >= 59 && l1 <= 64) {
								block = this.topBlock;
								b0 = (byte) (this.field_150604_aj & 255);
								block1 = this.fillerBlock;
							}

							if (l1 < 63 && (block == null || block.getMaterial() == Material.air)) {
								if (this.getFloatTemperature(x, l1, y) < 0.15F) {
									block = Blocks.lava; // Ice
									b0 = 0;
								} else {
									block = Blocks.lava; // Water
									b0 = 0;
								}
							}

							k = l;

							if (l1 >= 62) {
								replacableBlock[i2] = block;
								aByte[i2] = b0;
							} else if (l1 < 56 - l) {
								block = null;
								block1 = mod_ebm.crimsonStone;
								replacableBlock[i2] = Blocks.gravel; // Gravel
							} else {
								replacableBlock[i2] = block1;
							}
						}
					}
				} else {
					k = -1;
				}
			}
		}
	}
}
