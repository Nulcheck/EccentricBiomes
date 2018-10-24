package ebm.com.mce.items;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class FireSeeds extends Item implements IPlantable {
	private Block block;
	private Block soilBlock;

	public FireSeeds(Block block, Block soilBlock) {
		super();
		this.block = block;
		this.soilBlock = soilBlock;
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float fx,
			float fy, float fz) {
		if (meta != 1) {
			return false;
		} else if (player.canPlayerEdit(x, y, z, meta, stack) && player.canPlayerEdit(x, y + 1, z, meta, stack)) {
			if (world.getBlock(x, y, z).canSustainPlant(world, x, y, z, ForgeDirection.UP, this)
					&& world.isAirBlock(x, y + 1, z) && world.getBlock(x, y, z) == mod_ebm.flameStone) {
				world.setBlock(x, y + 1, z, mod_ebm.pyreFlower);
				--stack.stackSize;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return block == mod_ebm.pyreFlower ? EnumPlantType.Crop : EnumPlantType.Crop;
	}

	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return block;
	}
	
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z){
		return 0;
	}
}
