package ebm.com.mce.handlers.packets;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import ebm.com.mce.common.mod_ebm;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

public class GuiPacket {
	private byte id;

	public GuiPacket() {

	}

	public GuiPacket(byte id) {
		this.id = id;
	}

	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buf) {
		buf.writeByte(id);
	}

	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buf) {
		id = buf.readByte();
	}

	public void handleClientSide(EntityPlayer player) {

	}

	public void handleServerSide(EntityPlayer player) {
		int x = (int) player.posX;
		int y = (int) player.posY;
		int z = (int) player.posZ;

		System.out.println("Success");
		FMLNetworkHandler.openGui(player, mod_ebm.instance, id, player.worldObj, x, y, z);
	}
}
