package ebm.com.mce.blocks.chest;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;

import java.util.Iterator;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ebm.com.mce.entity.tile.block.chest.TileEntityDeadwoodChest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DeadwoodChest extends BlockContainer {
	private final Random rand = new Random();
	public final int meta;

	public DeadwoodChest(int meta) {
		super(Material.wood);
		this.meta = meta;
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return 22;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess blockacc, int x, int y, int z) {
		if (blockacc.getBlock(x, y, z - 1) == this) {
			this.setBlockBounds(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
		} else if (blockacc.getBlock(x, y, z + 1) == this) {
			this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
		} else if (blockacc.getBlock(x - 1, y, z) == this) {
			this.setBlockBounds(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		} else if (blockacc.getBlock(x + 1, y, z) == this) {
			this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
		} else {
			this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		}
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.blockRot(world, x, y, z);
		Block block = world.getBlock(x, y, z - 1);
		Block block1 = world.getBlock(x, y, z + 1);
		Block block2 = world.getBlock(x - 1, y, z);
		Block block3 = world.getBlock(x + 1, y, z);

		if (block == this) {
			this.blockRot(world, x, y, z - 1);
		}

		if (block1 == this) {
			this.blockRot(world, x, y, z + 1);
		}

		if (block2 == this) {
			this.blockRot(world, x - 1, y, z);
		}

		if (block3 == this) {
			this.blockRot(world, x + 1, y, z);
		}
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		Block block = world.getBlock(x, y, z - 1);
		Block block1 = world.getBlock(x, y, z + 1);
		Block block2 = world.getBlock(x - 1, y, z);
		Block block3 = world.getBlock(x + 1, y, z);
		byte b0 = 0;
		int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0) {
			b0 = 2;
		}

		if (l == 1) {
			b0 = 5;
		}

		if (l == 2) {
			b0 = 3;
		}

		if (l == 3) {
			b0 = 4;
		}

		if (block != this && block1 != this && block2 != this && block3 != this) {
			world.setBlockMetadataWithNotify(x, y, z, b0, 3);
		} else {
			if ((block == this || block1 == this) && (b0 == 4 || b0 == 5)) {
				if (block == this) {
					world.setBlockMetadataWithNotify(x, y, z - 1, b0, 3);
				} else {
					world.setBlockMetadataWithNotify(x, y, z + 1, b0, 3);
				}

				world.setBlockMetadataWithNotify(x, y, z, b0, 3);
			}

			if ((block2 == this || block3 == this) && (b0 == 2 || b0 == 3)) {
				if (block2 == this) {
					world.setBlockMetadataWithNotify(x - 1, y, z, b0, 3);
				} else {
					world.setBlockMetadataWithNotify(x + 1, y, z, b0, 3);
				}

				world.setBlockMetadataWithNotify(x, y, z, b0, 3);
			}
		}

		if (stack.hasDisplayName()) {
			((TileEntityDeadwoodChest) world.getTileEntity(x, y, z)).getName(stack.getDisplayName());
		}
	}

	public void blockRot(World world, int x, int y, int z) {
		if (!world.isRemote) {
			Block block = world.getBlock(x, y, z - 1);
			Block block1 = world.getBlock(x, y, z + 1);
			Block block2 = world.getBlock(x - 1, y, z);
			Block block3 = world.getBlock(x + 1, y, z);
			boolean flag = true;
			int l;
			Block block4;
			int i1;
			Block block5;
			boolean flag1;
			byte b0;
			int j1;

			if (block != this && block1 != this) {
				if (block2 != this && block3 != this) {
					b0 = 3;

					if (block.func_149730_j() && !block1.func_149730_j()) {
						b0 = 3;
					}

					if (block1.func_149730_j() && !block.func_149730_j()) {
						b0 = 2;
					}

					if (block2.func_149730_j() && !block3.func_149730_j()) {
						b0 = 5;
					}

					if (block3.func_149730_j() && !block2.func_149730_j()) {
						b0 = 4;
					}
				} else {
					l = block2 == this ? x - 1 : x + 1;
					block4 = world.getBlock(l, y, z - 1);
					i1 = block2 == this ? x - 1 : x + 1;
					block5 = world.getBlock(i1, y, z + 1);
					b0 = 3;
					flag1 = true;

					if (block2 == this) {
						j1 = world.getBlockMetadata(x - 1, y, z);
					} else {
						j1 = world.getBlockMetadata(x + 1, y, z);
					}

					if (j1 == 2) {
						b0 = 2;
					}

					if ((block.func_149730_j() || block4.func_149730_j()) && !block1.func_149730_j()
							&& !block5.func_149730_j()) {
						b0 = 3;
					}

					if ((block1.func_149730_j() || block5.func_149730_j()) && !block.func_149730_j()
							&& !block4.func_149730_j()) {
						b0 = 2;
					}
				}
			} else {
				l = block == this ? z - 1 : z + 1;
				block4 = world.getBlock(x - 1, y, l);
				i1 = block == this ? z - 1 : z + 1;
				block5 = world.getBlock(x + 1, y, i1);
				b0 = 5;
				flag1 = true;

				if (block == this) {
					j1 = world.getBlockMetadata(x, y, z - 1);
				} else {
					j1 = world.getBlockMetadata(x, y, z + 1);
				}

				if (j1 == 4) {
					b0 = 4;
				}

				if ((block2.func_149730_j() || block4.func_149730_j()) && !block3.func_149730_j()
						&& !block5.func_149730_j()) {
					b0 = 5;
				}

				if ((block3.func_149730_j() || block5.func_149730_j()) && !block2.func_149730_j()
						&& !block4.func_149730_j()) {
					b0 = 4;
				}
			}

			world.setBlockMetadataWithNotify(x, y, z, b0, 3);
		}
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		int l = 0;

		if (world.getBlock(x - 1, y, z) == this) {
			++l;
		}

		if (world.getBlock(x + 1, y, z) == this) {
			++l;
		}

		if (world.getBlock(x, y, z - 1) == this) {
			++l;
		}

		if (world.getBlock(x, y, z + 1) == this) {
			++l;
		}

		return l > 1 ? false
				: (this.func_149952_n(world, x - 1, y, z) ? false
						: (this.func_149952_n(world, x + 1, y, z) ? false
								: (this.func_149952_n(world, x, y, z - 1) ? false
										: !this.func_149952_n(world, x, y, z + 1))));
	}

	private boolean func_149952_n(World world, int x, int y, int z) {
		return world.getBlock(x, y, z) != this ? false
				: (world.getBlock(x - 1, y, z) == this ? true
						: (world.getBlock(x + 1, y, z) == this ? true
								: (world.getBlock(x, y, z - 1) == this ? true : world.getBlock(x, y, z + 1) == this)));
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		super.onNeighborBlockChange(world, x, y, z, block);
		TileEntityDeadwoodChest tileentitychest = (TileEntityDeadwoodChest) world.getTileEntity(x, y, z);

		if (tileentitychest != null) {
			tileentitychest.updateContainingBlockInfo();
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntityDeadwoodChest tileentitychest = (TileEntityDeadwoodChest) world.getTileEntity(x, y, z);

		if (tileentitychest != null) {
			for (int i1 = 0; i1 < tileentitychest.getSizeInventory(); ++i1) {
				ItemStack itemstack = tileentitychest.getStackInSlot(i1);

				if (itemstack != null) {
					float f = this.rand.nextFloat() * 0.8F + 0.1F;
					float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
					EntityItem entityitem;

					for (float f2 = this.rand.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world
							.spawnEntityInWorld(entityitem)) {
						int j1 = this.rand.nextInt(21) + 10;

						if (j1 > itemstack.stackSize) {
							j1 = itemstack.stackSize;
						}

						itemstack.stackSize -= j1;
						entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1),
								(double) ((float) z + f2),
								new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
						float f3 = 0.05F;
						entityitem.motionX = (double) ((float) this.rand.nextGaussian() * f3);
						entityitem.motionY = (double) ((float) this.rand.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = (double) ((float) this.rand.nextGaussian() * f3);

						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem()
									.setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
						}
					}
				}
			}

			world.func_147453_f(x, y, z, block);
		}

		super.breakBlock(world, x, y, z, block, meta);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float open,
			float close, float p_149727_9_) {
		if (world.isRemote) {
			return true;
		} else {
			IInventory iinventory = this.makeLargeChest(world, x, y, z);

			if (iinventory != null) {
				player.displayGUIChest(iinventory);
			}

			return true;
		}
	}

	public IInventory makeLargeChest(World world, int x, int y, int z) {
		Object object = (TileEntityDeadwoodChest) world.getTileEntity(x, y, z);

		if (object == null) {
			return null;
		} else if (world.isSideSolid(x, y + 1, z, DOWN)) {
			return null;
		} else if (catOnChest(world, x, y, z)) {
			return null;
		} else if (world.getBlock(x - 1, y, z) == this
				&& (world.isSideSolid(x - 1, y + 1, z, DOWN) || catOnChest(world, x - 1, y, z))) {
			return null;
		} else if (world.getBlock(x + 1, y, z) == this
				&& (world.isSideSolid(x + 1, y + 1, z, DOWN) || catOnChest(world, x + 1, y, z))) {
			return null;
		} else if (world.getBlock(x, y, z - 1) == this
				&& (world.isSideSolid(x, y + 1, z - 1, DOWN) || catOnChest(world, x, y, z - 1))) {
			return null;
		} else if (world.getBlock(x, y, z + 1) == this
				&& (world.isSideSolid(x, y + 1, z + 1, DOWN) || catOnChest(world, x, y, z + 1))) {
			return null;
		} else {
			if (world.getBlock(x - 1, y, z) == this) {
				object = new InventoryLargeChest("container.deadChestDouble",
						(TileEntityDeadwoodChest) world.getTileEntity(x - 1, y, z), (IInventory) object);
			}

			if (world.getBlock(x + 1, y, z) == this) {
				object = new InventoryLargeChest("container.deadChestDouble", (IInventory) object,
						(TileEntityDeadwoodChest) world.getTileEntity(x + 1, y, z));
			}

			if (world.getBlock(x, y, z - 1) == this) {
				object = new InventoryLargeChest("container.deadChestDouble",
						(TileEntityDeadwoodChest) world.getTileEntity(x, y, z - 1), (IInventory) object);
			}

			if (world.getBlock(x, y, z + 1) == this) {
				object = new InventoryLargeChest("container.deadChestDouble", (IInventory) object,
						(TileEntityDeadwoodChest) world.getTileEntity(x, y, z + 1));
			}

			return (IInventory) object;
		}
	}

	public TileEntity createNewTileEntity(World world, int meta) {
		// TileEntityDeadwoodChest tileentitychest = new
		// TileEntityDeadwoodChest();
		return new TileEntityDeadwoodChest();
	}

	public boolean canProvidePower() {
		return this.meta == 1;
	}

	public int isProvidingWeakPower(IBlockAccess blockacc, int x, int y, int z, int meta) {
		if (!this.canProvidePower()) {
			return 0;
		} else {
			int i1 = ((TileEntityDeadwoodChest) blockacc.getTileEntity(x, y, z)).numPlayersUsing;
			return MathHelper.clamp_int(i1, 0, 15);
		}
	}

	public int isProvidingStrongPower(IBlockAccess blockacc, int x, int y, int z, int meta) {
		return meta == 1 ? this.isProvidingWeakPower(blockacc, x, y, z, meta) : 0;
	}

	private static boolean catOnChest(World world, int x, int y, int z) {
		Iterator iterator = world.getEntitiesWithinAABB(EntityOcelot.class, AxisAlignedBB.getBoundingBox((double) x,
				(double) (y + 1), (double) z, (double) (x + 1), (double) (y + 2), (double) (z + 1))).iterator();
		EntityOcelot entityocelot;

		do {
			if (!iterator.hasNext()) {
				return false;
			}

			Entity entity = (Entity) iterator.next();
			entityocelot = (EntityOcelot) entity;
		} while (!entityocelot.isSitting());

		return true;
	}

	public boolean hasComparatorInputOverride() {
		return true;
	}

	public int getComparatorInputOverride(World world, int x, int y, int z, int p_149736_5_) {
		return Container.calcRedstoneFromInventory(this.makeLargeChest(world, x, y, z));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon("mod_ebm:planks_dead");
	}

	public void unifyAdjacentChests(World worldObj, int xCoord, int yCoord, int zCoord) {
	}
}