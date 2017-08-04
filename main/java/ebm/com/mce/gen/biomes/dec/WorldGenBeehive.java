package ebm.com.mce.gen.biomes.dec;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBeehive extends WorldGenerator {
	public static Block block;

	public WorldGenBeehive(Block block) {
		this.block = block;
	}

	public boolean generate(World world, Random rand, int x, int y, int z) {
		Block block;

		do {
			block = world.getBlock(x, y, z);
			if (!(block.isLeaves(world, x, y, z) || block.isAir(world, x, y, z))) {
				break;
			}
			--y;
		} while (y > 0);

		for (int l = 0; l < 128; ++l) {
			int i1 = x + rand.nextInt(8) - rand.nextInt(8);
			int j1 = y + rand.nextInt(4) - rand.nextInt(4);
			int k1 = z + rand.nextInt(8) - rand.nextInt(8);

			if (world.isAirBlock(i1, j1, k1) && this.block.canBlockStay(world, i1, j1, k1)) {
				world.setBlock(i1, j1, k1, this.block, 0, 2);
			}
		}

		return true;
	}
}