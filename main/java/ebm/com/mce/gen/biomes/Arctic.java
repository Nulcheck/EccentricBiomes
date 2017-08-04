package ebm.com.mce.gen.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class Arctic extends BiomeGenBase {
	public Arctic(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_MidPlains);
		this.setTemperatureRainfall(0f, .5f);
		this.enableSnow = true;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;

		/*if (mod_ebm.idt) {
			System.out.println("IDT loaded, spawn ice phantom?");
			this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityIcePhantom.class, 1, 2, 3));
		}*/

		this.topBlock = Blocks.snow;
		this.fillerBlock = Blocks.packed_ice;
		this.biomeName = "Arctic";
		this.waterColorMultiplier = 11192831;
		this.color = 11192831;
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		return 11192831;
	}

	public int getModdedBiomeFoliageColor(int original) {
		return 11192831;
	}
}
