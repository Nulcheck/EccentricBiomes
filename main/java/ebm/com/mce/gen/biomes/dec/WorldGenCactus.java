package ebm.com.mce.gen.biomes.dec;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCactus extends WorldGenerator {
	public Block block;
	public int meta;

	public boolean generate(World world, Random rand, int x, int y, int z) {
		for (int l = 0; l < 10; ++l) {
			int i1 = x + rand.nextInt(8) - rand.nextInt(8);
			int j1 = y + rand.nextInt(4) - rand.nextInt(4);
			int k1 = z + rand.nextInt(8) - rand.nextInt(8);

			if (world.isAirBlock(i1, j1, k1)) {
				int l1 = 1 + rand.nextInt(rand.nextInt(3) + 1);

				for (int i2 = 0; i2 < l1; ++i2) {
					if (block.canBlockStay(world, i1, j1 + i2, k1)) {
						world.setBlock(i1, j1 + i2, k1, block, meta, 2);
					}
				}
			}
		}

		return true;
	}
}