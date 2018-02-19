package ebm.com.mce.armor;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CrimticArmor extends ItemArmor {
	public CrimticArmor(ArmorMaterial mat, int index, int meta) {
		super(mat, index, meta);
	}

	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (stack.getItem().equals(mod_ebm.crimticHelmet) || stack.getItem().equals(mod_ebm.crimticChest)
				|| stack.getItem().equals(mod_ebm.crimticLegs) || stack.getItem().equals(mod_ebm.crimticBoots))
			player.removePotionEffect(mod_ebm.carminicPoison.id);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
		if (stack.getItem().equals(mod_ebm.crimticHelmet) || stack.getItem().equals(mod_ebm.crimticChest)
				|| stack.getItem().equals(mod_ebm.crimticBoots))
			return "mod_ebm:textures/armor/crimtic_layer_1.png";

		if (stack.getItem().equals(mod_ebm.crimticLegs))
			return "mod_ebm:textures/armor/crimtic_layer_2.png";

		else {
			System.out.println("An error has occurred rendering armor!");
			return null;
		}
	}

	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == mod_ebm.crimticIngot;
	}
}
