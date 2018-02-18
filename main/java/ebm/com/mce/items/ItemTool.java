package ebm.com.mce.items;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemTool {
	public static class Pick extends ItemPickaxe {
		public Pick(ToolMaterial mat) {
			super(mat);
		}

		public boolean getIsRepairable(ItemStack tool, ItemStack stack) {
			if (tool.getItem() == mod_ebm.crimticPick)
				return stack.getItem() == mod_ebm.crimticIngot;
			return false;
		}
	}

	public static class Shovel extends ItemSpade {
		public Shovel(ToolMaterial mat) {
			super(mat);
		}

		public boolean getIsRepairable(ItemStack tool, ItemStack stack) {
			if (tool.getItem() == mod_ebm.crimticShovel)
				return stack.getItem() == mod_ebm.crimticIngot;
			return false;
		}
	}

	public static class Axe extends ItemAxe {
		public Axe(ToolMaterial mat) {
			super(mat);
		}

		public boolean getIsRepairable(ItemStack tool, ItemStack stack) {
			if (tool.getItem() == mod_ebm.crimticAxe)
				return stack.getItem() == mod_ebm.crimticIngot;
			return false;
		}
	}

	public static class Sword extends ItemSword {
		public Sword(ToolMaterial mat) {
			super(mat);
		}

		public boolean getIsRepairable(ItemStack tool, ItemStack stack) {
			if (tool.getItem() == mod_ebm.crimticSword)
				return stack.getItem() == mod_ebm.crimticIngot;
			return false;
		}
	}

	public static class Hoe extends ItemHoe {
		public Hoe(ToolMaterial mat) {
			super(mat);
		}

		public boolean getIsRepairable(ItemStack tool, ItemStack stack) {
			if (tool.getItem() == mod_ebm.crimticHoe)
				return stack.getItem() == mod_ebm.crimticIngot;
			return false;
		}
	}

	public static class GlassShard extends ItemSword {
		public GlassShard(ToolMaterial mat) {
			super(mat);
		}

		public boolean getIsRepairable(ItemStack tool, ItemStack stack) {
			return false;
		}

		public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean bool) {
			if (!stack.isItemEnchanted()) {
				stack.addEnchantment(Enchantment.sharpness, 1);
			}
		}
	}
}
