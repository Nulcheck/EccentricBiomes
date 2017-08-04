package ebm.com.mce.blocks;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class ModPillar extends BlockRotatedPillar {
	public ModPillar(Material mat) {
		super(mat);
	}

	public IIcon getSideIcon(int side) {
		return null;
	}

	public static class DymusPillar extends BlockRotatedPillar {
		public String type[] = { "dymus" };

		protected IIcon[] side;
		protected IIcon[] top;

		public DymusPillar() {
			super(Material.ground);
		}

		public void registerBlockIcons(IIconRegister icon) {
			this.side = new IIcon[type.length];
			this.top = new IIcon[type.length];

			for (int i = 0; i < this.side.length; ++i) {
				this.side[i] = icon.registerIcon("mod_ebm:dymus_pillar_side");
				this.top[i] = icon.registerIcon("mod_ebm:dymus_pillar_top");
			}
		}

		protected IIcon getSideIcon(int p_150163_1_) {
			return this.side[p_150163_1_ % this.side.length];
		}

		protected IIcon getTopIcon(int p_150161_1_) {
			return this.top[p_150161_1_ % this.top.length];
		}
	}

	public static class AutilPillar extends BlockRotatedPillar {
		public String type[] = { "autil" };

		protected IIcon[] side;
		protected IIcon[] top;

		public AutilPillar() {
			super(Material.ground);
		}

		public void registerBlockIcons(IIconRegister icon) {
			this.side = new IIcon[type.length];
			this.top = new IIcon[type.length];

			for (int i = 0; i < this.side.length; ++i) {
				this.side[i] = icon.registerIcon("mod_ebm:autil_pillar_side");
				this.top[i] = icon.registerIcon("mod_ebm:autil_pillar_top");
			}
		}

		protected IIcon getSideIcon(int p_150163_1_) {
			return this.side[p_150163_1_ % this.side.length];
		}

		protected IIcon getTopIcon(int p_150161_1_) {
			return this.top[p_150161_1_ % this.top.length];
		}
	}

	public static class AmethystPillar extends BlockRotatedPillar {
		public String type[] = { "amethyst" };

		protected IIcon[] side;
		protected IIcon[] top;

		public AmethystPillar() {
			super(Material.ground);
		}

		public void registerBlockIcons(IIconRegister icon) {
			this.side = new IIcon[type.length];
			this.top = new IIcon[type.length];

			for (int i = 0; i < this.side.length; ++i) {
				this.side[i] = icon.registerIcon("mod_ebm:amethyst_pillar_side");
				this.top[i] = icon.registerIcon("mod_ebm:amethyst_pillar_top");
			}
		}

		protected IIcon getSideIcon(int p_150163_1_) {
			return this.side[p_150163_1_ % this.side.length];
		}

		protected IIcon getTopIcon(int p_150161_1_) {
			return this.top[p_150161_1_ % this.top.length];
		}
	}

	public static class BeeswaxPillar extends BlockRotatedPillar {
		public String type[] = { "beeswax" };

		protected IIcon[] side;
		protected IIcon[] top;

		public BeeswaxPillar() {
			super(Material.ground);
		}

		public void registerBlockIcons(IIconRegister icon) {
			this.side = new IIcon[type.length];
			this.top = new IIcon[type.length];

			for (int i = 0; i < this.side.length; ++i) {
				this.side[i] = icon.registerIcon("mod_ebm:beeswax_pillar_side");
				this.top[i] = icon.registerIcon("mod_ebm:beeswax_pillar_top");
			}
		}

		protected IIcon getSideIcon(int p_150163_1_) {
			return this.side[p_150163_1_ % this.side.length];
		}

		protected IIcon getTopIcon(int p_150161_1_) {
			return this.top[p_150161_1_ % this.top.length];
		}
	}
}
