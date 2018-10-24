package ebm.com.mce.gen.biomes.dec;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSpikes extends WorldGenerator {
	public Block blockA;

	public boolean generate(World world, Random rand, int x, int y, int z) {
		while (world.isAirBlock(x, y, z) && y > 2) {
			--y;
		}

		y += rand.nextInt(4);
		int l = rand.nextInt(4) + 4;
		int i1 = l / 4 + rand.nextInt(2);

		if (i1 > 1 && rand.nextInt(10) == 0) {
			y += 2 + rand.nextInt(5);
		}

		int j1;
		int k1;
		int l1;

		for (j1 = 0; j1 < l; ++j1) {
			float f = (1.0F - (float) j1 / (float) l) * (float) i1;
			k1 = MathHelper.ceiling_float_int(f);

			for (l1 = -k1; l1 <= k1; ++l1) {
				float f1 = (float) MathHelper.abs_int(l1) - 0.25F;

				for (int i2 = -k1; i2 <= k1; ++i2) {
					float f2 = (float) MathHelper.abs_int(i2) - 0.25F;

					if ((l1 == 0 && i2 == 0 || f1 * f1 + f2 * f2 <= f * f)
							&& (l1 != -k1 && l1 != k1 && i2 != -k1 && i2 != k1 || rand.nextFloat() <= 0.75F)) {
						Block block = world.getBlock(x + l1, y + j1, z + i2);

						if (block.getMaterial() == Material.air || block == Blocks.dirt) {
							this.func_150515_a(world, x + l1, y + j1, z + i2, blockA);
						}

						if (j1 != 0 && k1 > 1) {
							block = world.getBlock(x + l1, y - j1, z + i2);

							if (block.getMaterial() == Material.air || block == Blocks.dirt) {
								this.func_150515_a(world, x + l1, y - j1, z + i2, blockA);
							}
						}
					}
				}
			}
		}

		j1 = i1 - 1;

		if (j1 < 0) {
			j1 = 0;
		} else if (j1 > 1) {
			j1 = 1;
		}

		for (int j2 = -j1; j2 <= j1; ++j2) {
			k1 = -j1;

			while (k1 <= j1) {
				l1 = y - 1;
				int k2 = 15;

				if (Math.abs(j2) == 1 && Math.abs(k1) == 1) {
					k2 = rand.nextInt(5);
				}

				while (true) {
					if (l1 > 15) {
						Block block1 = world.getBlock(x + j2, l1, z + k1);

						if (block1.getMaterial() == Material.air || block1 == Blocks.dirt || block1 == blockA) {
							this.func_150515_a(world, x + j2, l1, z + k1, blockA);
							--l1;
							--k2;

							if (k2 <= 0) {
								l1 -= rand.nextInt(5) + 1;
								k2 = rand.nextInt(5);
							}

							continue;
						}
					}

					++k1;
					break;
				}
			}
		}

		return true;

	}
}