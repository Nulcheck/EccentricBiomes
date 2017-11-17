package ebm.com.mce.handlers.packets;

import java.io.IOException;

import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import ebm.com.mce.common.mod_ebm;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;

public class CreatePacketClientSide {
	public CreatePacketClientSide() {
		// don't need anything here
	}

	public static FMLProxyPacket createClientToServerTestPacket(int parTestValue) throws IOException {
		// DEBUG
		System.out.println("Sending ProcessPacketClientSide on Client Side");

		ByteBufOutputStream bbos = new ByteBufOutputStream(Unpooled.buffer());
		bbos.writeInt(mod_ebm.PACKET_TYPE_C2S_TEST);
		bbos.writeInt(parTestValue);
		FMLProxyPacket thePacket = new FMLProxyPacket(bbos.buffer(), mod_ebm.networkChannelName);
		bbos.close();

		return thePacket;
	}

	public static void sendToServer(FMLProxyPacket parPacket) {
		mod_ebm.channel.sendToServer(parPacket);
	}

	public static void sendTestPacket(int parTestData) {
		try {
			sendToServer(createClientToServerTestPacket(parTestData));
		} catch (IOException e) {
			System.out.println("An error has occurred! Error ID: ECB-305");
			e.printStackTrace();
		}
	}
}