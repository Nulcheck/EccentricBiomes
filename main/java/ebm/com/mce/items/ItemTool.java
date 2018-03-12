package ebm.com.mce.items;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.entity.EntityCrimsonArrow;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

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

	public static class CrimsonBow extends ItemBow {
		public CrimsonBow() {
			super();
		}

		public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int meta) {
			int j = this.getMaxItemUseDuration(stack) - meta;

			ArrowLooseEvent event = new ArrowLooseEvent(player, stack, j);
			MinecraftForge.EVENT_BUS.post(event);
			if (event.isCanceled()) {
				return;
			}
			j = event.charge;

			boolean flag = player.capabilities.isCreativeMode
					|| EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;

			if (flag || player.inventory.hasItem(Items.arrow)) {
				float f = (float) j / 20.0F;
				f = (f * f + f * 2.0F) / 3.0F;

				if ((double) f < 0.1D) {
					return;
				}

				if (f > 1.0F) {
					f = 1.0F;
				}

				EntityCrimsonArrow arrow = new EntityCrimsonArrow(world, player, f * 2.0F);

				if (f == 1.0F) {
					arrow.setIsCritical(true);
				}

				int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

				if (k > 0) {
					arrow.setDamage(arrow.getDamage() + (double) k * 0.5D + 0.5D);
				}

				int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);

				if (l > 0) {
					arrow.setKnockbackStrength(l);
				}

				if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0) {
					arrow.setFire(100);
				}

				stack.damageItem(1, player);
				world.playSoundAtEntity(player, "random.bow", 1.0F,
						1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

				if (flag) {
					arrow.canBePickedUp = 2;
				} else {
					player.inventory.consumeInventoryItem(Items.arrow);
				}

				if (!world.isRemote) {
					world.spawnEntityInWorld(arrow);
				}
			}
		}
	}
}
