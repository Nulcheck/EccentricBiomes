package ebm.com.mce.gen.biomes;

import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.entity.mobs.EntityErython;
import ebm.com.mce.gen.biomes.dec.WorldGenBrokenSpikes;
import ebm.com.mce.gen.feature.WorldGenAutilLab1;
import ebm.com.mce.gen.feature.WorldGenAutilLab3;
import ebm.com.mce.gen.feature.WorldGenBasicRoom;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class AutilField extends BiomeGenBase {
	public WorldGenBrokenSpikes genSpikes = new WorldGenBrokenSpikes();
	public WorldGenBasicRoom basicRoom = new WorldGenBasicRoom();
	public WorldGenAutilLab1 returnToSender = new WorldGenAutilLab1();
	public WorldGenAutilLab3 hotelDeath = new WorldGenAutilLab3();

	@SuppressWarnings("unchecked")
	public AutilField(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_Default);
		this.setTemperatureRainfall(.5f, .8f);
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityErython.class, 1, 2, 5));
		this.theBiomeDecorator.grassPerChunk = 4;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.generateLakes = false;

		this.topBlock = mod_ebm.autilBlock;
		this.fillerBlock = mod_ebm.autilBlock;
		this.biomeName = "Autil Field";
		this.waterColorMultiplier = 0;
		this.color = 0;
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		return 0;
	}

	public int getModdedBiomeFoliageColor(int original) {
		return 0;
	}
	
	public int getSkyColorByTemp(float f) {
		return 0;
	}

	public void decorate(World world, Random rand, int i, int j) {
		int k, m, n;
		this.genSpikes.blockA = mod_ebm.autilBlock;
		this.basicRoom.block = Blocks.wool;
		
		this.returnToSender.block = mod_ebm.unAutilBricks;
		this.returnToSender.slabBlock = mod_ebm.unAutilBrickSlab;
		this.returnToSender.stairBlock = mod_ebm.unAutilBrickStairs;
		
		this.hotelDeath.block = mod_ebm.unAutilBricks;
		this.hotelDeath.slabBlock = mod_ebm.unAutilBrickSlab;
		this.hotelDeath.stairBlock = mod_ebm.unAutilBrickStairs;

		m = i + rand.nextInt(16) + 8;
		n = j + rand.nextInt(16) + 8;

		for (k = 0; k < 3; ++k) {
			this.genSpikes.generate(world, rand, m, world.getHeightValue(m, n), n);
		}

		int x, y, z;
		x = m + rand.nextInt(16);
		y = rand.nextInt(16) + 85;
		z = j - rand.nextInt(16);
		

		if (rand.nextInt(150) < 1) {
			//this.basicRoom.generate(world, rand, m, world.getHeightValue(m, n) - y, n);
			//this.returnToSender.generate(world, rand, x, world.getHeightValue(m, n) - y, z);
			// this.hotelDeath.generate(world, rand, x, world.getHeightValue(m, n) - y, z);
		}
		super.decorate(world, rand, i, j);
	}
}
