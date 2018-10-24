package ebm.com.mce.blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModRedTorch {
	public static class ManchineelRedTorch extends BlockTorch {
		private boolean on;
		private static Map map = new HashMap();

		private boolean toggleState(World world, int x, int y, int z, boolean on) {
			if (!map.containsKey(world)) {
				map.put(world, new ArrayList());
			}

			List list = (List) map.get(world);

			if (on) {
				list.add(new ManchineelRedTorch.Toggle(x, y, z, world.getTotalWorldTime()));
			}

			int l = 0;

			for (int i1 = 0; i1 < list.size(); ++i1) {
				ManchineelRedTorch.Toggle toggle = (ManchineelRedTorch.Toggle) list.get(i1);

				if (toggle.x == x && toggle.y == y && toggle.z == z) {
					++l;

					if (l >= 8) {
						return true;
					}
				}
			}

			return false;
		}

		public ManchineelRedTorch(boolean on) {
			this.on = on;
			this.setTickRandomly(true);
		}

		public int tickRate(World world) {
			return 2;
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			if (world.getBlockMetadata(x, y, z) == 0) {
				super.onBlockAdded(world, x, y, z);
			}

			if (this.on) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int damage) {
			if (this.on) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public int isProvidingWeakPower(IBlockAccess blockAcc, int x, int y, int z, int power) {
			if (!this.on) {
				return 0;
			} else {
				int i1 = blockAcc.getBlockMetadata(x, y, z);
				return i1 == 5 && power == 1 ? 0
						: (i1 == 3 && power == 3 ? 0
								: (i1 == 4 && power == 2 ? 0
										: (i1 == 1 && power == 5 ? 0 : (i1 == 2 && power == 4 ? 0 : 15))));
			}
		}

		private boolean func_150110_m(World world, int x, int y, int z) {
			int l = world.getBlockMetadata(x, y, z);
			return l == 5 && world.getIndirectPowerOutput(x, y - 1, z, 0) ? true
					: (l == 3 && world.getIndirectPowerOutput(x, y, z - 1, 2) ? true
							: (l == 4 && world.getIndirectPowerOutput(x, y, z + 1, 3) ? true
									: (l == 1 && world.getIndirectPowerOutput(x - 1, y, z, 4) ? true
											: l == 2 && world.getIndirectPowerOutput(x + 1, y, z, 5))));
		}

		public void updateTick(World world, int x, int y, int z, Random rand) {
			boolean flag = this.func_150110_m(world, x, y, z);
			List list = (List) map.get(world);

			while (list != null && !list.isEmpty()
					&& world.getTotalWorldTime() - ((ManchineelRedTorch.Toggle) list.get(0)).idfk > 60L) {
				list.remove(0);
			}

			if (this.on) {
				if (flag) {
					world.setBlock(x, y, z, mod_ebm.mTorchRed, world.getBlockMetadata(x, y, z), 3);

					if (this.toggleState(world, x, y, z, true)) {
						world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
								(double) ((float) z + 0.5F), "random.fizz", 0.5F,
								2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

						for (int l = 0; l < 5; ++l) {
							double d0 = (double) x + rand.nextDouble() * 0.6D + 0.2D;
							double d1 = (double) y + rand.nextDouble() * 0.6D + 0.2D;
							double d2 = (double) z + rand.nextDouble() * 0.6D + 0.2D;
							world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			} else if (!flag && !this.toggleState(world, x, y, z, false)) {
				world.setBlock(x, y, z, mod_ebm.mTorchRedOff, world.getBlockMetadata(x, y, z), 3);
			}
		}

		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (!this.func_150108_b(world, x, y, z, block)) {
				boolean flag = this.func_150110_m(world, x, y, z);

				if (this.on && flag || !this.on && !flag) {
					world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
				}
			}
		}

		public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int power) {
			return power == 0 ? this.isProvidingWeakPower(world, x, y, z, power) : 0;
		}

		public Item getItemDropped(int id, Random rand, int damage) {
			return Item.getItemFromBlock(mod_ebm.mTorchRedOff);
		}

		public boolean canProvidePower() {
			return true;
		}

		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.on) {
				int l = world.getBlockMetadata(x, y, z);
				double d0 = (double) ((float) x + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d1 = (double) ((float) y + 0.7F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d2 = (double) ((float) z + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d3 = 0.2199999988079071D;
				double d4 = 0.27000001072883606D;

				if (l == 1) {
					world.spawnParticle("reddust", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 2) {
					world.spawnParticle("reddust", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 3) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
				} else if (l == 4) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
				} else {
					world.spawnParticle("reddust", d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_ebm.mTorchRedOff);
		}

		public boolean isAssociatedBlock(Block block) {
			return block == mod_ebm.mTorchRed || block == mod_ebm.mTorchRedOff;
		}

		static class Toggle {
			int x;
			int y;
			int z;
			long idfk;

			public Toggle(int x, int y, int z, long idfk) {
				this.x = x;
				this.y = y;
				this.z = z;
				this.idfk = idfk;
			}
		}
	}

	public static class DeadwoodRedTorch extends BlockTorch {
		private boolean on;
		private static Map map = new HashMap();

		private boolean toggleState(World world, int x, int y, int z, boolean on) {
			if (!map.containsKey(world)) {
				map.put(world, new ArrayList());
			}

			List list = (List) map.get(world);

			if (on) {
				list.add(new DeadwoodRedTorch.Toggle(x, y, z, world.getTotalWorldTime()));
			}

			int l = 0;

			for (int i1 = 0; i1 < list.size(); ++i1) {
				DeadwoodRedTorch.Toggle toggle = (DeadwoodRedTorch.Toggle) list.get(i1);

				if (toggle.x == x && toggle.y == y && toggle.z == z) {
					++l;

					if (l >= 8) {
						return true;
					}
				}
			}

			return false;
		}

		public DeadwoodRedTorch(boolean on) {
			this.on = on;
			this.setTickRandomly(true);
		}

		public int tickRate(World world) {
			return 2;
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			if (world.getBlockMetadata(x, y, z) == 0) {
				super.onBlockAdded(world, x, y, z);
			}

			if (this.on) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int damage) {
			if (this.on) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public int isProvidingWeakPower(IBlockAccess blockAcc, int x, int y, int z, int power) {
			if (!this.on) {
				return 0;
			} else {
				int i1 = blockAcc.getBlockMetadata(x, y, z);
				return i1 == 5 && power == 1 ? 0
						: (i1 == 3 && power == 3 ? 0
								: (i1 == 4 && power == 2 ? 0
										: (i1 == 1 && power == 5 ? 0 : (i1 == 2 && power == 4 ? 0 : 15))));
			}
		}

		private boolean func_150110_m(World world, int x, int y, int z) {
			int l = world.getBlockMetadata(x, y, z);
			return l == 5 && world.getIndirectPowerOutput(x, y - 1, z, 0) ? true
					: (l == 3 && world.getIndirectPowerOutput(x, y, z - 1, 2) ? true
							: (l == 4 && world.getIndirectPowerOutput(x, y, z + 1, 3) ? true
									: (l == 1 && world.getIndirectPowerOutput(x - 1, y, z, 4) ? true
											: l == 2 && world.getIndirectPowerOutput(x + 1, y, z, 5))));
		}

		public void updateTick(World world, int x, int y, int z, Random rand) {
			boolean flag = this.func_150110_m(world, x, y, z);
			List list = (List) map.get(world);

			while (list != null && !list.isEmpty()
					&& world.getTotalWorldTime() - ((DeadwoodRedTorch.Toggle) list.get(0)).idfk > 60L) {
				list.remove(0);
			}

			if (this.on) {
				if (flag) {
					world.setBlock(x, y, z, mod_ebm.deadTorchRed, world.getBlockMetadata(x, y, z), 3);

					if (this.toggleState(world, x, y, z, true)) {
						world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
								(double) ((float) z + 0.5F), "random.fizz", 0.5F,
								2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

						for (int l = 0; l < 5; ++l) {
							double d0 = (double) x + rand.nextDouble() * 0.6D + 0.2D;
							double d1 = (double) y + rand.nextDouble() * 0.6D + 0.2D;
							double d2 = (double) z + rand.nextDouble() * 0.6D + 0.2D;
							world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			} else if (!flag && !this.toggleState(world, x, y, z, false)) {
				world.setBlock(x, y, z, mod_ebm.deadTorchRedOff, world.getBlockMetadata(x, y, z), 3);
			}
		}

		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (!this.func_150108_b(world, x, y, z, block)) {
				boolean flag = this.func_150110_m(world, x, y, z);

				if (this.on && flag || !this.on && !flag) {
					world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
				}
			}
		}

		public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int power) {
			return power == 0 ? this.isProvidingWeakPower(world, x, y, z, power) : 0;
		}

		public Item getItemDropped(int id, Random rand, int damage) {
			return Item.getItemFromBlock(mod_ebm.mTorchRedOff);
		}

		public boolean canProvidePower() {
			return true;
		}

		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.on) {
				int l = world.getBlockMetadata(x, y, z);
				double d0 = (double) ((float) x + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d1 = (double) ((float) y + 0.7F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d2 = (double) ((float) z + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d3 = 0.2199999988079071D;
				double d4 = 0.27000001072883606D;

				if (l == 1) {
					world.spawnParticle("reddust", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 2) {
					world.spawnParticle("reddust", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 3) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
				} else if (l == 4) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
				} else {
					world.spawnParticle("reddust", d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_ebm.mTorchRedOff);
		}

		public boolean isAssociatedBlock(Block block) {
			return block == mod_ebm.deadTorchRed || block == mod_ebm.deadTorchRedOff;
		}

		static class Toggle {
			int x;
			int y;
			int z;
			long idfk;

			public Toggle(int x, int y, int z, long idfk) {
				this.x = x;
				this.y = y;
				this.z = z;
				this.idfk = idfk;
			}
		}
	}

	public static class MauvewoodRedTorch extends BlockTorch {
		private boolean on;
		private static Map map = new HashMap();

		private boolean toggleState(World world, int x, int y, int z, boolean on) {
			if (!map.containsKey(world)) {
				map.put(world, new ArrayList());
			}

			List list = (List) map.get(world);

			if (on) {
				list.add(new MauvewoodRedTorch.Toggle(x, y, z, world.getTotalWorldTime()));
			}

			int l = 0;

			for (int i1 = 0; i1 < list.size(); ++i1) {
				MauvewoodRedTorch.Toggle toggle = (MauvewoodRedTorch.Toggle) list.get(i1);

				if (toggle.x == x && toggle.y == y && toggle.z == z) {
					++l;

					if (l >= 8) {
						return true;
					}
				}
			}

			return false;
		}

		public MauvewoodRedTorch(boolean on) {
			this.on = on;
			this.setTickRandomly(true);
		}

		public int tickRate(World world) {
			return 2;
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			if (world.getBlockMetadata(x, y, z) == 0) {
				super.onBlockAdded(world, x, y, z);
			}

			if (this.on) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int damage) {
			if (this.on) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public int isProvidingWeakPower(IBlockAccess blockAcc, int x, int y, int z, int power) {
			if (!this.on) {
				return 0;
			} else {
				int i1 = blockAcc.getBlockMetadata(x, y, z);
				return i1 == 5 && power == 1 ? 0
						: (i1 == 3 && power == 3 ? 0
								: (i1 == 4 && power == 2 ? 0
										: (i1 == 1 && power == 5 ? 0 : (i1 == 2 && power == 4 ? 0 : 15))));
			}
		}

		private boolean func_150110_m(World world, int x, int y, int z) {
			int l = world.getBlockMetadata(x, y, z);
			return l == 5 && world.getIndirectPowerOutput(x, y - 1, z, 0) ? true
					: (l == 3 && world.getIndirectPowerOutput(x, y, z - 1, 2) ? true
							: (l == 4 && world.getIndirectPowerOutput(x, y, z + 1, 3) ? true
									: (l == 1 && world.getIndirectPowerOutput(x - 1, y, z, 4) ? true
											: l == 2 && world.getIndirectPowerOutput(x + 1, y, z, 5))));
		}

		public void updateTick(World world, int x, int y, int z, Random rand) {
			boolean flag = this.func_150110_m(world, x, y, z);
			List list = (List) map.get(world);

			while (list != null && !list.isEmpty()
					&& world.getTotalWorldTime() - ((MauvewoodRedTorch.Toggle) list.get(0)).idfk > 60L) {
				list.remove(0);
			}

			if (this.on) {
				if (flag) {
					world.setBlock(x, y, z, mod_ebm.mauveTorchRed, world.getBlockMetadata(x, y, z), 3);

					if (this.toggleState(world, x, y, z, true)) {
						world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
								(double) ((float) z + 0.5F), "random.fizz", 0.5F,
								2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

						for (int l = 0; l < 5; ++l) {
							double d0 = (double) x + rand.nextDouble() * 0.6D + 0.2D;
							double d1 = (double) y + rand.nextDouble() * 0.6D + 0.2D;
							double d2 = (double) z + rand.nextDouble() * 0.6D + 0.2D;
							world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			} else if (!flag && !this.toggleState(world, x, y, z, false)) {
				world.setBlock(x, y, z, mod_ebm.mauveTorchRedOff, world.getBlockMetadata(x, y, z), 3);
			}
		}

		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (!this.func_150108_b(world, x, y, z, block)) {
				boolean flag = this.func_150110_m(world, x, y, z);

				if (this.on && flag || !this.on && !flag) {
					world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
				}
			}
		}

		public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int power) {
			return power == 0 ? this.isProvidingWeakPower(world, x, y, z, power) : 0;
		}

		public Item getItemDropped(int id, Random rand, int damage) {
			return Item.getItemFromBlock(mod_ebm.mTorchRedOff);
		}

		public boolean canProvidePower() {
			return true;
		}

		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.on) {
				int l = world.getBlockMetadata(x, y, z);
				double d0 = (double) ((float) x + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d1 = (double) ((float) y + 0.7F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d2 = (double) ((float) z + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d3 = 0.2199999988079071D;
				double d4 = 0.27000001072883606D;

				if (l == 1) {
					world.spawnParticle("reddust", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 2) {
					world.spawnParticle("reddust", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 3) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
				} else if (l == 4) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
				} else {
					world.spawnParticle("reddust", d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_ebm.mTorchRedOff);
		}

		public boolean isAssociatedBlock(Block block) {
			return block == mod_ebm.mauveTorchRed || block == mod_ebm.mauveTorchRedOff;
		}

		static class Toggle {
			int x;
			int y;
			int z;
			long idfk;

			public Toggle(int x, int y, int z, long idfk) {
				this.x = x;
				this.y = y;
				this.z = z;
				this.idfk = idfk;
			}
		}
	}
}
