package ebm.com.mce.util;

import net.minecraft.util.DamageSource;

public class DamageSources extends DamageSource {
	public static DamageSources carminicPoison = (new DamageSources("carminicPoison")).setDamageBypassesArmor();

	private boolean isUnblockable;
	private float hungerDamage = 0.3f;

	public DamageSources(String name) {
		super(name);
	}

	public DamageSources setDamageBypassesArmor() {
		this.isUnblockable = true;
		this.hungerDamage = 0f;
		return this;
	}
}
