package ebm.com.mce.blocks.crops;

import java.util.ArrayList;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.BlockPotato;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class PyreFlower extends BlockPotato {
	private IIcon[] iconArray;

	public PyreFlower() {
		super();
		float f = 0.3F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
	}

	@SideOnly(Side.CLIENT)
	public IIcon func_71858_a(int side, int meta) {
		if (meta < 7) {
			if (meta == 6) {
				meta = 5;
			}
			return this.iconArray[(meta >> 1)];
		} else {
			return this.iconArray[3];
		}
	}

	public int getRenderType() {
		return 1;
	}

	protected boolean canPlaceBlockOn(Block block) {
		if (block == mod_ebm.flameStone)
			return true;
		else
			return false;
	}

	protected Item func_149866_i() {
		return mod_ebm.fireSeed;
	}

	protected Item func_149865_P() {
		return mod_ebm.pyreCrystal;
	}

	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortune);
		if (metadata >= 7 && world.rand.nextInt(50) == 0)
			ret.add(new ItemStack(mod_ebm.pyreCrystal));
		return ret;
	}

	public void texture(IIconRegister reg) {
		this.iconArray = new IIcon[4];
		for (int i = 0; i < this.iconArray.length; i++) {
			this.iconArray[i] = reg.registerIcon("mod_ebm:flower_pyre_stage_" + i);
		}
	}

	public void fertilize(World world, int x, int y, int z) {
	}
}
