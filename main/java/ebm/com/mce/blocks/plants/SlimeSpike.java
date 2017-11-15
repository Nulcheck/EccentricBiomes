package ebm.com.mce.blocks.plants;

import static net.minecraftforge.common.EnumPlantType.Plains;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.entity.tile.block.TileEntitySlimeSpike;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class SlimeSpike extends BlockContainer implements IPlantable {
	public SlimeSpike(Material mat) {
		super(mat);
		this.setBlockBounds(.2f, 0f, .2f, .8f, .65f, .8f);
	}

	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntitySlimeSpike();
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(item, 1, 0)); // Green
		list.add(new ItemStack(item, 1, 1)); // Blue
	}
	
	/*public IIcon getIcon(int side, int meta) {
	    return mod_ebm.slimeSpike.getIcon(side, meta);
	}*/

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderBlockPass() {
		return -1;
	}

	public int quantityDropped(Random rand) {
		return 1 + rand.nextInt(1);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

	public Item getItemDropped(int id, Random rand, int meta) {
		return Items.slime_ball;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return super.canPlaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z);
	}

	public boolean canPlaceBlockOn(Block block) {
		return block == mod_ebm.slimyGrass || block == Blocks.grass || block == Blocks.dirt;
	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		return world.getBlock(x, y - 1, z).canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this);
	}

	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return Plains;
	}

	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return this;
	}

	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return 0;
	}
}
