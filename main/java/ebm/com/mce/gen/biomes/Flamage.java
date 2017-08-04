package ebm.com.mce.gen.biomes;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.world.biome.BiomeGenBase;

public class Flamage extends BiomeGenBase {
	public Flamage(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_Default);
		this.setTemperatureRainfall(1, 0);
		this.enableRain = false;
		this.enableSnow = false;
		this.spawnableMonsterList.clear();
		this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityMagmaCube.class, 1, 3, 7));
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.generateLakes = false;
		this.waterColorMultiplier = 6562820;
		this.color = 6562820;

		this.topBlock = mod_ebm.flameStone;
		this.fillerBlock = mod_ebm.flameStone;
		this.biomeName = "Flamage";
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		return 6562820;
	}

	public int getModdedBiomeFoliageColor(int color) {
		return 6562820;
	}
	
	public int getSkyColorByTemp(float f) {
		return 6562820;
	}
}
