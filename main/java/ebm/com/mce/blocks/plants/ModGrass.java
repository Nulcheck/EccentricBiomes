package ebm.com.mce.blocks.plants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class ModGrass extends BlockBush implements IGrowable, IShearable {
	private static final String[] type = new String[] { "fire" };
	private IIcon[] icon;

	public ModGrass() {
		super(Material.plants);
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity e) {
		if (world.getBlock(x, y, z) == mod_ebm.fireGrass) {
			e.setFire(4);
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (meta >= this.icon.length) {
			meta = 0;
		}

		return this.icon[meta];
	}

	@SideOnly(Side.CLIENT)
	public int getBlockColor() {
		double d0 = 0.5D;
		double d1 = 1.0D;
		return ColorizerGrass.getGrassColor(d0, d1);
	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		return super.canBlockStay(world, x, y, z);
	}

	@SideOnly(Side.CLIENT)
	public int getRenderColor(int i) {
		return i == 0 ? 16777215 : ColorizerGrass.getGrassColor(0.5D, 1.0D);
	}

	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess blockacc, int x, int y, int z) {
		int l = blockacc.getBlockMetadata(x, y, z);
		return l == 0 ? 16777215 : blockacc.getBiomeGenForCoords(x, z).getBiomeGrassColor(x, y, z);
	}

	public Item getItemDropped(int i, Random rand, int j) {
		return null;
	}

	public int quantityDroppedWithBonus(int i, Random rand) {
		return 1 + rand.nextInt(i * 2 + 1);
	}

	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta) {
		super.harvestBlock(world, player, x, y, z, meta);
	}

	public int getDamageValue(World world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (int i = 1; i < 1; ++i) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iicon) {
		this.icon = new IIcon[type.length];

		for (int i = 0; i < this.icon.length; ++i) {
			this.icon[i] = iicon.registerIcon("mod_ebm:grass_" + type[i]);
		}
	}

	public boolean func_149851_a(World world, int x, int y, int z, boolean i) {
		int l = world.getBlockMetadata(x, y, z);
		return l != 0;
	}

	public boolean func_149852_a(World world, Random rand, int x, int y, int z) {
		return true;
	}

	public void func_149853_b(World world, Random rand, int x, int y, int z) {
		int l = world.getBlockMetadata(x, y, z);
		byte b0 = 2;

		if (l == 2) {
			b0 = 3;
		}

		if (Blocks.double_plant.canPlaceBlockAt(world, x, y, z)) {
			Blocks.double_plant.func_149889_c(world, x, y, z, b0, 2);
		}
	}

	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		if (world.rand.nextInt(8) != 0)
			return ret;
		// ItemStack seed = ForgeHooks.getGrassSeed(world);
		ItemStack seed = new ItemStack(mod_ebm.fireSeed);
		if (seed != null)
			ret.add(seed);
		return ret;
	}

	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
		return true;
	}

	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z)));
		return ret;
	}
}