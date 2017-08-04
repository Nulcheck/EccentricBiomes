package ebm.com.mce.gen.biomes;

import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.gen.trees.WorldGenBoneTree;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Bone extends BiomeGenBase {
	private WorldGenerator worldGenBoneTree;
	int idfk = 1;

	public Bone(int id, boolean spawn) {
		super(id, spawn);
		this.setHeight(height_Default);
		this.setDisableRain();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySkeleton.class, 1, 8, 15));
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.treesPerChunk = 5;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.worldGenBoneTree = new WorldGenBoneTree();

		this.topBlock = mod_ebm.boneBlock;
		this.fillerBlock = mod_ebm.boneBlock;
		this.biomeName = "Bone";
	}
	
	public int getSkyColorByTemp(float f) {
		return 15263976;
	}

	public WorldGenAbstractTree func_150567_a(Random ran) {
		return (WorldGenAbstractTree) ((this.idfk == 1) && ran.nextInt(3) == 0
				? (this.idfk != 2 && ran.nextInt(13) != 0 ? worldGenBoneTree : worldGenBoneTree)
				: (ran.nextInt(3) == 0 ? worldGenBoneTree : worldGenBoneTree));
	}

}
