package ebm.com.mce.util;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModCreativeTabs extends CreativeTabs {
	public final String gui_ebm = "ebm.png";

	public ModCreativeTabs(String name) {
		super(name);
		setBackgroundImageName(gui_ebm);
	}

	public Item getTabIconItem() {
		return mod_ebm.ebmWrench;
	}
}
