package ebm.com.mce.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockWood;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ModPlanks extends BlockWood {
	public ModPlanks() {
		super();
	}

	public static class MPlanks extends BlockWood {
		public static final String[] woodTypes = new String[] { "m" };
		@SideOnly(Side.CLIENT)
		private IIcon[] iconTex;
		private static final String __OBFID = "CL_00000335";

		public MPlanks() {
			super();
		}

		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			if (meta < 0 || meta >= this.iconTex.length) {
				meta = 0;
			}

			return this.iconTex[meta];
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister icon) {
			this.iconTex = new IIcon[woodTypes.length];

			for (int i = 0; i < this.iconTex.length; ++i) {
				this.iconTex[i] = icon.registerIcon("mod_ebm:planks_m");
			}
		}
	}

	public static class DeadPlanks extends BlockWood {
		public static final String[] woodTypes = new String[] { "dead" };
		@SideOnly(Side.CLIENT)
		private IIcon[] iconTex;
		private static final String __OBFID = "CL_00000335";

		public DeadPlanks() {
			super();
		}

		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			if (meta < 0 || meta >= this.iconTex.length) {
				meta = 0;
			}

			return this.iconTex[meta];
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister icon) {
			this.iconTex = new IIcon[woodTypes.length];

			for (int i = 0; i < this.iconTex.length; ++i) {
				this.iconTex[i] = icon.registerIcon("mod_ebm:planks_dead");
			}
		}
	}

	public static class MauvewoodPlanks extends BlockWood {
		public static final String[] woodTypes = new String[] { "mauvewood" };
		@SideOnly(Side.CLIENT)
		private IIcon[] iconTex;
		private static final String __OBFID = "CL_00000335";

		public MauvewoodPlanks() {
			super();
		}

		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			if (meta < 0 || meta >= this.iconTex.length) {
				meta = 0;
			}

			return this.iconTex[meta];
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister icon) {
			this.iconTex = new IIcon[woodTypes.length];

			for (int i = 0; i < this.iconTex.length; ++i) {
				this.iconTex[i] = icon.registerIcon("mod_ebm:planks_mauve");
			}
		}
	}
}
