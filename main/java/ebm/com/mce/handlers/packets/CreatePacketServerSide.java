package ebm.com.mce.handlers.packets;

import java.io.IOException;

import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import ebm.com.mce.common.mod_ebm;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;

public class CreatePacketServerSide {

	public CreatePacketServerSide() {
		// don't need anything here
	}

	public static FMLProxyPacket createEntityPacket(Entity parEntity) throws IOException {
		// DEBUG
		System.out.println("Sending Entity Sync Packet on Server Side");
		ByteBufOutputStream bbos = new ByteBufOutputStream(Unpooled.buffer());
		bbos.writeInt(mod_ebm.PACKET_TYPE_ENTITY_SYNC);
		bbos.writeInt(parEntity.getEntityId());

		/*
		 * if (parEntity instanceof EntityAnimal) { EntityAnimal
		 * entityHerdAnimal = (EntityAnimal)parEntity;
		 * bbos.writeFloat(entityHerdAnimal.getScaleFactor());
		 * bbos.writeBoolean(entityHerdAnimal.isRearing());
		 * bbos.writeInt(entityHerdAnimal.getRearingCounter()); }
		 */

		FMLProxyPacket thePacket = new FMLProxyPacket(bbos.buffer(), mod_ebm.networkChannelName);
		bbos.close();

		return thePacket;
	}

	public static void sendToAll(FMLProxyPacket parPacket) {
		mod_ebm.channel.sendToAll(parPacket);
	}

	public static void sendS2CEntitySync(Entity parEntity) {
		try {
			sendToAll(createEntityPacket(parEntity));
		} catch (IOException e) {
			System.out.println("An error has occurred! Error ID: IDT-305");
			e.printStackTrace();
		}
	}
}