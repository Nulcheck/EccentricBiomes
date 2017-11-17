package ebm.com.mce.events;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;

public class OtherEvents {
	@SubscribeEvent
	public void weaponEffects(AttackEntityEvent e) {
		if (e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == mod_ebm.stingerSword
				&& e.target instanceof EntityLiving) {
			((EntityLivingBase) e.target).addPotionEffect(new PotionEffect(19, 120, 0, false));
		}

		else if (e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == mod_ebm.fireSword
				&& e.target instanceof EntityLiving) {
			e.target.setFire(8);
		}

		else if (e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == mod_ebm.pyreCrystal
				&& e.target instanceof EntityLiving) {
			e.target.setFire(4);
		}
	}

	@SubscribeEvent
	public void blockChanging(PlayerInteractEvent e) {
		if (e.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK && !e.world.isRemote) {
			if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_ebm.pyreCrystal
					&& e.world.getBlock(e.x, e.y, e.z) == Blocks.stone) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.flameStone);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.inventory.consumeInventoryItem(mod_ebm.pyreCrystal);
			}
			
			if (e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == mod_ebm.pyreCrystal
					&& e.world.getBlock(e.x, e.y, e.z) == mod_ebm.crimsonObsidian) {
				e.world.setBlock(e.x, e.y + 1, e.z, mod_ebm.crimsonFire);
				e.world.scheduleBlockUpdate(e.x, e.y, e.z, mod_ebm.crimsonFire, 1);
			}
		}
	}

	@SubscribeEvent
	public void flameStoneStuff(PlayerInteractEvent e) {
		if (e.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK && !e.world.isRemote) {
			if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_ebm.ebmWrench
					&& e.world.getBlock(e.x, e.y, e.z) == mod_ebm.flameStone) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.flameStoneDeactivated);
				e.entityPlayer.addChatComponentMessage(new ChatComponentText("Burning Nothing"));
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_ebm.ebmWrench
					&& e.world.getBlock(e.x, e.y, e.z) == mod_ebm.flameStoneDeactivated) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.flameStoneBurnMobs);
				e.entityPlayer.addChatComponentMessage(new ChatComponentText("Burning Mobs Only"));
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_ebm.ebmWrench
					&& e.world.getBlock(e.x, e.y, e.z) == mod_ebm.flameStoneBurnMobs) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.flameStoneBurnPlayers);
				e.entityPlayer.addChatComponentMessage(new ChatComponentText("Burning Player Only"));
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_ebm.ebmWrench
					&& e.world.getBlock(e.x, e.y, e.z) == mod_ebm.flameStoneBurnPlayers) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.flameStone);
				e.entityPlayer.addChatComponentMessage(new ChatComponentText("Burning All"));
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}
		}

		else if (e.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK && !e.world.isRemote) {
			if (e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == mod_ebm.ebmWrench
					&& e.world.getBlock(e.x, e.y, e.z) == mod_ebm.flameStone) {
				e.entityPlayer.addChatComponentMessage(new ChatComponentText("Burning All"));
			}

			else if (e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == mod_ebm.ebmWrench
					&& e.world.getBlock(e.x, e.y, e.z) == mod_ebm.flameStoneDeactivated) {
				e.entityPlayer.addChatComponentMessage(new ChatComponentText("Burning Nothing"));
			}

			else if (e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == mod_ebm.ebmWrench
					&& e.world.getBlock(e.x, e.y, e.z) == mod_ebm.flameStoneBurnMobs) {
				e.entityPlayer.addChatComponentMessage(new ChatComponentText("Burning Mobs Only"));
			}

			else if (e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == mod_ebm.ebmWrench
					&& e.world.getBlock(e.x, e.y, e.z) == mod_ebm.flameStoneBurnPlayers) {
				e.entityPlayer.addChatComponentMessage(new ChatComponentText("Burning Players Only"));
			}
		}
	}

	// For the double slab droppings
	@SubscribeEvent
	public void doubleSlabDrops(BlockEvent.HarvestDropsEvent e) {
		Block block = e.block;

		if (block == mod_ebm.honeycomb) {
			e.drops.add(new ItemStack(mod_ebm.honey, 2));
			e.drops.remove(0);
		}

		else if (block == mod_ebm.dymusSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.dymusSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.dymusBrickSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.dymusBrickSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.dymusOrnateSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.dymusOrnateSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.autilSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.autilSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.autilBrickSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.autilBrickSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.autilOrnateSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.autilOrnateSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.amethystSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.amethystSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.amethystBrickSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.amethystBrickSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.amethystOrnateSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.amethystOrnateSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.deadWoodSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.deadWoodSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.mWoodSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.mWoodSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.mauvewoodSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.mauvewoodSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.boneSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.boneSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.beeswaxSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.beeswaxSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.beeswaxOrnateSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.beeswaxOrnateSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.beeswaxBrickSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.beeswaxBrickSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.dymusChiselSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.dymusChiselSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.autilChiselSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.autilChiselSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.amethystChiselSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.amethystChiselSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_ebm.beeswaxChiselSlabDouble) {
			e.drops.add(new ItemStack(mod_ebm.beeswaxChiselSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}
	}

	// Glass leaves drop glass shard % increase
	@SubscribeEvent
	public void harvestBlock(PlayerEvent.HarvestCheck e) {
		Random rand = new Random();

		if (e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() instanceof ItemSword
				&& e.block == mod_ebm.glassLeaves) {
			int i = rand.nextInt(10);
			if (i >= 3 && i <= 10) {
				e.entityPlayer.dropItem(mod_ebm.glassShard, 1);
			}
		}
	}
}
