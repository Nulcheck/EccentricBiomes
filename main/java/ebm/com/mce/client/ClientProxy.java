package ebm.com.mce.client;

import java.util.Random;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import ebm.com.mce.client.render.block.chest.ClientRenderDeadwoodChest;
import ebm.com.mce.client.render.block.chest.ClientRenderManchineelChest;
import ebm.com.mce.client.render.block.chest.ClientRenderMauvewoodChest;
import ebm.com.mce.client.render.item.ItemRenderErythonCube;
import ebm.com.mce.client.render.item.block.ItemRenderBeehive;
import ebm.com.mce.client.render.item.block.chest.ItemDeadwoodChestRender;
import ebm.com.mce.client.render.item.block.chest.ItemManchineelChestRender;
import ebm.com.mce.client.render.item.block.chest.ItemMauvewoodChestRender;
import ebm.com.mce.common.CommonProxy;
import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.entity.fx.EntityErythonFX;
import ebm.com.mce.entity.mobs.EntityErython;
import ebm.com.mce.entity.tile.block.TileEntityBeehive;
import ebm.com.mce.entity.tile.block.chest.TileEntityDeadwoodChest;
import ebm.com.mce.entity.tile.block.chest.TileEntityManchineelChest;
import ebm.com.mce.entity.tile.block.chest.TileEntityMauvewoodChest;
import ebm.com.mce.entity.tile.item.TileEntityErythonCube;
import ebm.com.mce.models.mobs.ModelErython;
import ebm.com.mce.render.block.RenderBeehive;
import ebm.com.mce.render.item.RenderErythonCube;
import ebm.com.mce.render.mobs.RenderErython;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	public void registerRenders() {
		// Mobs
		RenderingRegistry.registerEntityRenderingHandler(EntityErython.class, new RenderErython(new ModelErython(), 0));

		// Items
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityErythonCube.class, new RenderErythonCube());
		MinecraftForgeClient.registerItemRenderer(mod_ebm.erythonCube, new ItemRenderErythonCube());

		// Blocks
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBeehive.class, new RenderBeehive());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_ebm.beehive), new ItemRenderBeehive());

		// Chests
		// Manchineel
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityManchineelChest.class,
				new ClientRenderManchineelChest());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_ebm.mChest),
				new ItemManchineelChestRender());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_ebm.mChestTrapped),
				new ItemManchineelChestRender());

		// Deadwood
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDeadwoodChest.class, new ClientRenderDeadwoodChest());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_ebm.deadChest),
				new ItemDeadwoodChestRender());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_ebm.deadChestTrapped),
				new ItemDeadwoodChestRender());

		// Mauvewood
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMauvewoodChest.class, new ClientRenderMauvewoodChest());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_ebm.mauveChest),
				new ItemMauvewoodChestRender());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_ebm.mauveChestTrapped),
				new ItemMauvewoodChestRender());
	}

	public void spawnParticle(World world, double posX, double posY, double posZ, String type) {
		Minecraft minecraft = Minecraft.getMinecraft();
		Random rand = world.rand;

		if (minecraft != null && minecraft.renderViewEntity != null && minecraft.effectRenderer != null) {
			int particleSetting = minecraft.gameSettings.particleSetting;

			if (particleSetting == 1 && world.rand.nextInt(3) == 0) {
				particleSetting = 2;
			}

			double entityX = minecraft.renderViewEntity.posX - posX;
			double entityY = minecraft.renderViewEntity.posY - posY;
			double entityZ = minecraft.renderViewEntity.posZ - posZ;

			if (entityX * entityX + entityY * entityY + entityZ * entityZ > 16.0D * 16.0D) {
				return;
			} else if (particleSetting > 1) {
				return;
			} else {
				EntityFX particle = null;

				if (type.equals("erythonFx")) {
					particle = new EntityErythonFX(world, posX + (rand.nextDouble() - 0.5d),
							posY + (rand.nextDouble() - 1d), posZ + (rand.nextDouble() - 0.5d), 0d, 0d, 0d);
				}

				if (particle != null) {
					minecraft.effectRenderer.addEffect(particle);
				}
			}
		}
	}
}
