package ebm.com.mce.effects;

import ebm.com.mce.util.DamageSources;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class CarminicPoison extends Potion {
	public static final ResourceLocation icon = new ResourceLocation("mod_ebm",
			"/textures/gui/inventory.png".substring(1));

	public CarminicPoison(int id, boolean bad, int amp) {
		super(id, bad, amp);
	}

	public Potion setIconIndex(int x, int y) {
		super.setIconIndex(x, y);
		return (Potion) this;
	}

	public int getStatusIconIndex() {
		Minecraft.getMinecraft().renderEngine.bindTexture(icon);
		return super.getStatusIconIndex();
	}

	public boolean isBadEffect() {
		return true;
	}

	public void performEffect(EntityLivingBase entity, int i) {
		entity.attackEntityFrom(DamageSources.carminicPoison, 1.5f);
	}
}
