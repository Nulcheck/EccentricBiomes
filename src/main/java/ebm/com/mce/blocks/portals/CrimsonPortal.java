package ebm.com.mce.blocks.portals;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.handlers.dimension.teleporters.TeleportCrimson;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CrimsonPortal extends BlockBreakable {
	public static final int[][] field_150001_a = new int[][] { new int[0], { 3, 1 }, { 2, 0 } };

	public CrimsonPortal() {
		super("mod_ebm:portal_crimson", Material.portal, false);
		this.setTickRandomly(true);
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		super.updateTick(world, x, y, z, rand);

		if (world.provider.isSurfaceWorld() && world.getGameRules().getGameRuleBooleanValue("doMobSpawning")
				&& rand.nextInt(2000) < world.difficultySetting.getDifficultyId()) {
			int l;

			for (l = y; !World.doesBlockHaveSolidTopSurface(world, x, l, z) && l > 0; --l) {
				;
			}

			if (l > 0 && !world.getBlock(x, l + 1, z).isNormalCube()) {
				Entity entity = ItemMonsterPlacer.spawnCreature(world, 57, (double) x + 0.5D, (double) l + 1.1D,
						(double) z + 0.5D);

				if (entity != null) {
					entity.timeUntilPortal = entity.getPortalCooldown();
				}
			}
		}
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int l = func_149999_b(world.getBlockMetadata(x, y, z));

		if (l == 0) {
			if (world.getBlock(x - 1, y, z) != this && world.getBlock(x + 1, y, z) != this) {
				l = 2;
			} else {
				l = 1;
			}

			if (world instanceof World && !((World) world).isRemote) {
				((World) world).setBlockMetadataWithNotify(x, y, z, l, 2);
			}
		}

		float f = 0.125F;
		float f1 = 0.125F;

		if (l == 1) {
			f = 0.5F;
		}

		if (l == 2) {
			f1 = 0.5F;
		}

		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean getPortalSize(World world, int x, int y, int z) {
		CrimsonPortal.Size size = new CrimsonPortal.Size(world, x, y, z, 1);
		CrimsonPortal.Size size1 = new CrimsonPortal.Size(world, x, y, z, 2);

		if (size.func_150860_b() && size.field_150864_e == 0) {
			size.func_150859_c();
			return true;
		} else if (size1.func_150860_b() && size1.field_150864_e == 0) {
			size1.func_150859_c();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor Block
	 */
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		int l = func_149999_b(world.getBlockMetadata(x, y, z));
		CrimsonPortal.Size size = new CrimsonPortal.Size(world, x, y, z, 1);
		CrimsonPortal.Size size1 = new CrimsonPortal.Size(world, x, y, z, 2);

		if (l == 1 && (!size.func_150860_b() || size.field_150864_e < size.field_150868_h * size.field_150862_g)) {
			world.setBlock(x, y, z, Blocks.air);
		} else if (l == 2
				&& (!size1.func_150860_b() || size1.field_150864_e < size1.field_150868_h * size1.field_150862_g)) {
			world.setBlock(x, y, z, Blocks.air);
		} else if (l == 0 && !size.func_150860_b() && !size1.func_150860_b()) {
			world.setBlock(x, y, z, Blocks.air);
		}
	}

	/**
	 * Returns true if the given side of this block type should be rendered, if
	 * the adjacent block is at the given coordinates. Args: blockAccess, x, y,
	 * z, side
	 */
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess acc, int x, int y, int z, int side) {
		int i1 = 0;

		if (acc.getBlock(x, y, z) == this) {
			i1 = func_149999_b(acc.getBlockMetadata(x, y, z));

			if (i1 == 0) {
				return false;
			}

			if (i1 == 2 && side != 5 && side != 4) {
				return false;
			}

			if (i1 == 1 && side != 3 && side != 2) {
				return false;
			}
		}

		boolean flag = acc.getBlock(x - 1, y, z) == this && acc.getBlock(x - 2, y, z) != this;
		boolean flag1 = acc.getBlock(x + 1, y, z) == this && acc.getBlock(x + 2, y, z) != this;
		boolean flag2 = acc.getBlock(x, y, z - 1) == this && acc.getBlock(x, y, z - 2) != this;
		boolean flag3 = acc.getBlock(x, y, z + 1) == this && acc.getBlock(x, y, z + 2) != this;
		boolean flag4 = flag || flag1 || i1 == 1;
		boolean flag5 = flag2 || flag3 || i1 == 2;
		return flag4 && side == 4 ? true
				: (flag4 && side == 5 ? true : (flag5 && side == 2 ? true : flag5 && side == 3));
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random rand) {
		return 0;
	}

	/**
	 * Triggered whenever an entity collides with this block (enters into the
	 * block). Args: world, x, y, z, entity
	 */
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if ((entity.ridingEntity == null) && (entity.riddenByEntity == null) && ((entity instanceof EntityPlayerMP))) {
			EntityPlayerMP thePlayer = (EntityPlayerMP) entity;
			if (thePlayer.timeUntilPortal > 0) {
				thePlayer.timeUntilPortal = 10;
			} else if (thePlayer.dimension != mod_ebm.crimsonId) {
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, mod_ebm.crimsonId,
						new TeleportCrimson(thePlayer.mcServer.worldServerForDimension(mod_ebm.crimsonId)));
			} else {
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0,
						new TeleportCrimson(thePlayer.mcServer.worldServerForDimension(0)));
			}
		}
	}

	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1
	 * for alpha
	 */
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}

	/**
	 * A randomly called display update to be able to add particles or other
	 * items for display
	 */
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		if (rand.nextInt(100) == 0) {
			world.playSound((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "portal.portal", 0.5F, 0.6F,
					false);
		}

		for (int l = 0; l < 4; ++l) {
			double d0 = (double) ((float) x + rand.nextFloat());
			double d1 = (double) ((float) y + rand.nextFloat());
			double d2 = (double) ((float) z + rand.nextFloat());
			double d3 = 1.0D;
			double d4 = 0.0D;
			double d5 = 0.0D;
			int i1 = rand.nextInt(2) * 2 - 1;
			d3 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
			d4 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
			d5 = ((double) rand.nextFloat() - 0.5D) * 0.5D;

			if (world.getBlock(x - 1, y, z) != this && world.getBlock(x + 1, y, z) != this) {
				d0 = (double) x + 0.5D + 0.25D * (double) i1;
				d3 = (double) (rand.nextFloat() * 2.0F * (float) i1);
			} else {
				d2 = (double) z + 0.5D + 0.25D * (double) i1;
				d5 = (double) (rand.nextFloat() * 2.0F * (float) i1);
			}

			world.spawnParticle("townaura", d0, d1, d2, d3, d4, d5);
		}
	}

	public static int func_149999_b(int i) {
		return i & 3;
	}

	/**
	 * Gets an item for the block being called on. Args: world, x, y, z
	 */
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemById(0);
	}

	public static class Size {
		public final World field_150867_a;
		public final int field_150865_b;
		public final int field_150866_c;
		public final int field_150863_d;
		public int field_150864_e = 0;
		public ChunkCoordinates field_150861_f;
		public int field_150862_g;
		public int field_150868_h;
		public static final String __OBFID = "CL_00000285";

		public Size(World world, int x, int y, int z, int side) {
			this.field_150867_a = world;
			this.field_150865_b = side;
			this.field_150863_d = CrimsonPortal.field_150001_a[side][0];
			this.field_150866_c = CrimsonPortal.field_150001_a[side][1];

			for (int i1 = y; y > i1 - 21 && y > 0 && this.func_150857_a(world.getBlock(x, y - 1, z)); --y) {
				;
			}

			int j1 = this.func_150853_a(x, y, z, this.field_150863_d) - 1;

			if (j1 >= 0) {
				this.field_150861_f = new ChunkCoordinates(x + j1 * Direction.offsetX[this.field_150863_d], y,
						z + j1 * Direction.offsetZ[this.field_150863_d]);
				this.field_150868_h = this.func_150853_a(this.field_150861_f.posX, this.field_150861_f.posY,
						this.field_150861_f.posZ, this.field_150866_c);

				if (this.field_150868_h < 2 || this.field_150868_h > 21) {
					this.field_150861_f = null;
					this.field_150868_h = 0;
				}
			}

			if (this.field_150861_f != null) {
				this.field_150862_g = this.func_150858_a();
			}
		}

		protected int func_150853_a(int x, int y, int z, int side) {
			int j1 = Direction.offsetX[side];
			int k1 = Direction.offsetZ[side];
			int i1;
			Block block;

			for (i1 = 0; i1 < 22; ++i1) {
				block = this.field_150867_a.getBlock(x + j1 * i1, y, z + k1 * i1);

				if (!this.func_150857_a(block)) {
					break;
				}

				Block block1 = this.field_150867_a.getBlock(x + j1 * i1, y - 1, z + k1 * i1);

				if (block1 != mod_ebm.crimsonObsidian) {
					break;
				}
			}

			block = this.field_150867_a.getBlock(x + j1 * i1, y, z + k1 * i1);
			return block == mod_ebm.crimsonObsidian ? i1 : 0;
		}

		protected int func_150858_a() {
			int i;
			int j;
			int k;
			int l;
			label56:

			for (this.field_150862_g = 0; this.field_150862_g < 21; ++this.field_150862_g) {
				i = this.field_150861_f.posY + this.field_150862_g;

				for (j = 0; j < this.field_150868_h; ++j) {
					k = this.field_150861_f.posX
							+ j * Direction.offsetX[CrimsonPortal.field_150001_a[this.field_150865_b][1]];
					l = this.field_150861_f.posZ
							+ j * Direction.offsetZ[CrimsonPortal.field_150001_a[this.field_150865_b][1]];
					Block block = this.field_150867_a.getBlock(k, i, l);

					if (!this.func_150857_a(block)) {
						break label56;
					}

					if (block == mod_ebm.crimsonPortal) {
						++this.field_150864_e;
					}

					if (j == 0) {
						block = this.field_150867_a.getBlock(
								k + Direction.offsetX[CrimsonPortal.field_150001_a[this.field_150865_b][0]], i,
								l + Direction.offsetZ[CrimsonPortal.field_150001_a[this.field_150865_b][0]]);

						if (block != mod_ebm.crimsonObsidian) {
							break label56;
						}
					} else if (j == this.field_150868_h - 1) {
						block = this.field_150867_a.getBlock(
								k + Direction.offsetX[CrimsonPortal.field_150001_a[this.field_150865_b][1]], i,
								l + Direction.offsetZ[CrimsonPortal.field_150001_a[this.field_150865_b][1]]);

						if (block != mod_ebm.crimsonObsidian) {
							break label56;
						}
					}
				}
			}

			for (i = 0; i < this.field_150868_h; ++i) {
				j = this.field_150861_f.posX
						+ i * Direction.offsetX[CrimsonPortal.field_150001_a[this.field_150865_b][1]];
				k = this.field_150861_f.posY + this.field_150862_g;
				l = this.field_150861_f.posZ
						+ i * Direction.offsetZ[CrimsonPortal.field_150001_a[this.field_150865_b][1]];

				if (this.field_150867_a.getBlock(j, k, l) != mod_ebm.crimsonObsidian) {
					this.field_150862_g = 0;
					break;
				}
			}

			if (this.field_150862_g <= 21 && this.field_150862_g >= 3) {
				return this.field_150862_g;
			} else {
				this.field_150861_f = null;
				this.field_150868_h = 0;
				this.field_150862_g = 0;
				return 0;
			}
		}

		protected boolean func_150857_a(Block block) {
			return block.getMaterial() == Material.air || block == mod_ebm.crimsonFire
					|| block == mod_ebm.crimsonPortal;
		}

		public boolean func_150860_b() {
			return this.field_150861_f != null && this.field_150868_h >= 2 && this.field_150868_h <= 21
					&& this.field_150862_g >= 3 && this.field_150862_g <= 21;
		}

		public void func_150859_c() {
			for (int i = 0; i < this.field_150868_h; ++i) {
				int j = this.field_150861_f.posX + Direction.offsetX[this.field_150866_c] * i;
				int k = this.field_150861_f.posZ + Direction.offsetZ[this.field_150866_c] * i;

				for (int l = 0; l < this.field_150862_g; ++l) {
					int i1 = this.field_150861_f.posY + l;
					this.field_150867_a.setBlock(j, i1, k, mod_ebm.crimsonPortal, this.field_150865_b, 2);
				}
			}
		}
	}
}