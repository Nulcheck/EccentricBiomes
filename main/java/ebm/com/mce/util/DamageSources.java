package ebm.com.mce.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;

public class DamageSources {
	public static DamageSource carminicPoison = new DamageSource("carminic.poison").setDamageBypassesArmor();
	
	public static class DamageSourceCarminicPoison extends EntityDamageSourceIndirect {
		private Entity indirectEntity;

		public DamageSourceCarminicPoison(String name, Entity transmitter, Entity source) {
			super(name, transmitter, source);
			this.setDamageBypassesArmor();
			this.indirectEntity = source;
		}

		public IChatComponent getDethMessage(EntityLivingBase target) {
			String s = "death.attack" + this.damageType;
			IChatComponent ichatcomponent = this.indirectEntity == null ? this.damageSourceEntity.func_145748_c_()
					: this.indirectEntity.func_145748_c_();
			ItemStack itemstack = this.indirectEntity instanceof EntityLivingBase
					? ((EntityLivingBase) this.indirectEntity).getHeldItem() : null;
			String s1 = s + ".item";

			return itemstack != null && itemstack.hasDisplayName() && StatCollector.canTranslate(s1)
					? new ChatComponentTranslation(s1,
							new Object[] { target.func_145748_c_(), ichatcomponent, itemstack.func_151000_E() })
					: new ChatComponentTranslation(s, new Object[] { target.func_145748_c_(), ichatcomponent });
		}

		public static DamageSourceCarminicPoison causePoisonDamage(Entity source, Entity transmitter) {
			return new DamageSourceCarminicPoison("carminic.poison", transmitter, source);
		}
	}
}
