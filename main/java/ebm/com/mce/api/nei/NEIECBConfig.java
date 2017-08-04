package ebm.com.mce.api.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Optional;
import ebm.com.mce.common.mod_ebm;
import net.minecraft.item.ItemStack;

/**
 * This class hides things from the NEI sidebar thing.
 */

@Optional.Interface(iface = "codechicken.nei.api.API", modid = "NotEnoughItems")
public class NEIECBConfig implements IConfigureNEI {
	@Optional.Method(modid = "NotEnoughItems")
	public String getName() {
		return "ECB NEI Plugin";
	}

	@Optional.Method(modid = "NotEnoughItems")
	public String getVersion() {
		return mod_ebm.class.getAnnotation(Mod.class).version();
	}

	@Optional.Method(modid = "NotEnoughItems")
	public void loadConfig() {
		API.hideItem(new ItemStack(mod_ebm.mDoor));
		API.hideItem(new ItemStack(mod_ebm.deadDoor));
		API.hideItem(new ItemStack(mod_ebm.mauvewoodDoor));
		API.hideItem(new ItemStack(mod_ebm.mTorchRedOff));
		API.hideItem(new ItemStack(mod_ebm.deadTorchRedOff));
		API.hideItem(new ItemStack(mod_ebm.mauveTorchRedOff));
		API.hideItem(new ItemStack(mod_ebm.dymusSlabDouble));
		API.hideItem(new ItemStack(mod_ebm.dymusOrnateSlabDouble));
		API.hideItem(new ItemStack(mod_ebm.dymusBrickSlabDouble));
		API.hideItem(new ItemStack(mod_ebm.autilSlabDouble));
		API.hideItem(new ItemStack(mod_ebm.autilOrnateSlabDouble));
		API.hideItem(new ItemStack(mod_ebm.autilBrickSlabDouble));
		API.hideItem(new ItemStack(mod_ebm.unAutilBrickSlabDouble));
		API.hideItem(new ItemStack(mod_ebm.amethystSlabDouble));
		API.hideItem(new ItemStack(mod_ebm.amethystOrnateSlabDouble));
		API.hideItem(new ItemStack(mod_ebm.amethystBrickSlabDouble));
		API.hideItem(new ItemStack(mod_ebm.mWoodSlabDouble));
		API.hideItem(new ItemStack(mod_ebm.deadWoodSlabDouble));
		API.hideItem(new ItemStack(mod_ebm.mauvewoodSlabDouble));
		API.hideItem(new ItemStack(mod_ebm.invsItem));
	}
}
