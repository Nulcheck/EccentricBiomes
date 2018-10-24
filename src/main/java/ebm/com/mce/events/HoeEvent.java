package ebm.com.mce.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class HoeEvent {
	@SubscribeEvent
	public void onTilled(UseHoeEvent e) {
		Block bf = mod_ebm.blueFarmland;

		if (e.world.getBlock(e.x, e.y, e.z) == mod_ebm.blueDirt) {
			e.world.setBlock(e.x, e.y, e.z, mod_ebm.blueFarmland);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.world.playSoundEffect((double) ((float) e.x + 0.5F), (double) ((float) e.y + 0.5F),
					(double) ((float) e.z + 0.5F), bf.stepSound.getStepResourcePath(),
					(bf.stepSound.getVolume() + 1.0F) / 2.0F, bf.stepSound.getPitch() * 0.8F);
			e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
		}

		else if (e.world.getBlock(e.x, e.y, e.z) == Blocks.dirt && e.entityPlayer.isSneaking()) {
			e.world.setBlock(e.x, e.y, e.z, mod_ebm.unstompableFarmland);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.world.playSoundEffect((double) ((float) e.x + 0.5F), (double) ((float) e.y + 0.5F),
					(double) ((float) e.z + 0.5F), bf.stepSound.getStepResourcePath(),
					(bf.stepSound.getVolume() + 1.0F) / 2.0F, bf.stepSound.getPitch() * 0.8F);
			e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
		}
	}
}
