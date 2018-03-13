package ebm.com.mce.handlers.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import ebm.com.mce.common.mod_ebm;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemRecipeHandler {
	@SuppressWarnings("unchecked")
	public static void registerCrafting() {
		GameRegistry.addRecipe(new ItemStack(mod_ebm.dymusBar), "***", '*', new ItemStack(mod_ebm.dymusPowder));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.clay_ball, 3), new ItemStack(mod_ebm.dust),
				new ItemStack(mod_ebm.dust), new ItemStack(mod_ebm.dust), new ItemStack(Items.water_bucket));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mDoorItem), "**", "**", "**", '*', new ItemStack(mod_ebm.mPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.deadDoorItem), "**", "**", "**", '*',
				new ItemStack(mod_ebm.deadPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mauvewoodDoorItem), "**", "**", "**", '*',
				new ItemStack(mod_ebm.mauvePlanks));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Items.wooden_door, 1), "**", "**", "**", '*', "plankWood"));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.crystalHoney), "*", "*", "*", '*', new ItemStack(mod_ebm.honey));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_ebm.crystalHoney, 3),
				new ItemStack(mod_ebm.crystalHoneyBlock));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_ebm.stinger), new ItemStack(mod_ebm.bee));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mStick, 4), "*", "*", '*', new ItemStack(mod_ebm.mPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.deadStick, 4), "*", "*", '*', new ItemStack(mod_ebm.deadPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.mauveStick, 4), "*", "*", '*', new ItemStack(mod_ebm.mauvePlanks));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.bone, 9), new ItemStack(mod_ebm.boneBlock));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_ebm.crimticIngot, 9), new ItemStack(mod_ebm.crimticBlock));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_ebm.pyreIngot), new ItemStack(mod_ebm.pyreCrystal),
				new ItemStack(Items.iron_ingot));
		
		GameRegistry.addShapelessRecipe(new ItemStack(mod_ebm.pyreIngot, 9), new ItemStack(mod_ebm.pyreBlock));

		GameRegistry.addRecipe(new ItemStack(mod_ebm.crimsonString), "***", "***", "***", '*',
				new ItemStack(mod_ebm.crimsonFiber));
	}

	public static void registerSmelting() {
		GameRegistry.addSmelting(new ItemStack(mod_ebm.blueDirt), new ItemStack(mod_ebm.dymusPowder, 3), .5f);

		GameRegistry.addSmelting(new ItemStack(mod_ebm.crystalHoneyBlock), new ItemStack(mod_ebm.honey, 9), .5f);

		GameRegistry.addSmelting(new ItemStack(mod_ebm.crystalHoney), new ItemStack(mod_ebm.honey, 3), .5f);

		GameRegistry.addSmelting(new ItemStack(mod_ebm.mLog), new ItemStack(Items.coal, 1, 1), .5f);

		GameRegistry.addSmelting(new ItemStack(mod_ebm.deadLog), new ItemStack(Items.coal, 1, 1), .5f);

		GameRegistry.addSmelting(new ItemStack(mod_ebm.mauvewoodLog), new ItemStack(Items.coal, 1, 1), .5f);

		GameRegistry.addSmelting(new ItemStack(mod_ebm.crimsoniteOre), new ItemStack(mod_ebm.crimticIngot), 1f);

		GameRegistry.addSmelting(new ItemStack(mod_ebm.crimsonCactus), new ItemStack(mod_ebm.crimsonFiber, 3), 1f);

		GameRegistry.addSmelting(new ItemStack(mod_ebm.crimsonString), new ItemStack(Items.string), 1f);
	}
}
