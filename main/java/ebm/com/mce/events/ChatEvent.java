package ebm.com.mce.events;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.event.HoverEvent.Action;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

public class ChatEvent {
	@SubscribeEvent
	public void chat(ClientChatReceivedEvent e) {
		if (e.message.getUnformattedText().contains("New Eccentric Biomes update! ")) {
			e.message.appendSibling(
					new ChatComponentText("[Click Here]").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD)
							.setChatHoverEvent(new HoverEvent(Action.SHOW_TEXT, new ChatComponentText("New update!")))
							.setChatClickEvent(new ClickEvent(net.minecraft.event.ClickEvent.Action.OPEN_URL,
									"https://minecraft.curseforge.com/projects/eccentric-biomes"))));
		}

		else if (e.message.getUnformattedText().contains("Eccentric Biomes News: ")) {
			e.message.appendSibling(
					new ChatComponentText("[Click Here]").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD)
							.setChatHoverEvent(
									new HoverEvent(Action.SHOW_TEXT, new ChatComponentText("Eccentric Biomes News!")))
					.setChatClickEvent(new ClickEvent(net.minecraft.event.ClickEvent.Action.OPEN_URL,
							"http://mce626.enjin.com/ebmnews"))));
		}

		else if (e.message.getUnformattedText().contains("Eccentric Biomes Bug Tracker: ")) {
			e.message.appendSibling(
					new ChatComponentText("[Click Here]").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD)
							.setChatHoverEvent(
									new HoverEvent(Action.SHOW_TEXT, new ChatComponentText("Report bugs here!")))
					.setChatClickEvent(new ClickEvent(net.minecraft.event.ClickEvent.Action.OPEN_URL,
							"https://bitbucket.org/MCE626/eccentric-biomes/issues"))));
		}

		else if (!Loader.isModLoaded("mod_IDT")) {
			if (e.message.getUnformattedText().contains("Support MCE: ")) {
				e.message.appendSibling(new ChatComponentText("[Click Here]")
						.setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD)
								.setChatHoverEvent(new HoverEvent(Action.SHOW_TEXT,
										new ChatComponentText("Support MCE's mods via Patreon!")))
						.setChatClickEvent(new ClickEvent(net.minecraft.event.ClickEvent.Action.OPEN_URL,
								"https://www.patreon.com/MCE626"))));
				e.message.appendSibling(new ChatComponentText("!")
						.setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_PURPLE)));
			}
		}

		else if (e.message.getUnformattedText().contains("Eccentric Biomes Wiki: ")) {
			e.message.appendSibling(
					new ChatComponentText("[Click Here]").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD)
							.setChatHoverEvent(
									new HoverEvent(Action.SHOW_TEXT, new ChatComponentText("Eccentric Biomes Wiki!")))
					.setChatClickEvent(new ClickEvent(net.minecraft.event.ClickEvent.Action.OPEN_URL,
							"http://eccentricbiomes.gamepedia.com"))));
		}
	}
}
