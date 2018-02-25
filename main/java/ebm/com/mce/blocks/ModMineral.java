package ebm.com.mce.blocks;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ModMineral {
	public static class CrimticBlock extends Block {
		public CrimticBlock(Material mat) {
			super(mat);
		}

		public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
			try {
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(mod_ebm.carminicPoison.id, 120, 0, false));
				super.onEntityWalking(world, x, y, z, entity);
			} catch (Exception e) {
				System.out.println("An error has occurred trying to give entity carminic poison!");
			}
		}
	}

	public static class PyreBlock extends Block {
		public PyreBlock(Material mat) {
			super(mat);
		}

		public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
			entity.setFire(8);
		}
	}
}
