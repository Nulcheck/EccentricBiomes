package ebm.com.mce.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModLogs extends BlockLog {
	public ModLogs() {
		super();
	}

	public static class GlassLog extends BlockLog {
		public String logType[] = { "glass" };

		public GlassLog() {
			super();
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public int getRenderBlockPass() {
			return 0;
		}

		public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
			return true;
		}

		public void registerBlockIcons(IIconRegister p_149651_1_) {
			this.field_150167_a = new IIcon[logType.length];
			this.field_150166_b = new IIcon[logType.length];

			for (int i = 0; i < this.field_150167_a.length; ++i) {
				this.field_150167_a[i] = p_149651_1_.registerIcon("mod_ebm:log_glass");
				this.field_150166_b[i] = p_149651_1_.registerIcon("mod_ebm:log_glass_top");
			}
		}

		public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
			return true;
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isWood(IBlockAccess world, int x, int y, int z) {
			return false;
		}
	}

	public static class BoneLog extends Block {
		public BoneLog(Material mat) {
			super(mat);
			this.setBlockBounds(.385f, 0f, .385f, .615f, 1f, .615f);
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
			return true;
		}

		public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
			return false;
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isWood(IBlockAccess world, int x, int y, int z) {
			return false;
		}

		public int quantityDropped(Random rand) {
			return 1 + rand.nextInt(3);
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			int i = rand.nextInt(10);
			if (i >= 5 && i <= 10) {
				return Items.bone;
			} else {
				return null;
			}
		}
	}

	public static class MLog extends BlockLog {
		public String logType[] = { "m" };

		public MLog() {
			super();
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public int getRenderBlockPass() {
			return 0;
		}

		public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
			return true;
		}

		public void onEntityWalking(World world, int x, int y, int z, Entity e) {
			e.attackEntityFrom(DamageSource.generic, 3);
		}

		public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity e) {
			e.attackEntityFrom(DamageSource.generic, 3);
		}

		public void registerBlockIcons(IIconRegister p_149651_1_) {
			this.field_150167_a = new IIcon[logType.length];
			this.field_150166_b = new IIcon[logType.length];

			for (int i = 0; i < this.field_150167_a.length; ++i) {
				this.field_150167_a[i] = p_149651_1_.registerIcon("mod_ebm:log_m");
				this.field_150166_b[i] = p_149651_1_.registerIcon("mod_ebm:log_m_top");
			}
		}

		public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
			return true;
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isWood(IBlockAccess world, int x, int y, int z) {
			return true;
		}
	}

	public static class DeadLog extends BlockLog {
		public String logType[] = { "dead" };

		public DeadLog() {
			super();
			this.useNeighborBrightness = true;
			// this.setBlockBounds(.15f, 0f, .15f, .85f, 1f, .85f);
		}

		public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
			//int meta = world.getBlockMetadata(x, y, z);
			boolean flag = (world.getBlockMetadata(x, y, z) & 8) != 0;
			boolean flag1 = world.getBlockMetadata(x, y, z) == 4;

			if (flag) {
				this.setBlockBounds(.15f, .15f, 0f, .85f, .85f, 1f);
			} else {
				if (flag1) {
					this.setBlockBounds(0f, .15f, .15f, 1f, .85f, .85f);
				} else {
					this.setBlockBounds(.15f, 0f, .15f, .85f, 1f, .85f);
				}
			}
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public int getRenderBlockPass() {
			return 0;
		}

		public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
			return true;
		}

		public void registerBlockIcons(IIconRegister p_149651_1_) {
			this.field_150167_a = new IIcon[logType.length];
			this.field_150166_b = new IIcon[logType.length];

			for (int i = 0; i < this.field_150167_a.length; ++i) {
				this.field_150167_a[i] = p_149651_1_.registerIcon("log_acacia");
				this.field_150166_b[i] = p_149651_1_.registerIcon("mod_ebm:log_dead_top");
			}
		}

		public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
			return false;
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isWood(IBlockAccess world, int x, int y, int z) {
			return true;
		}
	}

	public static class MauvewoodLog extends BlockLog {
		public String logType[] = { "mauvewood" };

		public MauvewoodLog() {
			super();
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public int getRenderBlockPass() {
			return 0;
		}

		public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
			return true;
		}

		public void registerBlockIcons(IIconRegister p_149651_1_) {
			this.field_150167_a = new IIcon[logType.length];
			this.field_150166_b = new IIcon[logType.length];

			for (int i = 0; i < this.field_150167_a.length; ++i) {
				this.field_150167_a[i] = p_149651_1_.registerIcon("mod_ebm:log_mauvewood");
				this.field_150166_b[i] = p_149651_1_.registerIcon("mod_ebm:log_mauvewood_top");
			}
		}

		public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
			return true;
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isWood(IBlockAccess world, int x, int y, int z) {
			return true;
		}
	}
}
