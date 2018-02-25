package ebm.com.mce.handlers.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import ebm.com.mce.common.mod_ebm;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ToolRecipeHandler {
	@SuppressWarnings("unchecked")
	public static void registerRecipes() {
		GameRegistry.addRecipe(new ItemStack(mod_ebm.ebmWrench), "* *", " f ", " * ", '*',
				new ItemStack(mod_ebm.dymusBar), 'f', new ItemStack(mod_ebm.flameStone));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_ebm.erythonBattleAxe), " * ", "*a*", " s ", '*',
						new ItemStack(mod_ebm.erythonCube), 'a', new ItemStack(Items.iron_axe), 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_ebm.stingerSword), "*",
				"*", "s", '*', new ItemStack(mod_ebm.stinger), 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_ebm.fireSword), "*",
				"*", "s", '*', new ItemStack(mod_ebm.pyreIngot), 's', "stickWood"));

		// Crimtic
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_ebm.crimticPick), "***",
				" s ", " s ", '*', new ItemStack(mod_ebm.crimticIngot), 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_ebm.crimticShovel), "*",
				"s", "s", '*', new ItemStack(mod_ebm.crimticIngot), 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_ebm.crimticAxe), "** ",
				"*s ", " s ", '*', new ItemStack(mod_ebm.crimticIngot), 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_ebm.crimticSword), "*",
				"*", "s", '*', new ItemStack(mod_ebm.crimticIngot), 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_ebm.crimticHoe), "** ",
				" s ", " s ", '*', new ItemStack(mod_ebm.crimticIngot), 's', "stickWood"));
	}
}