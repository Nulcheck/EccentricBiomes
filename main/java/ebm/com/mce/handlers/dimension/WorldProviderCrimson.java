package ebm.com.mce.handlers.dimension;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.handlers.dimension.chucks.ChunkProviderCrimson;
import ebm.com.mce.handlers.dimension.chucks.managers.WorldChunkManagerCrimson;
import ebm.com.mce.handlers.dimension.renders.SkyRenderCrimson;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderCrimson extends WorldProvider {
	IRenderHandler skyRenderer;

	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderCrimson(this.worldObj, this.worldObj.getSeed(), true);
	}

	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerCrimson(this.worldObj.getSeed(), terrainType);
		this.dimensionId = mod_ebm.crimsonId;
	}

	public static WorldProvider getProviderForDimension(int id) {
		return DimensionManager.createProviderFor(mod_ebm.crimsonId);
	}

	public boolean canCoordinateBeSpawn(int x, int z) {
		return this.worldObj.getTopBlock(x, z) == mod_ebm.crimsonObsidian;
	}

	public ChunkCoordinates getRandomizedSpawnPoint() {
		ChunkCoordinates coord = new ChunkCoordinates(this.worldObj.getSpawnPoint());

		boolean isAdventure = worldObj.getWorldInfo().getGameType() == GameType.ADVENTURE;
		int spawnFuzz = terrainType.getSpawnFuzz();
		int spawnFuzzHalf = spawnFuzz / 2;

		if (!hasNoSky && !isAdventure && net.minecraftforge.common.ForgeModContainer.defaultHasSpawnFuzz) {
			coord.posX += this.worldObj.rand.nextInt(spawnFuzz) - spawnFuzzHalf;
			coord.posZ += this.worldObj.rand.nextInt(spawnFuzz) - spawnFuzzHalf;
			coord.posY = this.worldObj.getTopSolidOrLiquidBlock(coord.posX, coord.posZ);
		}

		return coord;
	}

	public BiomeGenBase getBiomeGenForCoords(int x, int z) {
		return worldObj.getBiomeGenForCoordsBody(x, z);
	}

	public String getDimensionName() {
		return "Crimson";
	}

	public String getSaveFolder() {
		return "ECB-DIM" + mod_ebm.crimsonId;
	}

	public boolean renderStars() {
		return false;
	}

	public float getStarBrightness(World world, float f) {
		return 0f;
	}

	public double getMovementFactor() {
		return 5;
	}

	public boolean renderClouds() {
		return false;
	}

	public boolean renderVoidFog() {
		return false;
	}

	public boolean renderEndSky() {
		return false;
	}

	public boolean isSkyColored() {
		return true;
	}

	public boolean canRespawnHere() {
		return true;
	}

	public boolean isSurfaceWorld() {
		return true;
	}

	public int setHeight() {
		return 512;
	}

	public ChunkCoordinates getEntrancePortalPosition() {
		return null;
	}

	public void generateLightBrightnessTable() {
		float f = 0f;

		for (int i = 0; i <= 15; i++) {
			float f1 = 1f - (float) i / 15f;
			this.lightBrightnessTable[i] = (1f - f1) / (f1 * 3f + 1f) * (1f - f) + f;
		}
	}

	public String getWelcomeMessage() {
		return "Welcome to the Underworld!";
	}

	public String getDepartMessage() {
		return "You escaped the Underworld.";
	}

	public IRenderHandler getSkyRenderer() {
		return new SkyRenderCrimson();
	}

	public Vec3 getSkyColor(Entity entity, float ticks) {
		return worldObj.getSkyColorBody(entity, ticks);
	}
}
