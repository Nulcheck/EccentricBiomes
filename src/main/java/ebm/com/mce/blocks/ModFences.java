package ebm.com.mce.blocks;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.List;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModFences {
	public static class ManchineelFence extends BlockFence {
		public ManchineelFence(String block, Material mat) {
			super(block, mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectFenceTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_ebm.deadFence && l != mod_ebm.mFence && l != mod_ebm.mauveFence
					&& l != mod_ebm.deadFenceGate && l != mod_ebm.mFenceGate && l != mod_ebm.mauveFenceGate
					/*&& (mod_ebm.idt && (l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
							&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate
							&& l != mod_IDT.JungleFenceGate && l != mod_IDT.WillowFenceGate
							&& l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall && l != mod_IDT.SnowWall
							&& l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall && l != mod_IDT.StoneWall
							&& l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall && l != mod_IDT.BrickWall
							&& l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence && l != mod_IDT.JungleFence
							&& l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence && l != mod_IDT.OakWall
							&& l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall && l != mod_IDT.JungleWall
							&& l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall && l != mod_IDT.SilkwoodWall
							&& l != mod_IDT.SilkwoodFence && l != mod_IDT.SilkwoodFenceGate && l != mod_IDT.AcaciaFence
							&& l != mod_IDT.AcaciaFenceGate && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakFence
							&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.DarkOakWall && l != mod_IDT.GelidFence
							&& l != mod_IDT.GelidFenceGate && l != mod_IDT.GelidWall))*/) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == mod_ebm.mFence || this == mod_ebm.deadFence || this == mod_ebm.mauveFence;
			}
		}
	}

	public static class DeadwoodFence extends BlockFence {
		public DeadwoodFence(String block, Material mat) {
			super(block, mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectFenceTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_ebm.deadFence && l != mod_ebm.mFence && l != mod_ebm.mauveFence
					&& l != mod_ebm.deadFenceGate && l != mod_ebm.mFenceGate && l != mod_ebm.mauveFenceGate
					/*&& (mod_ebm.idt && (l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
							&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate
							&& l != mod_IDT.JungleFenceGate && l != mod_IDT.WillowFenceGate
							&& l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall && l != mod_IDT.SnowWall
							&& l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall && l != mod_IDT.StoneWall
							&& l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall && l != mod_IDT.BrickWall
							&& l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence && l != mod_IDT.JungleFence
							&& l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence && l != mod_IDT.OakWall
							&& l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall && l != mod_IDT.JungleWall
							&& l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall && l != mod_IDT.SilkwoodWall
							&& l != mod_IDT.SilkwoodFence && l != mod_IDT.SilkwoodFenceGate && l != mod_IDT.AcaciaFence
							&& l != mod_IDT.AcaciaFenceGate && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakFence
							&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.DarkOakWall && l != mod_IDT.GelidFence
							&& l != mod_IDT.GelidFenceGate && l != mod_IDT.GelidWall))*/) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == mod_ebm.mFence || this == mod_ebm.deadFence || this == mod_ebm.mauveFence;
			}
		}
	}

	public static class MauvewoodFence extends BlockFence {
		public MauvewoodFence(String block, Material mat) {
			super(block, mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectFenceTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_ebm.deadFence && l != mod_ebm.mFence && l != mod_ebm.mauveFence
					&& l != mod_ebm.deadFenceGate && l != mod_ebm.mFenceGate && l != mod_ebm.mauveFenceGate
					/*&& (mod_ebm.idt && (l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
							&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate
							&& l != mod_IDT.JungleFenceGate && l != mod_IDT.WillowFenceGate
							&& l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall && l != mod_IDT.SnowWall
							&& l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall && l != mod_IDT.StoneWall
							&& l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall && l != mod_IDT.BrickWall
							&& l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence && l != mod_IDT.JungleFence
							&& l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence && l != mod_IDT.OakWall
							&& l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall && l != mod_IDT.JungleWall
							&& l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall && l != mod_IDT.SilkwoodWall
							&& l != mod_IDT.SilkwoodFence && l != mod_IDT.SilkwoodFenceGate && l != mod_IDT.AcaciaFence
							&& l != mod_IDT.AcaciaFenceGate && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakFence
							&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.DarkOakWall && l != mod_IDT.GelidFence
							&& l != mod_IDT.GelidFenceGate && l != mod_IDT.GelidWall))*/) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == mod_ebm.mFence || this == mod_ebm.deadFence || this == mod_ebm.mauveFence;
			}
		}
	}
}
