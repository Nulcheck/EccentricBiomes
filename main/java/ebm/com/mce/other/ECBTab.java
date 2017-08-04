package ebm.com.mce.other;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ECBTab extends CreativeTabs {
	public final String gui_ebm = "ebm.png";

	public ECBTab(String name) {
		super(name);
		setBackgroundImageName(gui_ebm);
	}

	public Item getTabIconItem() {
		return mod_ebm.ebmWrench;
	}
}
