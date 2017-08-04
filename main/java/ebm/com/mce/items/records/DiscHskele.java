package ebm.com.mce.items.records;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.BlockJukebox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class DiscHskele extends ItemRecord {
	private static final Map cd = new HashMap();
	public final String cdName;

	public DiscHskele(String name) {
		super(name);
		this.cdName = name;
		this.maxStackSize = 1;

		cd.put(name, this);
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta,
			float hitX, float hitY, float hitZ) {
		if (world.getBlock(x, y, z) == Blocks.jukebox && world.getBlockMetadata(x, y, z) == 0) {
			if (world.isRemote) {
				return true;
			} else {
				((BlockJukebox) Blocks.jukebox).func_149926_b(world, x, y, z, stack);
				world.playAuxSFXAtEntity((EntityPlayer) null, 1005, x, y, z, Item.getIdFromItem(this));
				--stack.stackSize;
				return true;
			}
		} else {
			return false;
		}
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean meta) {
		list.add(this.getRecordNameLocal());
	}

	public String getRecordNameLocal() {
		return "MCE626 - Happy Skeleton";
	}

	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.uncommon;
	}

	public static DiscHskele getRecord(String s) {
		return (DiscHskele) cd.get(s);
	}

	public ResourceLocation getRecordResource(String name) {
		return new ResourceLocation("mod_ebm:" + name);
	}
}
