package ebm.com.mce.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EntityHelper {
	/**
	 * Return true if the armor slot is equal to the item armor.
	 * 
	 * Example: Is any armor slot a crimtic armor? If yes, don't do poison.
	 * 
	 * 0: Boots; 1: Legs; 2: Chest; 3: Helmet
	 * 
	 * @param entity
	 * @param armor
	 * @param slot
	 * @return boolean
	 */
	public static boolean isWearingArmor(EntityLivingBase entity, Item armor, int slot) {
		EntityPlayer player = (EntityPlayer) entity;
		ItemStack armorSlot = player.getCurrentArmor(slot);

		if (armorSlot != null && armorSlot.getItem() == armor)
			return true;
		else
			return false;
	}
}
