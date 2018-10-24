package ebm.com.mce.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.util.DamageSources;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class EffectEvent {
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent e) {
		if (e.entityLiving.isPotionActive(mod_ebm.carminicPoison) && e.entityLiving.worldObj.rand.nextInt(10) <= 2) {
			e.entityLiving.attackEntityFrom(DamageSources.carminicPoison, 1f);
		}
	}
}