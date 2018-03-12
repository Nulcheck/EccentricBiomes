package ebm.com.mce.common;

import java.util.logging.Logger;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import ebm.com.mce.api.CraftingPillarEBMAPI;
import ebm.com.mce.armor.CrimticArmor;
import ebm.com.mce.blocks.DeadGrass;
import ebm.com.mce.blocks.ModBlocks;
import ebm.com.mce.blocks.ModBlocks.AmethystCrust;
import ebm.com.mce.blocks.ModBlocks.AmethystDirt;
import ebm.com.mce.blocks.ModBlocks.AutilBlock;
import ebm.com.mce.blocks.ModBlocks.AutilRod;
import ebm.com.mce.blocks.ModBlocks.Beeswax;
import ebm.com.mce.blocks.ModBlocks.BloodBoneBlock;
import ebm.com.mce.blocks.ModBlocks.BlueDirt;
import ebm.com.mce.blocks.ModBlocks.BlueFarmland;
import ebm.com.mce.blocks.ModBlocks.BoneBlock;
import ebm.com.mce.blocks.ModBlocks.CrimsonDirt;
import ebm.com.mce.blocks.ModBlocks.CrimsonObsidian;
import ebm.com.mce.blocks.ModBlocks.CrimsonStone;
import ebm.com.mce.blocks.ModBlocks.DeadDirt;
import ebm.com.mce.blocks.ModBlocks.FlameStone;
import ebm.com.mce.blocks.ModBlocks.Honeycomb;
import ebm.com.mce.blocks.ModBlocks.UnstompableFarmland;
import ebm.com.mce.blocks.ModButton.DeadwoodButton;
import ebm.com.mce.blocks.ModButton.ManchineelButton;
import ebm.com.mce.blocks.ModButton.MauvewoodButton;
import ebm.com.mce.blocks.ModFenceGates.DeadwoodFenceGate;
import ebm.com.mce.blocks.ModFenceGates.ManchineelFenceGate;
import ebm.com.mce.blocks.ModFenceGates.MauvewoodFenceGate;
import ebm.com.mce.blocks.ModFences.DeadwoodFence;
import ebm.com.mce.blocks.ModFences.ManchineelFence;
import ebm.com.mce.blocks.ModFences.MauvewoodFence;
import ebm.com.mce.blocks.ModLadder;
import ebm.com.mce.blocks.ModLeaves.GlassLeaves;
import ebm.com.mce.blocks.ModLeaves.MLeaves;
import ebm.com.mce.blocks.ModLeaves.MauvewoodLeaves;
import ebm.com.mce.blocks.ModLever;
import ebm.com.mce.blocks.ModLogs.BoneLog;
import ebm.com.mce.blocks.ModLogs.DeadLog;
import ebm.com.mce.blocks.ModLogs.GlassLog;
import ebm.com.mce.blocks.ModLogs.MLog;
import ebm.com.mce.blocks.ModLogs.MauvewoodLog;
import ebm.com.mce.blocks.ModMineral.CrimticBlock;
import ebm.com.mce.blocks.ModMineral.PyreBlock;
import ebm.com.mce.blocks.ModOre.CrimsoniteOre;
import ebm.com.mce.blocks.ModPillar.AmethystPillar;
import ebm.com.mce.blocks.ModPillar.AutilPillar;
import ebm.com.mce.blocks.ModPillar.BeeswaxPillar;
import ebm.com.mce.blocks.ModPillar.DymusPillar;
import ebm.com.mce.blocks.ModPlanks.DeadPlanks;
import ebm.com.mce.blocks.ModPlanks.MPlanks;
import ebm.com.mce.blocks.ModPlanks.MauvewoodPlanks;
import ebm.com.mce.blocks.ModPressurePlate;
import ebm.com.mce.blocks.ModRedTorch.DeadwoodRedTorch;
import ebm.com.mce.blocks.ModRedTorch.ManchineelRedTorch;
import ebm.com.mce.blocks.ModRedTorch.MauvewoodRedTorch;
import ebm.com.mce.blocks.ModSlabs;
import ebm.com.mce.blocks.ModStairs;
import ebm.com.mce.blocks.ModTorch;
import ebm.com.mce.blocks.ModTrapdoor;
import ebm.com.mce.blocks.SlimyGrass;
import ebm.com.mce.blocks.chest.DeadwoodChest;
import ebm.com.mce.blocks.chest.ManchineelChest;
import ebm.com.mce.blocks.chest.MauvewoodChest;
import ebm.com.mce.blocks.crops.PyreFlower;
import ebm.com.mce.blocks.dimensional.crimson.CrimsonFire;
import ebm.com.mce.blocks.dimensional.crimson.CrimsonGrass;
import ebm.com.mce.blocks.dimensional.crimson.CrimsonSand;
import ebm.com.mce.blocks.doors.DeadwoodDoor;
import ebm.com.mce.blocks.doors.ManchineelDoor;
import ebm.com.mce.blocks.doors.MauvewoodDoor;
import ebm.com.mce.blocks.plants.Beehive;
import ebm.com.mce.blocks.plants.CrimsonCactus;
import ebm.com.mce.blocks.plants.ModGrass;
import ebm.com.mce.blocks.plants.SlimeSpike;
import ebm.com.mce.blocks.portals.CrimsonPortal;
import ebm.com.mce.blocks.saplings.BoneSapling;
import ebm.com.mce.blocks.saplings.GlassSapling;
import ebm.com.mce.blocks.saplings.MauvewoodSapling;
import ebm.com.mce.blocks.saplings.mSapling;
import ebm.com.mce.blocks.workbench.DeadwoodWorkbench;
import ebm.com.mce.blocks.workbench.ManchineelWorkbench;
import ebm.com.mce.blocks.workbench.MauvewoodWorkbench;
import ebm.com.mce.commands.Bug;
import ebm.com.mce.commands.News;
import ebm.com.mce.commands.Support;
import ebm.com.mce.commands.Wiki;
import ebm.com.mce.effects.CarminicPoison;
import ebm.com.mce.events.ChatEvent;
import ebm.com.mce.events.ChiselEvent;
import ebm.com.mce.events.EffectEvent;
import ebm.com.mce.events.HoeEvent;
import ebm.com.mce.events.OtherEvents;
import ebm.com.mce.handlers.AchievementHandler;
import ebm.com.mce.handlers.ChestHookHandler;
import ebm.com.mce.handlers.DimensionHandler;
import ebm.com.mce.handlers.GUIHandler;
import ebm.com.mce.handlers.PlayerHandler;
import ebm.com.mce.handlers.packets.ClientPacketHandler;
import ebm.com.mce.handlers.packets.ServerPacketHandler;
import ebm.com.mce.handlers.recipe.ArmorRecipeHandler;
import ebm.com.mce.handlers.recipe.BlockRecipeHandler;
import ebm.com.mce.handlers.recipe.ItemRecipeHandler;
import ebm.com.mce.handlers.recipe.ToolRecipeHandler;
import ebm.com.mce.handlers.registry.AchRegistry;
import ebm.com.mce.handlers.registry.BiomeRegistry;
import ebm.com.mce.handlers.registry.BlockRegistry;
import ebm.com.mce.handlers.registry.ItemRegistry;
import ebm.com.mce.handlers.registry.MobRegistry;
import ebm.com.mce.handlers.registry.OreDictionaryRegistry;
import ebm.com.mce.handlers.registry.TileEntityRegistry;
import ebm.com.mce.items.FireSeeds;
import ebm.com.mce.items.ItemTool.Axe;
import ebm.com.mce.items.ItemTool.CrimsonBow;
import ebm.com.mce.items.ItemTool.GlassShard;
import ebm.com.mce.items.ItemTool.Hoe;
import ebm.com.mce.items.ItemTool.Pick;
import ebm.com.mce.items.ItemTool.Shovel;
import ebm.com.mce.items.ItemTool.Sword;
import ebm.com.mce.items.ModItems.ErythonCube;
import ebm.com.mce.items.doors.DeadwoodDoorItem;
import ebm.com.mce.items.doors.ManchineelDoorItem;
import ebm.com.mce.items.doors.MauvewoodDoorItem;
import ebm.com.mce.items.records.DiscHskele;
import ebm.com.mce.util.ModCreativeTabs;
import ebm.com.mce.util.updater.CheckVersion;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate.Sensitivity;
import net.minecraft.block.material.Material;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = mod_ebm.modid, name = mod_ebm.name, version = mod_ebm.version)
public class mod_ebm {
	@Mod.Instance("mod_ebm")
	public static mod_ebm instance;
	public static final int renderId = RenderingRegistry.getNextAvailableRenderId();

	public static final String modid = "mod_ebm";
	public static final String name = "Eccentric Biomes";
	public static final String version = "1.7.1";

	public static final String networkChannelName = "ECB";
	public static FMLEventChannel channel;

	@SidedProxy(clientSide = "ebm.com.mce.client.ClientProxy", serverSide = "ebm.com.mce.common.CommonProxy")
	public static CommonProxy proxy;

	public static Logger log = Logger.getLogger("Minecraft");
	public static boolean idt = Loader.isModLoaded("mod_IDT");

	// TODO: Blocks
	// Other
	public static Block blueDirt;
	public static Block blueFarmland;
	public static Block flameStone;
	public static Block flameStoneDeactivated;
	public static Block flameStoneBurnMobs;
	public static Block flameStoneBurnPlayers;
	public static Block unstompableFarmland;
	public static Block boneBlock;
	public static Block bloodBoneBlock;
	public static Block deadGrass;
	public static Block deadDirt;
	public static Block dymusBlock;
	public static Block autilBlock;
	public static Block autilBlockFull;
	public static Block autilRod;
	public static Block amethystCrust;
	public static Block amethystDirt;
	public static Block honeycomb;
	public static Block beeswax;
	public static Block crystalHoneyBlock;
	public static Block shadowHoneycomb;
	public static Block slimyGrass;
	public static Block crimsonObsidian;
	public static Block crimsonStone;
	public static Block crimsonCobblestone;
	public static Block crimsonGrass;
	public static Block crimsonDirt;
	public static Block crimsonSand;

	// Ores
	public static Block crimsoniteOre;

	// Mineral Blocks
	public static Block crimticBlock;
	public static Block pyreBlock;

	// Fancy shit
	public static Block dymusBricks;
	public static Block dymusOrnate;
	public static Block dymusPillar;
	public static Block dymusChisel;

	public static Block autilBricks;
	public static Block autilOrnate;
	public static Block autilPillar;
	public static Block autilChisel;

	public static Block amethystBricks;
	public static Block amethystOrnate;
	public static Block amethystPillar;
	public static Block amethystChisel;

	public static Block beeswaxBricks;
	public static Block beeswaxOrnate;
	public static Block beeswaxPillar;
	public static Block beeswaxChisel;

	// Plants
	public static Block beehive;
	public static Block fireGrass;
	public static Block slimeSpike;
	public static Block crimsonTallGrass;
	public static Block crimsonBush;
	public static Block crimsonCactus;

	// Portals
	public static Block crimsonPortal;

	// Fires
	public static CrimsonFire crimsonFire;

	// Unbreakable
	public static Block unAutilBricks;
	public static Block unAutilBrickStairs;
	public static Block unAutilBrickPressurePlate;
	public static Block unAutilBrickSlab;
	public static Block unAutilBrickSlabDouble;
	public static Block unAutilRod;

	// Slabs
	public static Block dymusSlab;
	public static Block dymusOrnateSlab;
	public static Block dymusBrickSlab;
	public static Block dymusChiselSlab;
	public static Block autilSlab;
	public static Block autilOrnateSlab;
	public static Block autilBrickSlab;
	public static Block autilChiselSlab;
	public static Block amethystSlab;
	public static Block amethystOrnateSlab;
	public static Block amethystBrickSlab;
	public static Block amethystChiselSlab;
	public static Block boneSlab;
	public static Block beeswaxSlab;
	public static Block beeswaxOrnateSlab;
	public static Block beeswaxBrickSlab;
	public static Block beeswaxChiselSlab;

	// Wooden
	public static Block mWoodSlab;
	public static Block deadWoodSlab;
	public static Block mauvewoodSlab;

	// Double Slab
	public static Block dymusSlabDouble;
	public static Block dymusOrnateSlabDouble;
	public static Block dymusBrickSlabDouble;
	public static Block dymusChiselSlabDouble;
	public static Block autilSlabDouble;
	public static Block autilOrnateSlabDouble;
	public static Block autilBrickSlabDouble;
	public static Block autilChiselSlabDouble;
	public static Block amethystSlabDouble;
	public static Block amethystOrnateSlabDouble;
	public static Block amethystBrickSlabDouble;
	public static Block amethystChiselSlabDouble;
	public static Block boneSlabDouble;
	public static Block beeswaxSlabDouble;
	public static Block beeswaxOrnateSlabDouble;
	public static Block beeswaxBrickSlabDouble;
	public static Block beeswaxChiselSlabDouble;

	// Wooden
	public static Block mWoodSlabDouble;
	public static Block deadWoodSlabDouble;
	public static Block mauvewoodSlabDouble;

	// Stairs
	public static Block dymusStairs;
	public static Block dymusOrnateStairs;
	public static Block dymusBrickStairs;
	public static Block dymusChiselStairs;
	public static Block autilStairs;
	public static Block autilOrnateStairs;
	public static Block autilBrickStairs;
	public static Block autilChiselStairs;
	public static Block amethystStairs;
	public static Block amethystOrnateStairs;
	public static Block amethystBrickStairs;
	public static Block amethystChiselStairs;
	public static Block boneStairs;
	public static Block beeswaxStairs;
	public static Block beeswaxOrnateStairs;
	public static Block beeswaxBrickStairs;
	public static Block beeswaxChiselStairs;

	// Wooden
	public static Block mWoodStairs;
	public static Block deadWoodStairs;
	public static Block mauvewoodStairs;

	// Logs
	public static Block glassLog;
	public static Block boneLog;
	public static Block boneLogBlood;
	public static Block deadLog;
	public static Block mLog;
	public static Block mauvewoodLog;

	// Leaves
	public static Block glassLeaves;
	public static Block mLeaves;
	public static Block mauvewoodLeaves;

	// Sapling
	public static Block glassSapling;
	public static Block boneSapling;
	public static Block mSapling;
	public static Block mauvewoodSapling;

	// Planks
	public static Block mPlanks;
	public static Block deadPlanks;
	public static Block mauvePlanks;

	// Crafting Tables
	public static Block mCTable;
	public static Block deadCTable;
	public static Block mauveCTable;

	// Chests
	public static Block mChest;
	public static Block deadChest;
	public static Block mauveChest;

	// Trapped Chest
	public static Block mChestTrapped;
	public static Block deadChestTrapped;
	public static Block mauveChestTrapped;

	// Buttons
	public static Block mButton;
	public static Block deadButton;
	public static Block mauveButton;

	// Levers
	public static Block mLever;
	public static Block deadLever;
	public static Block mauveLever;

	// Trapdoors
	public static Block mTDoor;
	public static Block deadTDoor;
	public static Block mauveTDoor;

	// Secret Trapdoors
	public static Block mSTDoor;
	public static Block deadSTDoor;
	public static Block mauveSTDoor;

	// Pressure Plates
	public static Block mPlate;
	public static Block deadPlate;
	public static Block mauvePlate;

	// Fences
	public static Block mFence;
	public static Block deadFence;
	public static Block mauveFence;

	// Fence Gates
	public static Block mFenceGate;
	public static Block deadFenceGate;
	public static Block mauveFenceGate;

	// Doors
	public static Block mDoor;
	public static Block deadDoor;
	public static Block mauvewoodDoor;

	// Ladders
	public static Block mLadder;
	public static Block deadLadder;
	public static Block mauveLadder;

	// Torches
	public static Block mTorch;
	public static Block deadTorch;
	public static Block mauveTorch;

	// Red Torch
	public static Block mTorchRed;
	public static Block deadTorchRed;
	public static Block mauveTorchRed;

	// Red Torch Off
	public static Block mTorchRedOff;
	public static Block deadTorchRedOff;
	public static Block mauveTorchRedOff;

	// Crops
	public static Block pyreFlower;

	// TODO: Items
	public static Item ebmWrench;
	public static Item dymusPowder;
	public static Item dymusBar;
	public static Item glassShard;
	public static Item dust;
	public static Item autil;
	public static Item erythonCube;
	public static Item amethystGrit;
	public static Item honey;
	public static Item crystalHoney;
	public static Item bee;
	public static Item stinger;
	public static Item pyreCrystal;
	public static Item bloodBone;
	public static Item crimsonFiber;
	public static Item crimsonString;

	// Ingots
	public static Item crimticIngot;
	public static Item pyreIngot;

	// Nuggets
	public static Item crimticNugget;

	// Dusts
	public static Item crimticDust;

	// Seeds
	public static Item fireSeed;

	// Sticks
	public static Item mStick;
	public static Item deadStick;
	public static Item mauveStick;

	// Door Item
	public static Item mDoorItem;
	public static Item deadDoorItem;
	public static Item mauvewoodDoorItem;

	// Records
	public static Item cd_hskele;

	// Tools
	public static Item erythonBattleAxe;
	public static Item stingerSword;
	public static Item fireSword;
	public static Item crimsonBow;

	// Crimtic
	public static Item crimticPick;
	public static Item crimticShovel;
	public static Item crimticAxe;
	public static Item crimticSword;
	public static Item crimticHoe;

	// Armor
	// Crimtic
	public static Item crimticHelmet;
	public static Item crimticChest;
	public static Item crimticLegs;
	public static Item crimticBoots;

	public static Item invsItem;

	// GUIs
	public static final int mCTableGUI = 0;
	public static final int deadCTableGUI = 1;
	public static final int mauveCTableGUI = 2;

	public static final int PACKET_TYPE_C2S_TEST = 628;
	public static final int PACKET_TYPE_ENTITY_SYNC = 629;

	public static Potion carminicPoison;

	// public static DamageSource cPoison = new
	// DamageSource("carminicPoison").setDamageBypassesArmor();

	// TODO: Config Shit
	// Spawnage
	public static boolean spawnHighLands;
	public static boolean spawnDeathForest;
	public static boolean spawnObsidianForest;
	public static boolean spawnGlassland;
	public static boolean spawnArctic;
	public static boolean spawnSnowyDesert;
	public static boolean spawnFlamage;
	public static boolean spawnVoid;
	public static boolean spawnFertile;
	public static boolean spawnBone;
	public static boolean spawnDeadLand;
	public static boolean spawnAutilField;
	public static boolean spawnAmethyst;
	public static boolean spawnAmethystGrove;
	public static boolean spawnHive;
	public static boolean spawnOcher;
	public static boolean spawnShadowHive;
	public static boolean spawnSlimy;

	// IDs
	public static int idHighLands;
	public static int idDeathForest;
	public static int idObsidianForest;
	public static int idGlassland;
	public static int idArctic;
	public static int idSnowyDesert;
	public static int idFlamage;
	public static int idVoid;
	public static int idFertile;
	public static int idBone;
	public static int idDeadLand;
	public static int idAutilField;
	public static int idAmethyst;
	public static int idAmethystGrove;
	public static int idHive;
	public static int idOcher;
	public static int idShadowHive;
	public static int idSlimy;

	// Dimensional Biome IDs
	public static int idCrimsonObsidian;
	public static int idCrimsonPlains;
	public static int idCrimsonForest;
	public static int idCrimsonMountains;
	public static int idCrimsonDesert;

	// Dimension IDs
	public static int crimsonId;

	// TODO: Preinit
	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent e) {
		networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(modid);
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();

		// Dimension
		crimsonId = config.get("Dimension ids", "Crimson", 100).getInt();

		// Spawnage
		spawnHighLands = config.get("Biomes", "Highlands", true).getBoolean();
		spawnDeathForest = config.get("Biomes", "DeathForest", true).getBoolean();
		spawnObsidianForest = config.get("Biomes", "ObsidianForest", true).getBoolean();
		spawnGlassland = config.get("Biomes", "Glassland", true).getBoolean();
		spawnArctic = config.get("Biomes", "Arctic", true).getBoolean();
		spawnSnowyDesert = config.get("Biomes", "SnowyDesert", true).getBoolean();
		spawnFlamage = config.get("Biomes", "Flamage", true).getBoolean();
		spawnVoid = config.get("Biomes", "Void", true).getBoolean();
		spawnFertile = config.get("Biomes", "Fertile", true).getBoolean();
		spawnBone = config.get("Biomes", "Bone", true, "").getBoolean();
		spawnDeadLand = config.get("Biomes", "DeadLand", true).getBoolean();
		spawnAutilField = config.get("Biomes", "AutilField", true).getBoolean();
		spawnAmethyst = config.get("Biomes", "Amethyst", true).getBoolean();
		spawnAmethystGrove = config.get("Biomes", "AmethystGrove", true).getBoolean();
		spawnHive = config.get("Biomes", "Hive", true).getBoolean();
		spawnOcher = config.get("Biomes", "Ocher", true).getBoolean();
		spawnShadowHive = config.get("Biomes", "ShadowHive", true).getBoolean();
		spawnSlimy = config.get("Biomes", "Slimy", true).getBoolean();

		// IDs
		idHighLands = config.get("Biome ids", "HighLands", 200).getInt();
		idDeathForest = config.get("Biome ids", "DeathForest", 201).getInt();
		idObsidianForest = config.get("Biome ids", "ObsidianForest", 202).getInt();
		idGlassland = config.get("Biome ids", "Glassland", 203).getInt();
		idArctic = config.get("Biome ids", "Arctic", 204).getInt();
		idSnowyDesert = config.get("Biome ids", "SnowyDesert", 205).getInt();
		idFlamage = config.get("Biome ids", "Flamage", 206).getInt();
		idVoid = config.get("Biome ids", "Void", 207).getInt();
		idFertile = config.get("Biome ids", "Fertile", 208).getInt();
		idBone = config.get("Biome ids", "Bone", 209).getInt();
		idDeadLand = config.get("Biome ids", "DeadLand", 210).getInt();
		idAutilField = config.get("Biome ids", "AutilField", 211).getInt();
		idAmethyst = config.get("Biome ids", "Amethyst", 212).getInt();
		idAmethystGrove = config.get("Biome ids", "AmethystGrove", 213).getInt();
		idHive = config.get("Biome ids", "Hive", 214).getInt();
		idOcher = config.get("Biome ids", "Ocher", 215).getInt();
		idShadowHive = config.get("Biome ids", "ShadowHive", 216).getInt();
		idSlimy = config.get("Biome ids", "Slimy", 217).getInt();

		// Biome Dimension IDs
		idCrimsonObsidian = config.get("Dimension Biome ids", "CrimsonObsidian", 218).getInt();
		idCrimsonPlains = config.get("Dimension Biome ids", "CrimsonPlains", 219).getInt();
		idCrimsonForest = config.get("Dimension Biome ids", "CrimsonForest", 220).getInt();
		idCrimsonMountains = config.get("Dimension Biome ids", "CrimsonMountains", 221).getInt();
		idCrimsonDesert = config.get("Deminsion Biome ids", "CrimsonDesert", 222).getInt();

		config.save();
		// log.info("Loaded config.");
		new CheckVersion();

		// TODO: Blocks
		// Other
		blueDirt = new BlueDirt(Material.ground).setBlockName("BlueDirt").setBlockTextureName("mod_ebm:blueDirt")
				.setHardness(1f).setResistance(1.25f).setStepSound(Block.soundTypeGravel).setCreativeTab(tab);

		blueFarmland = new BlueFarmland(Material.ground).setBlockName("BlueFarmland")
				.setBlockTextureName("mod_ebm:blueDirt").setHardness(.6f).setResistance(1.25f)
				.setStepSound(Block.soundTypeGravel).setCreativeTab(null);

		flameStone = new FlameStone(Material.rock, true, false, false, false).setBlockName("FlameStone")
				.setBlockTextureName("mod_ebm:flame_stone").setHardness(2f).setResistance(6f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		flameStoneDeactivated = new FlameStone(Material.rock, false, true, false, false).setBlockName("FlameStoneDe")
				.setBlockTextureName("mod_ebm:flame_stone_deactivated").setHardness(2f).setResistance(6f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		flameStoneBurnMobs = new FlameStone(Material.rock, false, false, true, false).setBlockName("FlameStoneMobs")
				.setBlockTextureName("mod_ebm:flame_stone_burn_mobs").setHardness(2f).setResistance(6f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		flameStoneBurnPlayers = new FlameStone(Material.rock, false, false, false, true)
				.setBlockName("FlameStonePlayers").setBlockTextureName("mod_ebm:flame_stone_burn_players")
				.setHardness(2f).setResistance(6f).setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		unstompableFarmland = new UnstompableFarmland(Material.ground).setBlockName("USFarmland")
				.setBlockTextureName("dirt").setHardness(.6f).setResistance(1.25f).setStepSound(Block.soundTypeGravel)
				.setCreativeTab(null);

		boneBlock = new BoneBlock(Material.rock).setBlockName("BoneBlock").setBlockTextureName("mod_ebm:bone_block")
				.setHardness(1f).setResistance(3f).setStepSound(Block.soundTypeStone).setCreativeTab(tab)
				.setLightOpacity(1);

		bloodBoneBlock = new BloodBoneBlock(Material.rock).setBlockName("BoneBlockBlood")
				.setBlockTextureName("mod_ebm:bone_block_blood").setHardness(1f).setResistance(3f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab).setLightOpacity(1);

		deadGrass = new DeadGrass().setBlockName("DeadGrass").setBlockTextureName("mod_ebm:dead_grass").setHardness(2f)
				.setResistance(2f).setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		deadDirt = new DeadDirt(Material.ground).setBlockName("DeadDirt").setBlockTextureName("mod_ebm:dirt_dead")
				.setHardness(2f).setResistance(2f).setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		dymusBlock = new ModBlocks(Material.ground).setBlockName("DymusBlock")
				.setBlockTextureName("mod_ebm:dymus_block").setHardness(3f).setResistance(3f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		autilBlock = new AutilBlock(Material.ground).setBlockName("AutilBlock")
				.setBlockTextureName("mod_ebm:autil_block").setHardness(1.4f).setResistance(7f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		autilBlockFull = new ModBlocks(Material.ground).setBlockName("AutilBlockFull")
				.setBlockTextureName("mod_ebm:autil_block").setHardness(2.8f).setResistance(7f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		autilRod = new AutilRod(Material.ground).setBlockName("AutilRod").setBlockTextureName("mod_ebm:autil_block")
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab).setHardness(0.0F).setLightLevel(0.9375F);

		amethystCrust = new AmethystCrust(Material.ground).setBlockName("AmethystCrust")
				.setBlockTextureName("mod_ebm:amethyst_crust").setStepSound(Block.soundTypeStone).setCreativeTab(tab)
				.setHardness(1.2f).setResistance(4.5f);

		amethystDirt = new AmethystDirt(Material.ground).setBlockName("AmethystDirt")
				.setBlockTextureName("mod_ebm:amethyst_dirt").setStepSound(Block.soundTypeGravel).setCreativeTab(tab)
				.setHardness(1f).setResistance(4.5f);

		honeycomb = new Honeycomb(Material.ground).setBlockName("honeycomb").setBlockTextureName("mod_ebm:honeycomb")
				.setStepSound(Block.soundTypeStone).setHardness(0.8f).setResistance(1f).setCreativeTab(tab);

		beeswax = new Beeswax(Material.ground).setBlockName("beeswax").setBlockTextureName("mod_ebm:beeswax")
				.setStepSound(Block.soundTypeGravel).setHardness(0.5f).setResistance(1f).setCreativeTab(tab);

		crystalHoneyBlock = new ModBlocks(Material.ground).setBlockName("crystalHoneyBlock")
				.setBlockTextureName("mod_ebm:honey_crystal_block").setStepSound(Block.soundTypeGlass).setHardness(1f)
				.setResistance(1.5f).setCreativeTab(tab);

		shadowHoneycomb = new Honeycomb(Material.ground).setBlockName("shadowHoneycomb")
				.setBlockTextureName("mod_ebm:honeycomb_shadow").setStepSound(Block.soundTypeStone).setHardness(0.9f)
				.setResistance(1.2f).setCreativeTab(tab);

		slimyGrass = new SlimyGrass().setBlockName("slimeGrass").setBlockTextureName("mod_ebm:slime_grass")
				.setHardness(0.6f).setStepSound(Block.soundTypeGrass).setCreativeTab(tab);

		crimsonObsidian = new CrimsonObsidian(Material.ground).setBlockName("redObsidian")
				.setBlockTextureName("mod_ebm:crimson_obsidian").setHardness(50f).setResistance(2000f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		crimsonStone = new CrimsonStone(Material.rock).setBlockName("crimsonStone")
				.setBlockTextureName("mod_ebm:crimson_stone").setHardness(1.2f).setResistance(10f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		crimsonCobblestone = new ModBlocks(Material.rock).setBlockName("crimsonCobble")
				.setBlockTextureName("mod_ebm:crimson_cobble").setHardness(2f).setResistance(5f)
				.setStepSound(Block.soundTypePiston).setCreativeTab(tab);

		crimsonGrass = new CrimsonGrass().setBlockName("crimsonGrass").setBlockTextureName("mod_ebm:crimson_grass")
				.setHardness(0.6f).setStepSound(Block.soundTypeGrass).setCreativeTab(tab);

		crimsonDirt = new CrimsonDirt(Material.ground).setBlockName("crimsonDirt").setBlockTextureName("dirt")
				.setHardness(0.5f).setStepSound(Block.soundTypeGravel).setCreativeTab(tab);

		crimsonSand = new CrimsonSand().setBlockName("crimsonSand").setBlockTextureName("mod_ebm:crimson_sand")
				.setHardness(0.5f).setStepSound(Block.soundTypeSand).setCreativeTab(tab);

		// TODO: Ores
		crimsoniteOre = new CrimsoniteOre().setBlockName("crimsoniteOre").setBlockTextureName("mod_ebm:ore_crimsonite")
				.setHardness(2.8f).setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		// Mineral Blocks
		crimticBlock = new CrimticBlock(Material.iron).setBlockName("crimticBlock")
				.setBlockTextureName("mod_ebm:block_crimtic").setHardness(3f).setStepSound(Block.soundTypeMetal)
				.setCreativeTab(tab);

		pyreBlock = new PyreBlock(Material.iron).setBlockName("pyreBlock").setBlockTextureName("mod_ebm:block_pyre")
				.setHardness(2f).setStepSound(Block.soundTypeMetal).setCreativeTab(tab);

		// Fires
		crimsonFire = new CrimsonFire(Material.ground);

		// Portals
		crimsonPortal = new CrimsonPortal().setBlockName("crimsonPortal").setBlockUnbreakable();

		// Plants
		beehive = new Beehive(Material.ground).setBlockName("beehive").setHardness(0.15f).setCreativeTab(tab)
				.setStepSound(Block.soundTypeStone).setBlockTextureName("stone").setLightOpacity(1);

		fireGrass = new ModGrass().setBlockName("fireGrass").setHardness(0.02f).setCreativeTab(tab)
				.setStepSound(Block.soundTypeGrass).setBlockTextureName("mod_ebm:grass_fire").setLightLevel(1f);

		slimeSpike = new SlimeSpike(Material.ground).setBlockName("slimeSpike").setHardness(0.1f).setCreativeTab(tab)
				.setStepSound(Block.soundTypeGravel).setBlockTextureName("mod_ebm:slime_grass_top").setLightOpacity(1);

		crimsonTallGrass = new ModGrass().setBlockName("crimsonTallGrass").setHardness(0f).setCreativeTab(tab)
				.setStepSound(Block.soundTypeGrass).setBlockTextureName("mod_ebm:grass_crimson_tall");

		crimsonBush = new ModGrass().setBlockName("crimsonBush").setHardness(0f).setCreativeTab(tab)
				.setStepSound(Block.soundTypeGrass).setBlockTextureName("mod_ebm:grass_crimson_bush");

		crimsonCactus = new CrimsonCactus().setBlockName("crimsonCactus").setHardness(0.4f).setCreativeTab(tab)
				.setStepSound(Block.soundTypeCloth).setBlockTextureName("mod_ebm:crimson_cactus_side");

		// Crops
		pyreFlower = new PyreFlower().setBlockName("PyreFlower").setBlockTextureName("mod_ebm:flower_pyre")
				.setHardness(0f);

		// Planks
		mPlanks = new MPlanks().setBlockName("mPlanks").setBlockTextureName("mod_ebm:planks_m")
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab).setHardness(2f).setResistance(5f);

		deadPlanks = new DeadPlanks().setBlockName("deadPlanks").setBlockTextureName("mod_ebm:planks_dead")
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab).setHardness(2f).setResistance(5f);

		mauvePlanks = new MauvewoodPlanks().setBlockName("mauvePlanks").setBlockTextureName("mod_ebm:planks_mauve")
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab).setHardness(2f).setResistance(5f);

		// Chests
		mChest = new ManchineelChest(0).setBlockName("mChest").setStepSound(Block.soundTypeWood).setCreativeTab(tab)
				.setHardness(2.5f);

		mChestTrapped = new ManchineelChest(1).setBlockName("mChestTrapped").setStepSound(Block.soundTypeWood)
				.setCreativeTab(tab).setHardness(2.5f);

		deadChest = new DeadwoodChest(0).setBlockName("deadChest").setStepSound(Block.soundTypeWood).setCreativeTab(tab)
				.setHardness(2.5f);

		deadChestTrapped = new DeadwoodChest(1).setBlockName("deadChestTrapped").setStepSound(Block.soundTypeWood)
				.setCreativeTab(tab).setHardness(2.5f);

		mauveChest = new MauvewoodChest(0).setBlockName("mauveChest").setStepSound(Block.soundTypeWood)
				.setCreativeTab(tab).setHardness(2.5f);

		mauveChestTrapped = new MauvewoodChest(1).setBlockName("mauveChestTrapped").setStepSound(Block.soundTypeWood)
				.setCreativeTab(tab).setHardness(2.5f);

		// Crafting Tables
		mCTable = new ManchineelWorkbench().setHardness(2.5f).setResistance(5f).setBlockName("mWorkbench")
				.setBlockTextureName("mod_ebm:m").setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		deadCTable = new DeadwoodWorkbench().setHardness(2.5f).setResistance(5f).setBlockName("deadWorkbench")
				.setBlockTextureName("mod_ebm:dead").setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		mauveCTable = new MauvewoodWorkbench().setHardness(2.5f).setResistance(5f).setBlockName("mauveWorkbench")
				.setBlockTextureName("mod_ebm:mauve").setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		// Trapdoors
		mTDoor = new ModTrapdoor(Material.wood).setBlockName("mTDoor").setBlockTextureName("mod_ebm:trapdoor_m")
				.setHardness(3f).setResistance(5f).setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		deadTDoor = new ModTrapdoor(Material.wood).setBlockName("deadTDoor")
				.setBlockTextureName("mod_ebm:trapdoor_dead").setHardness(3f).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		mauveTDoor = new ModTrapdoor(Material.wood).setBlockName("mauveTDoor")
				.setBlockTextureName("mod_ebm:trapdoor_mauve").setHardness(3f).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		// Secret Trapdoors
		mSTDoor = new ModTrapdoor(Material.wood).setBlockName("mSTDoor").setBlockTextureName("mod_ebm:planks_m")
				.setHardness(3f).setResistance(5f).setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		deadSTDoor = new ModTrapdoor(Material.wood).setBlockName("deadSTDoor")
				.setBlockTextureName("mod_ebm:planks_dead").setHardness(3f).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		mauveSTDoor = new ModTrapdoor(Material.wood).setBlockName("mauveSTDoor")
				.setBlockTextureName("mod_ebm:planks_mauve").setHardness(3f).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		// Fences
		mFence = new ManchineelFence("mod_ebm:planks_m", Material.wood).setBlockName("mFence").setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		deadFence = new DeadwoodFence("mod_ebm:planks_dead", Material.wood).setBlockName("deadFence").setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		mauveFence = new MauvewoodFence("mod_ebm:planks_mauve", Material.wood).setBlockName("mauveFence")
				.setResistance(5f).setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		// Fence Gates
		mFenceGate = new ManchineelFenceGate().setBlockName("mGate").setHardness(2.0F).setStepSound(Block.soundTypeWood)
				.setCreativeTab(tab);

		deadFenceGate = new DeadwoodFenceGate().setBlockName("deadGate").setHardness(2.0F)
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		mauveFenceGate = new MauvewoodFenceGate().setBlockName("mauveGate").setHardness(2.0F)
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		// Doors
		mDoor = new ManchineelDoor(Material.wood).setBlockName("mDoor").setStepSound(Block.soundTypeWood)
				.setHardness(3f).setResistance(5f);

		deadDoor = new DeadwoodDoor(Material.wood).setBlockName("deadDoor").setStepSound(Block.soundTypeWood)
				.setHardness(3f).setResistance(5f);

		mauvewoodDoor = new MauvewoodDoor(Material.wood).setBlockName("mauveDoor").setStepSound(Block.soundTypeWood)
				.setHardness(3f).setResistance(5f);

		// Ladders
		mLadder = new ModLadder().setBlockName("mLadder").setBlockTextureName("mod_ebm:ladder_m").setHardness(0.4f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		deadLadder = new ModLadder().setBlockName("deadLadder").setBlockTextureName("mod_ebm:ladder_dead")
				.setHardness(0.4f).setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		mauveLadder = new ModLadder().setBlockName("mauveLadder").setBlockTextureName("mod_ebm:ladder_mauve")
				.setHardness(0.4f).setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		// Torches
		mTorch = new ModTorch().setBlockName("mTorch").setStepSound(Block.soundTypeWood).setLightLevel(0.9375f)
				.setHardness(0f).setResistance(0f).setCreativeTab(tab).setBlockTextureName("mod_ebm:torch_m");

		deadTorch = new ModTorch().setBlockName("deadTorch").setStepSound(Block.soundTypeWood).setLightLevel(0.9375f)
				.setHardness(0f).setResistance(0f).setCreativeTab(tab).setBlockTextureName("mod_ebm:torch_dead");

		mauveTorch = new ModTorch().setBlockName("mauveTorch").setStepSound(Block.soundTypeWood).setLightLevel(0.9375f)
				.setHardness(0f).setResistance(0f).setCreativeTab(tab).setBlockTextureName("mod_ebm:torch_mauve");

		// Red Torches
		mTorchRed = new ManchineelRedTorch(true).setBlockName("mTorchRed").setStepSound(Block.soundTypeWood)
				.setHardness(0f).setResistance(0f).setCreativeTab(tab).setBlockTextureName("mod_ebm:torch_m_red");

		deadTorchRed = new DeadwoodRedTorch(true).setBlockName("deadTorchRed").setStepSound(Block.soundTypeWood)
				.setHardness(0f).setResistance(0f).setCreativeTab(tab).setBlockTextureName("mod_ebm:torch_dead_red");

		mauveTorchRed = new MauvewoodRedTorch(true).setBlockName("mauveTorchRed").setStepSound(Block.soundTypeWood)
				.setHardness(0f).setResistance(0f).setCreativeTab(tab).setBlockTextureName("mod_ebm:torch_mauve_red");

		// Red Torches Off
		mTorchRedOff = new ManchineelRedTorch(false).setBlockName("mTorchRedOff").setStepSound(Block.soundTypeWood)
				.setHardness(0f).setResistance(0f).setCreativeTab(null).setBlockTextureName("mod_ebm:torch_m_red_off");

		deadTorchRedOff = new DeadwoodRedTorch(false).setBlockName("deadTorchRedOff").setStepSound(Block.soundTypeWood)
				.setHardness(0f).setResistance(0f).setCreativeTab(null)
				.setBlockTextureName("mod_ebm:torch_dead_red_off");

		mauveTorchRedOff = new MauvewoodRedTorch(false).setBlockName("mauveTorchRedOff")
				.setStepSound(Block.soundTypeWood).setHardness(0f).setResistance(0f).setCreativeTab(null)
				.setBlockTextureName("mod_ebm:torch_mauve_red_off");

		// Pressure Plates
		mPlate = new ModPressurePlate("mod_ebm:planks_m", Material.wood, Sensitivity.everything).setCreativeTab(tab)
				.setBlockName("mPlate");

		deadPlate = new ModPressurePlate("mod_ebm:planks_dead", Material.wood, Sensitivity.everything)
				.setCreativeTab(tab).setBlockName("deadPlate");

		mauvePlate = new ModPressurePlate("mod_ebm:planks_mauve", Material.wood, Sensitivity.everything)
				.setCreativeTab(tab).setBlockName("mauvePlate");

		// Levers
		mLever = new ModLever().setHardness(0.5f).setBlockName("mLever").setBlockTextureName("mod_ebm:lever_m")
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		deadLever = new ModLever().setHardness(0.5f).setBlockName("deadLever").setBlockTextureName("mod_ebm:lever_dead")
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		mauveLever = new ModLever().setHardness(0.5f).setBlockName("mauveLever")
				.setBlockTextureName("mod_ebm:lever_mauve").setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		// Buttons
		mButton = new ManchineelButton(true).setCreativeTab(tab).setBlockName("mButton")
				.setBlockTextureName("mod_ebm:planks_m");

		deadButton = new DeadwoodButton(true).setCreativeTab(tab).setBlockName("deadButton")
				.setBlockTextureName("mod_ebm:planks_dead");

		mauveButton = new MauvewoodButton(true).setCreativeTab(tab).setBlockName("mauveButton")
				.setBlockTextureName("mod_ebm:planks_mauve");

		// Unbreakable shiz
		unAutilBricks = new ModBlocks(Material.ground).setBlockName("unAutilBricks")
				.setBlockTextureName("mod_ebm:autil_bricks").setBlockUnbreakable().setStepSound(Block.soundTypeStone)
				.setCreativeTab(tab);

		unAutilBrickStairs = new ModStairs(unAutilBricks, 0).setBlockName("unAutilBrickStairs")
				.setBlockTextureName("mod_ebm:autil_bricks").setBlockUnbreakable().setStepSound(Block.soundTypeStone)
				.setCreativeTab(tab);

		unAutilBrickPressurePlate = new ModPressurePlate("mod_ebm:autil_bricks", Material.ground, Sensitivity.players)
				.setBlockName("unAutilBrickPressurePlate").setBlockTextureName("mod_ebm:autil_bricks")
				.setBlockUnbreakable().setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		unAutilBrickSlab = new ModSlabs(false, Material.ground).setBlockName("unAutilBrickSlab")
				.setBlockTextureName("mod_ebm:autil_bricks").setBlockUnbreakable().setStepSound(Block.soundTypeStone)
				.setCreativeTab(tab);

		unAutilBrickSlabDouble = new ModSlabs(true, Material.ground).setBlockName("unAutilBrickSlabDouble")
				.setBlockTextureName("mod_ebm:autil_bricks").setBlockUnbreakable().setStepSound(Block.soundTypeStone);

		unAutilRod = new AutilRod(Material.ground).setBlockName("unAutilRod").setBlockTextureName("mod_ebm:autil_block")
				.setBlockUnbreakable().setStepSound(Block.soundTypeStone).setCreativeTab(tab).setLightLevel(0.9375F);

		// TODO: Fancy Shit
		// Dymus
		dymusBricks = new ModBlocks(Material.ground).setBlockName("DymusBricks")
				.setBlockTextureName("mod_ebm:dymus_bricks").setHardness(3f).setResistance(3f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		dymusOrnate = new ModBlocks(Material.ground).setBlockName("DymusOrnate")
				.setBlockTextureName("mod_ebm:dymus_ornate").setHardness(3f).setResistance(3f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		dymusPillar = new DymusPillar().setBlockName("DymusPillar").setBlockTextureName("mod_ebm:dymus_pillar_side")
				.setHardness(3f).setResistance(3f).setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		dymusChisel = new ModBlocks(Material.ground).setBlockName("dymusChisel")
				.setBlockTextureName("mod_ebm:dymus_chisel").setHardness(3f).setResistance(3f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		// Autil
		autilBricks = new ModBlocks(Material.ground).setBlockName("AutilBricks")
				.setBlockTextureName("mod_ebm:autil_bricks").setHardness(2.8f).setResistance(7f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		autilOrnate = new ModBlocks(Material.ground).setBlockName("AutilOrnate")
				.setBlockTextureName("mod_ebm:autil_ornate").setHardness(2.8f).setResistance(7f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		autilPillar = new AutilPillar().setBlockName("AutilPillar").setBlockTextureName("mod_ebm:autil_pillar_side")
				.setHardness(2.8f).setResistance(7f).setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		autilChisel = new ModBlocks(Material.ground).setBlockName("autilChisel")
				.setBlockTextureName("mod_ebm:autil_chisel").setHardness(2.8f).setResistance(7f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		// Amethyst
		amethystBricks = new ModBlocks(Material.ground).setBlockName("AmethystBricks")
				.setBlockTextureName("mod_ebm:amethyst_bricks").setHardness(1.2f).setResistance(4.5f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		amethystOrnate = new ModBlocks(Material.ground).setBlockName("AmethystOrnate")
				.setBlockTextureName("mod_ebm:amethyst_ornate").setHardness(1.2f).setResistance(4.5f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		amethystPillar = new AmethystPillar().setBlockName("AmethystPillar")
				.setBlockTextureName("mod_ebm:amethyst_pillar_side").setHardness(1.2f).setResistance(4.5f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		amethystChisel = new ModBlocks(Material.ground).setBlockName("amethystChisel")
				.setBlockTextureName("mod_ebm:amethyst_chisel").setHardness(1.2f).setResistance(4.5f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		// Beeswax
		beeswaxBricks = new ModBlocks(Material.ground).setBlockName("BeeswaxBricks")
				.setBlockTextureName("mod_ebm:beeswax_bricks").setHardness(0.5f).setResistance(1f)
				.setStepSound(Block.soundTypeGravel).setCreativeTab(tab);

		beeswaxOrnate = new ModBlocks(Material.ground).setBlockName("BeeswaxOrnate")
				.setBlockTextureName("mod_ebm:beeswax_ornate").setHardness(0.5f).setResistance(1f)
				.setStepSound(Block.soundTypeGravel).setCreativeTab(tab);

		beeswaxPillar = new BeeswaxPillar().setBlockName("BeeswaxPillar")
				.setBlockTextureName("mod_ebm:beeswax_pillar_side").setHardness(0.5f).setResistance(1f)
				.setStepSound(Block.soundTypeGravel).setCreativeTab(tab);

		beeswaxChisel = new ModBlocks(Material.ground).setBlockName("beeswaxChisel")
				.setBlockTextureName("mod_ebm:beeswax_chisel").setHardness(0.5f).setResistance(1f)
				.setStepSound(Block.soundTypeGravel).setCreativeTab(tab);

		// TODO: Slabs
		// Wooden
		mWoodSlab = new ModSlabs(false, Material.wood).setBlockName("mWoodSlab").setBlockTextureName("mod_ebm:planks_m")
				.setHardness(2f).setResistance(5f).setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		mWoodSlabDouble = new ModSlabs(true, Material.wood).setBlockName("mWoodSlabDouble")
				.setBlockTextureName("mod_ebm:planks_m").setHardness(2f).setResistance(5f)
				.setStepSound(Block.soundTypeWood);

		deadWoodSlab = new ModSlabs(false, Material.wood).setBlockName("deadWoodSlab")
				.setBlockTextureName("mod_ebm:planks_dead").setHardness(2f).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		deadWoodSlabDouble = new ModSlabs(true, Material.wood).setBlockName("deadWoodSlabDouble")
				.setBlockTextureName("mod_ebm:planks_dead").setHardness(2f).setResistance(5f)
				.setStepSound(Block.soundTypeWood);

		mauvewoodSlab = new ModSlabs(false, Material.wood).setBlockName("mauvewoodSlab")
				.setBlockTextureName("mod_ebm:planks_mauve").setHardness(2f).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		mauvewoodSlabDouble = new ModSlabs(true, Material.wood).setBlockName("mauvewoodSlabDouble")
				.setBlockTextureName("mod_ebm:planks_mauve").setHardness(2f).setResistance(5f)
				.setStepSound(Block.soundTypeWood);

		// Dymus
		dymusSlab = new ModSlabs(false, Material.ground).setBlockName("DymusSlab")
				.setBlockTextureName("mod_ebm:dymus_block").setHardness(2f).setResistance(3f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		dymusSlabDouble = new ModSlabs(true, Material.ground).setBlockName("DymusSlabDouble")
				.setBlockTextureName("mod_ebm:dymus_block").setHardness(3f).setResistance(3f)
				.setStepSound(Block.soundTypeStone);

		dymusOrnateSlab = new ModSlabs(false, Material.ground).setBlockName("DymusOrnateSlab")
				.setBlockTextureName("mod_ebm:dymus_ornate").setHardness(2f).setResistance(3f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		dymusOrnateSlabDouble = new ModSlabs(true, Material.ground).setBlockName("DymusOrnateSlabDouble")
				.setBlockTextureName("mod_ebm:dymus_ornate").setHardness(3f).setResistance(3f)
				.setStepSound(Block.soundTypeStone);

		dymusBrickSlab = new ModSlabs(false, Material.ground).setBlockName("DymusBrickSlab")
				.setBlockTextureName("mod_ebm:dymus_bricks").setHardness(2f).setResistance(3f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		dymusBrickSlabDouble = new ModSlabs(true, Material.ground).setBlockName("DymusBrickSlabDouble")
				.setBlockTextureName("mod_ebm:dymus_bricks").setHardness(3f).setResistance(3f)
				.setStepSound(Block.soundTypeStone);

		dymusChiselSlab = new ModSlabs(false, Material.ground).setBlockName("dymusChiselSlab")
				.setBlockTextureName("mod_ebm:dymus_chisel").setHardness(2f).setResistance(3f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		dymusChiselSlabDouble = new ModSlabs(true, Material.ground).setBlockName("dymusChiselSlabDouble")
				.setBlockTextureName("mod_ebm:dymus_chisel").setHardness(2f).setResistance(3f)
				.setStepSound(Block.soundTypeStone);

		// Autil
		autilSlab = new ModSlabs(false, Material.ground).setBlockName("AutilSlab")
				.setBlockTextureName("mod_ebm:autil_block").setHardness(2.8f).setResistance(7f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		autilSlabDouble = new ModSlabs(true, Material.ground).setBlockName("AutilSlabDouble")
				.setBlockTextureName("mod_ebm:autil_block").setHardness(2.8f).setResistance(7f)
				.setStepSound(Block.soundTypeStone);

		autilOrnateSlab = new ModSlabs(false, Material.ground).setBlockName("AutilOrnateSlab")
				.setBlockTextureName("mod_ebm:autil_ornate").setHardness(2.8f).setResistance(7f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		autilOrnateSlabDouble = new ModSlabs(true, Material.ground).setBlockName("AutilOrnateSlabDouble")
				.setBlockTextureName("mod_ebm:autil_ornate").setHardness(2.8f).setResistance(7f)
				.setStepSound(Block.soundTypeStone);

		autilBrickSlab = new ModSlabs(false, Material.ground).setBlockName("AutilBrickSlab")
				.setBlockTextureName("mod_ebm:autil_bricks").setHardness(2.8f).setResistance(7f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		autilBrickSlabDouble = new ModSlabs(true, Material.ground).setBlockName("AutilBrickSlabDouble")
				.setBlockTextureName("mod_ebm:autil_bricks").setHardness(2.8f).setResistance(7f)
				.setStepSound(Block.soundTypeStone);

		autilChiselSlab = new ModSlabs(false, Material.ground).setBlockName("autilChiselSlab")
				.setBlockTextureName("mod_ebm:autil_chisel").setHardness(2.8f).setResistance(7f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		autilChiselSlabDouble = new ModSlabs(true, Material.ground).setBlockName("autilChiselSlabDouble")
				.setBlockTextureName("mod_ebm:autil_chisel").setHardness(2.8f).setResistance(7f)
				.setStepSound(Block.soundTypeStone);

		// Amethyst
		amethystSlab = new ModSlabs(false, Material.ground).setBlockName("AmethystSlab")
				.setBlockTextureName("mod_ebm:amethyst_crust").setHardness(1.2f).setResistance(4.5f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		amethystSlabDouble = new ModSlabs(true, Material.ground).setBlockName("AmethystSlabDouble")
				.setBlockTextureName("mod_ebm:amethyst_crust").setHardness(1.2f).setResistance(4.5f)
				.setStepSound(Block.soundTypeStone);

		amethystOrnateSlab = new ModSlabs(false, Material.ground).setBlockName("AmethystOrnateSlab")
				.setBlockTextureName("mod_ebm:amethyst_ornate").setHardness(1.2f).setResistance(4.5f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		amethystOrnateSlabDouble = new ModSlabs(true, Material.ground).setBlockName("AmethystOrnateSlabDouble")
				.setBlockTextureName("mod_ebm:amethyst_ornate").setHardness(1.2f).setResistance(4.5f)
				.setStepSound(Block.soundTypeStone);

		amethystBrickSlab = new ModSlabs(false, Material.ground).setBlockName("AmethystBrickSlab")
				.setBlockTextureName("mod_ebm:amethyst_bricks").setHardness(1.2f).setResistance(4.5f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		amethystBrickSlabDouble = new ModSlabs(true, Material.ground).setBlockName("AmethystBrickSlabDouble")
				.setBlockTextureName("mod_ebm:amethyst_bricks").setHardness(1.2f).setResistance(4.5f)
				.setStepSound(Block.soundTypeStone);

		amethystChiselSlab = new ModSlabs(false, Material.ground).setBlockName("amethystChiselSlab")
				.setBlockTextureName("mod_ebm:amethyst_chisel").setHardness(1.2f).setResistance(4.5f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		amethystChiselSlabDouble = new ModSlabs(true, Material.ground).setBlockName("amethystChiselSlabDouble")
				.setBlockTextureName("mod_ebm:amethyst_chisel").setHardness(1.2f).setResistance(4.5f)
				.setStepSound(Block.soundTypeStone);

		// Bone
		boneSlab = new ModSlabs(false, Material.ground).setBlockName("BoneSlab")
				.setBlockTextureName("mod_ebm:bone_block").setHardness(1f).setResistance(3f)
				.setStepSound(Block.soundTypeStone).setLightOpacity(1).setCreativeTab(tab);

		boneSlabDouble = new ModSlabs(true, Material.ground).setBlockName("BoneSlabDouble")
				.setBlockTextureName("mod_ebm:bone_block").setHardness(1f).setResistance(3f)
				.setStepSound(Block.soundTypeStone).setLightLevel(1);

		// Beeswax
		beeswaxSlab = new ModSlabs(false, Material.ground).setBlockName("BeeswaxSlab")
				.setBlockTextureName("mod_ebm:beeswax").setHardness(0.5f).setResistance(1f)
				.setStepSound(Block.soundTypeGravel).setCreativeTab(tab);

		beeswaxSlabDouble = new ModSlabs(true, Material.ground).setBlockName("BeeswaxSlabDouble")
				.setBlockTextureName("mod_ebm:beeswax").setHardness(0.5f).setResistance(1f)
				.setStepSound(Block.soundTypeGravel);

		beeswaxOrnateSlab = new ModSlabs(false, Material.ground).setBlockName("BeeswaxOrnateSlab")
				.setBlockTextureName("mod_ebm:beeswax_ornate").setHardness(0.5f).setResistance(1f)
				.setStepSound(Block.soundTypeGravel).setCreativeTab(tab);

		beeswaxOrnateSlabDouble = new ModSlabs(true, Material.ground).setBlockName("BeeswaxOrnateSlabDouble")
				.setBlockTextureName("mod_ebm:beeswax_ornate").setHardness(0.5f).setResistance(1f)
				.setStepSound(Block.soundTypeGravel);

		beeswaxBrickSlab = new ModSlabs(false, Material.ground).setBlockName("BeeswaxBrickSlab")
				.setBlockTextureName("mod_ebm:beeswax_bricks").setHardness(0.5f).setResistance(1f)
				.setStepSound(Block.soundTypeGravel).setCreativeTab(tab);

		beeswaxBrickSlabDouble = new ModSlabs(true, Material.ground).setBlockName("BeeswaxBrickSlabDouble")
				.setBlockTextureName("mod_ebm:beeswax_bricks").setHardness(0.5f).setResistance(1f)
				.setStepSound(Block.soundTypeGravel);

		beeswaxChiselSlab = new ModSlabs(false, Material.ground).setBlockName("beeswaxChiselSlab")
				.setBlockTextureName("mod_ebm:beeswax_chisel").setHardness(0.5f).setResistance(1f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		beeswaxChiselSlabDouble = new ModSlabs(true, Material.ground).setBlockName("beeswaxChiselSlabDouble")
				.setBlockTextureName("mod_ebm:beeswax_chisel").setHardness(0.5f).setResistance(1f)
				.setStepSound(Block.soundTypeStone);

		// TODO: Stairs
		// Wooden
		mWoodStairs = new ModStairs(mPlanks, 0).setBlockName("mWoodStairs").setBlockTextureName("mod_ebm:planks_m")
				.setHardness(3f).setResistance(5f).setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		deadWoodStairs = new ModStairs(deadPlanks, 0).setBlockName("deadWoodStairs")
				.setBlockTextureName("mod_ebm:planks_dead").setHardness(3f).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		mauvewoodStairs = new ModStairs(mauvePlanks, 0).setBlockName("mauvewoodStairs")
				.setBlockTextureName("mod_ebm:planks_mauvewood").setHardness(3f).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		// Dymus
		dymusStairs = new ModStairs(dymusBlock, 0).setBlockName("DymusStairs")
				.setBlockTextureName("mod_ebm:dymus_block").setHardness(3f).setResistance(3f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		dymusOrnateStairs = new ModStairs(dymusOrnate, 0).setBlockName("DymusOrnateStairs")
				.setBlockTextureName("mod_ebm:dymus_ornate").setHardness(3f).setResistance(3f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		dymusBrickStairs = new ModStairs(dymusBricks, 0).setBlockName("DymusBrickStairs")
				.setBlockTextureName("mod_ebm:dymus_bricks").setHardness(3f).setResistance(3f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		dymusChiselStairs = new ModStairs(dymusChisel, 0).setBlockName("dymusChiselStairs")
				.setBlockTextureName("mod_ebm:dymus_chisel").setHardness(3f).setResistance(3f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		// Autil
		autilStairs = new ModStairs(autilBlockFull, 0).setBlockName("AutilStairs")
				.setBlockTextureName("mod_ebm:autil_block").setHardness(2.8f).setResistance(7f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		autilOrnateStairs = new ModStairs(autilOrnate, 0).setBlockName("AutilOrnateStairs")
				.setBlockTextureName("mod_ebm:autil_ornate").setHardness(2.8f).setResistance(7f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		autilBrickStairs = new ModStairs(autilBricks, 0).setBlockName("AutilBrickStairs")
				.setBlockTextureName("mod_ebm:autil_bricks").setHardness(2.8f).setResistance(7f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		autilChiselStairs = new ModStairs(autilChisel, 0).setBlockName("autilChiselStairs")
				.setBlockTextureName("mod_ebm:autil_chisel").setHardness(2.8f).setResistance(7f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		// Amethyst
		amethystStairs = new ModStairs(amethystCrust, 0).setBlockName("AmethystStairs")
				.setBlockTextureName("mod_ebm:amethyst_crust").setHardness(1.2f).setResistance(4.5f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		amethystOrnateStairs = new ModStairs(amethystOrnate, 0).setBlockName("AmethystOrnateStairs")
				.setBlockTextureName("mod_ebm:amethyst_ornate").setHardness(1.2f).setResistance(4.5f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		amethystBrickStairs = new ModStairs(amethystBricks, 0).setBlockName("AmethystBrickStairs")
				.setBlockTextureName("mod_ebm:amethyst_bricks").setHardness(1.2f).setResistance(4.5f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		amethystChiselStairs = new ModStairs(amethystChisel, 0).setBlockName("amethystChiselStairs")
				.setBlockTextureName("mod_ebm:amethyst_chisel").setHardness(1.2f).setResistance(4.5f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		// Bone
		boneStairs = new ModStairs(boneBlock, 0).setBlockName("BoneStairs").setBlockTextureName("mod_ebm:bone_block")
				.setHardness(1f).setResistance(3f).setStepSound(Block.soundTypeStone).setCreativeTab(tab)
				.setLightOpacity(1);

		// Beeswax
		beeswaxStairs = new ModStairs(beeswax, 0).setBlockName("BeeswaxStairs").setBlockTextureName("mod_ebm:beeswax")
				.setHardness(0.5f).setResistance(1f).setStepSound(Block.soundTypeGravel).setCreativeTab(tab);

		beeswaxOrnateStairs = new ModStairs(beeswaxOrnate, 0).setBlockName("BeeswaxOrnateStairs")
				.setBlockTextureName("mod_ebm:beeswax_ornate").setHardness(0.5f).setResistance(1f)
				.setStepSound(Block.soundTypeGravel).setCreativeTab(tab);

		beeswaxBrickStairs = new ModStairs(beeswaxBricks, 0).setBlockName("BeeswaxBrickStairs")
				.setBlockTextureName("mod_ebm:beeswax_bricks").setHardness(0.5f).setResistance(1f)
				.setStepSound(Block.soundTypeGravel).setCreativeTab(tab);

		beeswaxChiselStairs = new ModStairs(beeswaxChisel, 0).setBlockName("beeswaxChiselStairs")
				.setBlockTextureName("mod_ebm:beeswax_chisel").setHardness(0.5f).setResistance(1f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab);

		// Logs
		glassLog = new GlassLog().setBlockName("GlassLog").setHardness(2f).setResistance(3.333f)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(tab).setLightOpacity(1);

		boneLog = new BoneLog(Material.ground).setBlockName("BoneLog").setBlockTextureName("mod_ebm:bone_block")
				.setHardness(1f).setResistance(3.333f).setStepSound(Block.soundTypeStone).setCreativeTab(tab)
				.setLightOpacity(1);

		boneLogBlood = new BoneLog(Material.ground).setBlockName("boneLogBlood")
				.setBlockTextureName("mod_ebm:bone_block_blood").setHardness(1f).setResistance(3.333f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab).setLightOpacity(1);

		mLog = new MLog().setBlockName("mLog").setHardness(3f).setResistance(3.333f).setStepSound(Block.soundTypeWood)
				.setCreativeTab(tab);

		deadLog = new DeadLog().setBlockName("deadLog").setHardness(3f).setResistance(3.333f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		mauvewoodLog = new MauvewoodLog().setBlockName("MauvewoodLog").setHardness(3f).setResistance(3.333f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(tab);

		// Leaves
		glassLeaves = new GlassLeaves(Material.leaves).setBlockName("leaves_glass")
				.setBlockTextureName("mod_ebm:leaves_glass").setHardness(.2f).setResistance(.3f)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(tab).setLightOpacity(1);

		mLeaves = new MLeaves().setBlockName("leaves_m").setBlockTextureName("mod_ebm:leaves_m").setHardness(.2f)
				.setResistance(.3f).setStepSound(Block.soundTypeGrass).setCreativeTab(tab);

		mauvewoodLeaves = new MauvewoodLeaves().setBlockName("leaves_mauvewood")
				.setBlockTextureName("mod_ebm:leaves_mauvewood").setHardness(.2f).setResistance(.3f)
				.setStepSound(Block.soundTypeGrass).setCreativeTab(tab);

		// Saplings
		glassSapling = new GlassSapling().setBlockName("GlassSapling").setBlockTextureName("glass").setHardness(0f)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(tab).setLightOpacity(1);

		boneSapling = new BoneSapling().setBlockName("BoneSapling").setBlockTextureName("bone").setHardness(0f)
				.setStepSound(Block.soundTypeStone).setCreativeTab(tab).setLightOpacity(1);

		mSapling = new mSapling().setBlockName("mSapling").setBlockTextureName("sapling_m").setHardness(0f)
				.setStepSound(Block.soundTypeGrass).setCreativeTab(tab).setLightOpacity(1);

		mauvewoodSapling = new MauvewoodSapling().setBlockName("MauvewoodSapling")
				.setBlockTextureName("sapling_mauvewood").setHardness(0f).setStepSound(Block.soundTypeGrass)
				.setCreativeTab(tab).setLightOpacity(1);
		// log.info("Loaded blocks.");

		// TODO: Items
		// Other
		ebmWrench = new Item().setUnlocalizedName("EBMWrench").setTextureName("mod_ebm:wrench").setCreativeTab(tab)
				.setMaxStackSize(1);

		dymusPowder = new Item().setUnlocalizedName("DymusPowder").setTextureName("mod_ebm:dymus_powder")
				.setCreativeTab(tab);

		dymusBar = new Item().setUnlocalizedName("DymusBar").setTextureName("mod_ebm:bar_dymus").setCreativeTab(tab);

		dust = new Item().setUnlocalizedName("Dust").setTextureName("mod_ebm:dust").setCreativeTab(tab);

		autil = new Item().setUnlocalizedName("Autil").setTextureName("mod_ebm:autil").setCreativeTab(tab);

		erythonCube = new ErythonCube().setUnlocalizedName("ECube").setTextureName("mod_ebm:erython_cube")
				.setCreativeTab(tab);

		amethystGrit = new Item().setUnlocalizedName("AmethystGrit").setTextureName("mod_ebm:grit_amethyst")
				.setCreativeTab(tab);

		honey = new ItemFood(1, false).setUnlocalizedName("honey").setTextureName("mod_ebm:honey").setCreativeTab(tab);

		crystalHoney = new ItemFood(2, false).setUnlocalizedName("crystalHoney").setTextureName("mod_ebm:crystal_honey")
				.setCreativeTab(tab);

		bee = new Item().setUnlocalizedName("bee").setTextureName("mod_ebm:bee").setCreativeTab(tab);

		stinger = new Item().setUnlocalizedName("stinger").setTextureName("mod_ebm:stinger").setCreativeTab(tab);

		pyreCrystal = new Item().setUnlocalizedName("pyreCrystal").setTextureName("mod_ebm:crystal_pyre")
				.setCreativeTab(tab);

		bloodBone = new Item().setUnlocalizedName("bloodBone").setTextureName("mod_ebm:bloody_bone")
				.setCreativeTab(tab);

		crimsonFiber = new Item().setUnlocalizedName("crimsonFiber").setTextureName("mod_ebm:crimson_fiber")
				.setCreativeTab(tab);

		crimsonString = new Item().setUnlocalizedName("crimsonString").setTextureName("mod_ebm:crimson_string")
				.setCreativeTab(tab);

		// Ingots
		crimticIngot = new Item().setUnlocalizedName("crimticIngot").setTextureName("mod_ebm:ingot_crimtic")
				.setCreativeTab(tab);

		pyreIngot = new Item().setUnlocalizedName("pyreIngot").setTextureName("mod_ebm:ingot_pyre").setCreativeTab(tab);

		// Nuggets
		crimticNugget = new Item().setUnlocalizedName("crimticNugget").setTextureName("mod_ebm:nugget_crimtic")
				.setCreativeTab(tab);

		// Dusts
		crimticDust = new Item().setUnlocalizedName("crimticDust").setTextureName("mod_ebm:dust_crimtic")
				.setCreativeTab(tab);

		// Sticks
		mStick = new Item().setUnlocalizedName("mStick").setTextureName("mod_ebm:stick_m").setCreativeTab(tab);

		deadStick = new Item().setUnlocalizedName("deadStick").setTextureName("mod_ebm:stick_dead").setCreativeTab(tab);

		mauveStick = new Item().setUnlocalizedName("mauveStick").setTextureName("mod_ebm:stick_mauve")
				.setCreativeTab(tab);

		// Door Items
		mDoorItem = new ManchineelDoorItem(Material.wood).setCreativeTab(tab).setTextureName("mod_ebm:door_m")
				.setUnlocalizedName("mDoorItem");

		deadDoorItem = new DeadwoodDoorItem(Material.wood).setCreativeTab(tab).setTextureName("mod_ebm:door_dead")
				.setUnlocalizedName("deadDoorItem");

		mauvewoodDoorItem = new MauvewoodDoorItem(Material.wood).setCreativeTab(tab)
				.setTextureName("mod_ebm:door_mauvewood").setUnlocalizedName("mauveDoorItem");

		// Records
		cd_hskele = new DiscHskele("Happy Skeleton").setUnlocalizedName("cd_hskele")
				.setTextureName("mod_ebm:cd_happy_skeleton").setCreativeTab(tab);

		// Seeds
		fireSeed = new FireSeeds(pyreFlower, flameStone).setTextureName("mod_ebm:seeds_fire")
				.setUnlocalizedName("FireSeed").setCreativeTab(tab);

		// Tools / Weapons
		ToolMaterial tool_erython = EnumHelper.addToolMaterial("tool_erython", 2, 300, 4F, 4F, 15);
		ToolMaterial tool_stinger = EnumHelper.addToolMaterial("tool_stinger", 2, 150, 3.5f, 4.5f, 15);
		ToolMaterial tool_fire = EnumHelper.addToolMaterial("tool_fire", 2, 350, 3.5f, 4.3f, 15);
		ToolMaterial tool_crimtic = EnumHelper.addToolMaterial("tool_crimtic", 3, 550, 8f, 5f, 30);

		erythonBattleAxe = new Sword(tool_erython).setTextureName("mod_ebm:axe_battle_erython").setCreativeTab(tab)
				.setUnlocalizedName("ErythonBattleAxe");

		glassShard = new GlassShard(ToolMaterial.STONE).setUnlocalizedName("GlassShard")
				.setTextureName("mod_ebm:shard_glass").setCreativeTab(tab);

		stingerSword = new Sword(tool_stinger).setTextureName("mod_ebm:sword_stinger").setCreativeTab(tab)
				.setUnlocalizedName("stingerSword");

		fireSword = new Sword(tool_fire).setTextureName("mod_ebm:sword_fire").setCreativeTab(tab)
				.setUnlocalizedName("fireSword");

		crimsonBow = new CrimsonBow().setTextureName("mod_ebm.crimson_bow").setCreativeTab(tab)
				.setUnlocalizedName("crimsonBow");

		// Crimtic
		crimticPick = new Pick(tool_crimtic).setUnlocalizedName("crimticPick").setTextureName("mod_ebm:pickaxe_crimtic")
				.setCreativeTab(tab);

		crimticShovel = new Shovel(tool_crimtic).setUnlocalizedName("crimticShovel")
				.setTextureName("mod_ebm:shovel_crimtic").setCreativeTab(tab);

		crimticAxe = new Axe(tool_crimtic).setUnlocalizedName("crimticAxe").setTextureName("mod_ebm:axe_crimtic")
				.setCreativeTab(tab);

		crimticSword = new Sword(tool_crimtic).setUnlocalizedName("crimticSword")
				.setTextureName("mod_ebm:sword_crimtic").setCreativeTab(tab);

		crimticHoe = new Hoe(tool_crimtic).setUnlocalizedName("crimticHoe").setTextureName("mod_ebm:hoe_crimtic")
				.setCreativeTab(tab);

		// Armor
		ArmorMaterial armor_crimtic = EnumHelper.addArmorMaterial("armor_crimtic", 20, new int[] { 4, 6, 5, 3 }, 30);

		// Crimtic
		crimticHelmet = new CrimticArmor(armor_crimtic, 5, 0).setUnlocalizedName("crimticHelmet")
				.setTextureName("mod_ebm:helmet_crimtic").setCreativeTab(tab);

		crimticChest = new CrimticArmor(armor_crimtic, 5, 1).setUnlocalizedName("crimticChest")
				.setTextureName("mod_ebm:chestplate_crimtic").setCreativeTab(tab);

		crimticLegs = new CrimticArmor(armor_crimtic, 5, 2).setUnlocalizedName("crimticLegs")
				.setTextureName("mod_ebm:leggings_crimtic").setCreativeTab(tab);

		crimticBoots = new CrimticArmor(armor_crimtic, 5, 3).setUnlocalizedName("crimticBoots")
				.setTextureName("mod_ebm:boots_crimtic").setCreativeTab(tab);

		// Technical
		invsItem = new Item().setTextureName("mod_ebm:invs").setUnlocalizedName("InvsItem");
		// log.info("Loaded items.");

		// Status Effects
		carminicPoison = new CarminicPoison(30, true, 0).setIconIndex(0, 0).setPotionName("potion.carminicPoison");

		// Biomes
		new BiomeRegistry().main();
		// log.info("Loaded biomes.");

		FMLCommonHandler.instance().bus().register(new OtherEvents());
		FMLCommonHandler.instance().bus().register(new AchievementHandler());
		FMLCommonHandler.instance().bus().register(new PlayerHandler());
		MinecraftForge.EVENT_BUS.register(new OtherEvents());
		MinecraftForge.EVENT_BUS.register(new ChatEvent());
		MinecraftForge.EVENT_BUS.register(new HoeEvent());
		MinecraftForge.EVENT_BUS.register(new EffectEvent());
		NetworkRegistry.INSTANCE.registerGuiHandler(mod_ebm.instance, new GUIHandler());

		if (idt) {
			MinecraftForge.EVENT_BUS.register(new ChiselEvent());
		}

		if (Loader.isModLoaded("craftingpillars")) {
			CraftingPillarEBMAPI.CraftingPillarEBMAPI();
		}

		channel = NetworkRegistry.INSTANCE.newEventDrivenChannel(networkChannelName);
		channel.register(new ServerPacketHandler());
		channel.register(new ClientPacketHandler());
		// log.info("Registered event busses.");
	}

	// TODO: Everything Else
	@Mod.EventHandler
	public static void load(FMLInitializationEvent e) {
		gameRegistry();
		OreDictionaryRegistry.oreDictionary();
		TileEntityRegistry.tileEntityRegistry();
		proxy.registerRenders();
	}

	public static CreativeTabs tab = new ModCreativeTabs("ecb");
	public static SimpleNetworkWrapper networkWrapper;

	public static void gameRegistry() {
		MobRegistry.preInit();

		BlockRegistry.registerBlocks();
		ItemRegistry.registerItems();

		ChestHookHandler.addHooks();

		BlockRecipeHandler.registerCrafting();
		BlockRecipeHandler.registerSmelting();

		ItemRecipeHandler.registerCrafting();
		ItemRecipeHandler.registerSmelting();

		ArmorRecipeHandler.registerRecipes();
		ToolRecipeHandler.registerRecipes();

		DimensionHandler.mainRegistry();

		AchRegistry.registerAch();
		AchRegistry.nameAch();
	}

	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent e) {
	}

	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent e) {
		MinecraftServer server = MinecraftServer.getServer();
		ICommandManager command = server.getCommandManager();
		ServerCommandManager cmd = (ServerCommandManager) command;

		cmd.registerCommand(new News());
		cmd.registerCommand(new Bug());
		cmd.registerCommand(new Support());
		cmd.registerCommand(new Wiki());
	}
}
