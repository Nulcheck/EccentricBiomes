package ebm.com.mce.handlers.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import ebm.com.mce.common.mod_ebm;
import net.minecraft.item.ItemStack;

public class ArmorRecipeHandler {
	public static void registerRecipes() {
		// Crimtic
		GameRegistry.addRecipe(new ItemStack(mod_ebm.crimticHelmet), "***", "* *", '*',
				new ItemStack(mod_ebm.crimticIngot));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.crimticChest), "* *", "***", "***", '*',
				new ItemStack(mod_ebm.crimticIngot));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.crimticLegs), "***", "* *", "* *", '*',
				new ItemStack(mod_ebm.crimticIngot));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.crimticBoots), "* *", "* *", '*',
				new ItemStack(mod_ebm.crimticIngot));
	}
}