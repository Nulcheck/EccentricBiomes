package ebm.com.mce.handlers;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import ebm.com.mce.util.updater.UpdateInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class PlayerHandler {
	public boolean newUpdate;

	public PlayerHandler() {
		try {
			if (Integer.parseInt(UpdateInfo.getLatestVersion()) > UpdateInfo.thisVersion) {
				this.newUpdate = true;
			}
		} catch (Exception e) {
			System.out.println("An error has occurred! Error ID: EBM-300");
			e.printStackTrace();
		}
	}

	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent e) {
		onLogin(e.player);
	}

	public void onLogin(EntityPlayer player) {
		if (newUpdate) {
			player.addChatComponentMessage(
					new ChatComponentText(EnumChatFormatting.AQUA + "New Eccentric Biomes update! "));
		}

		if (!Loader.isModLoaded("mod_IDT")) {
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.DARK_PURPLE + "Support MCE: "));
		}
	}
}
