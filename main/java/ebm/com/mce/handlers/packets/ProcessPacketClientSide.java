package ebm.com.mce.handlers.packets;

import java.io.IOException;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ebm.com.mce.common.mod_ebm;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class ProcessPacketClientSide {
	public ProcessPacketClientSide() {
		// don't need anything here
	}

	@SideOnly(Side.CLIENT)
	public static void processPacketOnClient(ByteBuf parBB, Side parSide) throws IOException {
		if (parSide == Side.CLIENT) {
			// DEBUG
			System.out.println("Received ProcessPacketClientSide on Client Side");

			World theWorld = Minecraft.getMinecraft().theWorld;
			ByteBufInputStream bbis = new ByteBufInputStream(parBB);

			int packetTypeID = bbis.readInt();

			switch (packetTypeID) {
			case mod_ebm.PACKET_TYPE_ENTITY_SYNC: {

				int entityID = bbis.readInt();

				// DEBUG
				System.out.println("Entity ID = " + entityID);

				Entity foundEntity = getEntityByID(entityID, theWorld);

				// DEBUG
				if (foundEntity != null) {
					System.out.println("Entity Class Name = " + foundEntity.getClass().getSimpleName());
				} else {
					System.out.println("Entity Class Name = null");
				}

				/*
				 * if (foundEntity instanceof EntityAnimal) { EntityAnimal
				 * foundEntityHerdAnimal = (EntityAnimal)foundEntity;
				 * foundEntityHerdAnimal.setScaleFactor(bbis.readFloat());
				 * foundEntityHerdAnimal.setRearing(bbis.readBoolean());
				 * foundEntityHerdAnimal.setRearingCounter(bbis.readInt()); //
				 * DEBUG System.out.println("Is rearing = "
				 * +foundEntityHerdAnimal .isRearing()); }
				 */

			}

				bbis.close();
			}
		}
	}

	// some helper functions
	public static Entity getEntityByID(int entityID, World world) {
		for (Object o : world.getLoadedEntityList()) {
			if (((Entity) o).getEntityId() == entityID) {
				System.out.println("Found the entity");
				return ((Entity) o);
			}
		}
		return null;
	}
}