package ebm.com.mce.blocks;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModSlabs extends BlockSlab {
	public static final String[] metas = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };
	public final boolean stack;

	public ModSlabs(boolean stack, Material mat) {
		super(stack, mat);
		this.useNeighborBrightness = true;
		this.stack = stack;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess b, int x, int y, int z) {
		if (this.stack) {
			this.setBlockBounds(0f, 0f, 0f, 1f, 1f, 1f);
		} else {
			boolean flag = (b.getBlockMetadata(x, y, z) & 8) != 0;

			boolean flagV1 = b.getBlockMetadata(x, y, z) == 1;
			boolean flagV2 = b.getBlockMetadata(x, y, z) == 2;
			boolean flagV3 = b.getBlockMetadata(x, y, z) == 3;
			boolean flagV4 = b.getBlockMetadata(x, y, z) == 4;

			if (flag) {
				this.setBlockBounds(0f, .5f, 0f, 1f, 1f, 1f);
			}

			else if (flagV1) {
				this.setBlockBounds(0f, 0f, 0f, 1f, 1f, .5f);
			}

			else if (flagV2) {
				this.setBlockBounds(.5f, 0f, 0f, 1f, 1f, 1f);
			}

			else if (flagV3) {
				this.setBlockBounds(0f, 0f, .5f, 1f, 1f, 1f);
			}

			else if (flagV4) {
				this.setBlockBounds(0f, 0f, 0f, .5f, 1f, 1f);
			}

			else {
				this.setBlockBounds(0f, 0f, 0f, 1f, .5f, 1f);
			}
		}
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public String getFullSlabName(int id) {
		if (id < 0) {
			id = 0;
		}
		return super.getUnlocalizedName() + "." + metas[id];
	}

	public static boolean isBlockSingleSlab(ModSlabs slab) {
		return slab == mod_ebm.dymusSlab || slab == mod_ebm.dymusOrnateSlab || slab == mod_ebm.dymusBrickSlab
				|| slab == mod_ebm.dymusChiselSlab || slab == mod_ebm.autilSlab || slab == mod_ebm.autilOrnateSlab
				|| slab == mod_ebm.autilBrickSlab || slab == mod_ebm.autilChiselSlab || slab == mod_ebm.unAutilBrickSlab
				|| slab == mod_ebm.boneSlab || slab == mod_ebm.beeswaxSlab || slab == mod_ebm.beeswaxOrnateSlab
				|| slab == mod_ebm.beeswaxBrickSlab || slab == mod_ebm.beeswaxChiselSlab || slab == mod_ebm.mWoodSlab
				|| slab == mod_ebm.deadWoodSlab || slab == mod_ebm.amethystSlab || slab == mod_ebm.amethystOrnateSlab
				|| slab == mod_ebm.amethystBrickSlab || slab == mod_ebm.amethystChiselSlab
				|| slab == mod_ebm.mauvewoodSlab;
	}

	public int getDamageValue(World world, int x, int y, int z) {
		return super.getDamageValue(world, x, y, z);
	}

	public Item getItem(World world, int x, int y, int z) {
		return isBlockSingleSlab(this) ? Item.getItemFromBlock(this)
				: (this == mod_ebm.dymusSlabDouble ? Item.getItemFromBlock(mod_ebm.dymusSlab)
						: (this == mod_ebm.dymusOrnateSlabDouble ? Item.getItemFromBlock(mod_ebm.dymusOrnateSlab)
								: (this == mod_ebm.dymusBrickSlabDouble ? Item.getItemFromBlock(mod_ebm.dymusBrickSlab)
										: (this == mod_ebm.autilSlabDouble ? Item.getItemFromBlock(mod_ebm.autilSlab)
												: (this == mod_ebm.autilOrnateSlabDouble
														? Item.getItemFromBlock(mod_ebm.autilOrnateSlab)
														: (this == mod_ebm.autilBrickSlabDouble
																? Item.getItemFromBlock(mod_ebm.autilBrickSlab)
																: (this == mod_ebm.unAutilBrickSlabDouble
																		? Item.getItemFromBlock(
																				mod_ebm.unAutilBrickSlab)
																		: (this == mod_ebm.mWoodSlabDouble
																				? Item.getItemFromBlock(
																						mod_ebm.mWoodSlab)
																				: (this == mod_ebm.deadWoodSlabDouble
																						? Item.getItemFromBlock(
																								mod_ebm.deadWoodSlab)
																						: (this == mod_ebm.amethystSlabDouble
																								? Item.getItemFromBlock(
																										mod_ebm.amethystSlab)
																								: (this == mod_ebm.amethystOrnateSlabDouble
																										? Item.getItemFromBlock(
																												mod_ebm.amethystOrnateSlab)
																										: (this == mod_ebm.amethystBrickSlabDouble
																												? Item.getItemFromBlock(
																														mod_ebm.amethystBrickSlab)
																												: (this == mod_ebm.mauvewoodSlabDouble
																														? Item.getItemFromBlock(
																																mod_ebm.mauvewoodSlab)
																														: (this == mod_ebm.boneSlabDouble
																																? Item.getItemFromBlock(
																																		mod_ebm.boneSlab)
																																: (this == mod_ebm.beeswaxSlabDouble
																																		? Item.getItemFromBlock(
																																				mod_ebm.beeswaxSlab)
																																		: (this == mod_ebm.beeswaxOrnateSlabDouble
																																				? Item.getItemFromBlock(
																																						mod_ebm.beeswaxOrnateSlab)
																																				: (this == mod_ebm.beeswaxBrickSlabDouble
																																						? Item.getItemFromBlock(
																																								mod_ebm.beeswaxBrickSlab)
																																						: (this == mod_ebm.beeswaxChiselSlabDouble
																																								? Item.getItemFromBlock(
																																										mod_ebm.beeswaxChiselSlab)
																																								: (this == mod_ebm.dymusChiselSlabDouble
																																										? Item.getItemFromBlock(
																																												mod_ebm.dymusChiselSlab)
																																										: (this == mod_ebm.amethystChiselSlabDouble
																																												? Item.getItemFromBlock(
																																														mod_ebm.amethystChiselSlab)
																																												: Item.getItemFromBlock(
																																														mod_ebm.dymusSlab)))))))))))))))))))));
	}

	public String func_150002_b(int i) {
		return getFullSlabName(i);
	}
}
