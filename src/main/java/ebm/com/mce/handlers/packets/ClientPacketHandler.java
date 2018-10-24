package ebm.com.mce.handlers.packets;

import java.io.IOException;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;
import ebm.com.mce.common.mod_ebm;

public class ClientPacketHandler extends ServerPacketHandler {
	@SubscribeEvent
	public void onClientPacket(ClientCustomPacketEvent event)
			throws IOException {
		channelName = event.packet.channel();
		if (channelName.equals(mod_ebm.networkChannelName)) {
			// DEBUG
			System.out.println("Client received packet from server");

			ProcessPacketClientSide.processPacketOnClient(
					event.packet.payload(), event.packet.getTarget());
		}
	}
}