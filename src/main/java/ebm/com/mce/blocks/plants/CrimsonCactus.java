package ebm.com.mce.blocks.plants;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class CrimsonCactus extends BlockCactus {
	private IIcon top;
	private IIcon bottom;

	public CrimsonCactus() {
		super();
		this.setTickRandomly(true);
	}

	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction,
			IPlantable plantable) {
		Block plant = plantable.getPlant(world, x, y + 1, z);

		if (plant == mod_ebm.crimsonCactus && this == mod_ebm.crimsonCactus) {
			return true;
		}
		return false;
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		try {
			if (entity instanceof EntityLivingBase) {
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(mod_ebm.carminicPoison.id, 120, 0, false));
				super.onEntityCollidedWithBlock(world, x, y, z, entity);
			}
		} catch (Exception e) {
			System.out.println("An error has occurred trying to give entity carminic poison!");
		}

		entity.attackEntityFrom(DamageSource.cactus, 1.0F);
	}

	public IIcon getIcon(int side, int meta) {
		return side == 1 ? this.top : (side == 0 ? this.bottom : this.blockIcon);
	}

	public void registerBlockIcons(IIconRegister iicon) {
		this.blockIcon = iicon.registerIcon("mod_ebm:crimson_cactus_side");
		this.top = iicon.registerIcon("mod_ebm:crimson_cactus_top");
		this.bottom = iicon.registerIcon("mod_ebm:crimson_cactus_bottom");
	}

	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Desert;
	}

	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return this;
	}

	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return -1;
	}
}
