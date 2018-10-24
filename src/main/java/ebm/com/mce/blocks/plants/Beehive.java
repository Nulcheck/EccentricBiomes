package ebm.com.mce.blocks.plants;

import static net.minecraftforge.common.EnumPlantType.Plains;

import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.entity.tile.block.TileEntityBeehive;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class Beehive extends BlockContainer implements IPlantable {
	public Beehive(Material mat) {
		super(mat);
		this.setBlockBounds(.2f, 0f, .2f, .8f, .5f, .8f);
	}

	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBeehive();
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public int getRenderBlockPass() {
		return -1;
	}

	public int quantityDropped(Random rand) {
		return 1 + rand.nextInt(2);
	}

	public Item getItemDropped(int id, Random rand, int meta) {
		return mod_ebm.bee;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return super.canPlaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z);
	}

	public boolean canPlaceBlockOn(Block block) {
		return block == mod_ebm.honeycomb || block == mod_ebm.beeswax;
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
