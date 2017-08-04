package ebm.com.mce.events;

import com.mce.common.mod_IDT;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ebm.com.mce.common.mod_ebm;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class ChiselEvent {
	@SubscribeEvent
	public void chisel(PlayerInteractEvent e) {
		if (e.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
			// Secret Trapdoors
			if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.mTDoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.mSTDoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.deadTDoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.deadSTDoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.mauveTDoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.mauveSTDoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.mSTDoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.mTDoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.deadSTDoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.deadTDoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.mauveSTDoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.mauveTDoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			//// Dymus
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusBlock
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.dymusBricks);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusBricks
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.dymusOrnate);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusOrnate
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.dymusPillar);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusPillar
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.dymusChisel);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusChisel
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.dymusBlock);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Slabs!
			// Dymus
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Dymus brick
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Dymus Ornate
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Dymus Chisel
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.dymusChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			//// Autil
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilBlock
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.autilBricks);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilBricks
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.autilOrnate);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilOrnate
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.autilPillar);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilPillar
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.autilChisel);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilChisel
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.autilBlock);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Slabs!
			// Autil
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Autil brick
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Autil Ornate
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Autil Chisel
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.autilChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Unbreakable Autil brick
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.unAutilBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.unAutilBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.unAutilBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.unAutilBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.unAutilBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.unAutilBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Wooden Manchineel Slab
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.mWoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.mWoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.mWoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.mWoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.mWoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.mWoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Dead Wood Slab
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.deadWoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.deadWoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.deadWoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.deadWoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.deadWoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.deadWoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Wooden Mauvewood Slab
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.mauvewoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.mauvewoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.mauvewoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.mauvewoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.mauvewoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.mauvewoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			//// Amethyst
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystCrust
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.amethystBricks);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystBricks
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.amethystOrnate);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystOrnate
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.amethystPillar);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystPillar
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.amethystChisel);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystChisel
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.amethystCrust);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Slabs!
			// Amethyst
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Amethyst brick
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Amethyst Ornate
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Amethyst Chisel
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.amethystChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			//// Bone
			// Slab
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.boneSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.boneSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.boneSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.boneSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.boneSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.boneSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			//// Beeswax
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswax
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.beeswaxBricks);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxBricks
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.beeswaxOrnate);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxOrnate
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.beeswaxPillar);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxPillar
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.beeswaxChisel);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxChisel
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_ebm.beeswax);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Slabs!
			// Beeswax
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Beeswax brick
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Beeswax Ornate
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxOrnateSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Beeswax Chisel
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_ebm.beeswaxChiselSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Need it so you don't crash.
			else if (!e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				if (!mod_ebm.idt) {
					e.entityPlayer.addChatComponentMessage(
							new ChatComponentText("You need to be sneaking to chisel something!"));
				}
			}
		}
	}
}
