package ebm.com.mce.blocks;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.util.List;
import java.util.Random;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockPotato;
import net.minecraft.block.BlockReed;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockStem;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ModBlocks extends Block {
	public ModBlocks(Material mat) {
		super(mat);
	}

	public static class BlueDirt extends Block {
		public BlueDirt(Material mat) {
			super(mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(this, 1, 0));
		}

		public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction,
				IPlantable p) {
			if (p.getPlant(world, x, y, z) instanceof BlockSapling || p.getPlant(world, x, y, z) == Blocks.reeds
					|| p.getPlant(world, x, y, z) instanceof BlockFlower
					|| p.getPlant(world, x, y, z) instanceof BlockTallGrass
					|| p.getPlant(world, x, y, z) instanceof BlockDoublePlant
					|| p.getPlant(world, x, y, z) instanceof BlockMushroom
					|| p.getPlant(world, x, y, z) instanceof BlockBush) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static class BlueFarmland extends BlockFarmland {
		private IIcon top;

		public BlueFarmland(Material mat) {
			super();
			this.setTickRandomly(true);
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
			this.setLightOpacity(255);
		}

		public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
			return AxisAlignedBB.getBoundingBox((double) (x + 0), (double) (y + 0), (double) (z + 0), (double) (x + 1),
					(double) (y + 1), (double) (z + 1));
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public boolean renderAsNormalBlock() {
			return false;
		}

		public void updateTick(World world, int x, int y, int z, Random rand) {
			if (!this.hydrate(world, x, y, z) && !world.canLightningStrikeAt(x, y + 1, z)) {
				int l = world.getBlockMetadata(x, y, z);

				if (l > 0) {
					world.setBlockMetadataWithNotify(x, y, z, l - 1, 2);
				} else if (!this.plant(world, x, y, z)) {
					world.setBlock(x, y, z, mod_ebm.blueDirt);
				}
			} else {
				world.setBlockMetadataWithNotify(x, y, z, 7, 2);
			}
		}

		public void onFallenUpon(World world, int x, int y, int z, Entity entity, float f) {
			if (!world.isRemote && world.rand.nextFloat() < f - 0.5F) {
				if (!(entity instanceof EntityPlayer) && !world.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
					return;
				}

				world.setBlock(x, y, z, mod_ebm.blueDirt);
			}
		}

		private boolean plant(World world, int x, int y, int z) {
			byte b0 = 0;

			for (int l = x - b0; l <= x + b0; ++l) {
				for (int i1 = z - b0; i1 <= z + b0; ++i1) {
					Block block = world.getBlock(l, y + 1, i1);

					if (block instanceof IPlantable
							&& canSustainPlant(world, x, y, z, ForgeDirection.UP, (IPlantable) block)) {
						return true;
					}
				}
			}

			return false;
		}

		private boolean hydrate(World world, int x, int y, int z) {
			return true;
		}

		public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction,
				IPlantable p) {
			if (p.getPlant(world, x, y, z) == Blocks.reeds || p.getPlant(world, x, y, z) instanceof BlockCrops
					|| p.getPlant(world, x, y, z) instanceof BlockPotato
					|| p.getPlant(world, x, y, z) instanceof BlockCarrot
					|| p.getPlant(world, x, y, z) instanceof BlockReed
					|| p.getPlant(world, x, y, z) instanceof BlockStem) {
				if (p.getPlant(world, x, y, z) == mod_ebm.pyreFlower) {
					return false;
				}

				return true;
			} else {
				return false;
			}
		}

		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			super.onNeighborBlockChange(world, x, y, z, block);
			Material material = world.getBlock(x, y + 1, z).getMaterial();

			if (material.isSolid()) {
				world.setBlock(x, y, z, mod_ebm.blueDirt);
			}
		}

		public IIcon getIcon(int i, int j) {
			return i == 1 ? this.top : mod_ebm.blueDirt.getBlockTextureFromSide(i);
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			return mod_ebm.blueDirt.getItemDropped(0, rand, meta);
		}

		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_ebm.blueDirt);
		}

		public void registerBlockIcons(IIconRegister icon) {
			this.top = icon.registerIcon("mod_ebm:blueFarmland_top");
		}
	}

	public static class UnstompableFarmland extends BlockFarmland {
		private IIcon wet;
		private IIcon dry;

		public UnstompableFarmland(Material mat) {
			super();
			this.setTickRandomly(true);
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
			this.setLightOpacity(255);
		}

		public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
			return AxisAlignedBB.getBoundingBox((double) (x + 0), (double) (y + 0), (double) (z + 0), (double) (x + 1),
					(double) (y + 1), (double) (z + 1));
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public boolean renderAsNormalBlock() {
			return false;
		}

		public void updateTick(World world, int x, int y, int z, Random rand) {
			if (!this.hydrate(world, x, y, z) && !world.canLightningStrikeAt(x, y + 1, z)) {
				int l = world.getBlockMetadata(x, y, z);

				if (l > 0) {
					world.setBlockMetadataWithNotify(x, y, z, l - 1, 2);
				} /*
					 * else if (!this.plant(world, x, y, z)) { world.setBlock(x,
					 * y, z, Blocks.dirt); }
					 */

			} else {
				world.setBlockMetadataWithNotify(x, y, z, 7, 2);
			}
		}

		public void onFallenUpon(World world, int x, int y, int z, Entity e, float f) {
			if (!world.isRemote && world.rand.nextFloat() < f - 0.5F) {
				if (!(e instanceof EntityPlayer) && !world.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
					return;
				}

				world.setBlock(x, y, z, mod_ebm.unstompableFarmland);
			}
		}

		private boolean plant(World world, int x, int y, int z) {
			byte b0 = 0;

			for (int l = x - b0; l <= x + b0; ++l) {
				for (int i1 = z - b0; i1 <= z + b0; ++i1) {
					Block block = world.getBlock(l, y + 1, i1);

					if (block instanceof IPlantable
							&& canSustainPlant(world, x, y, z, ForgeDirection.UP, (IPlantable) block)) {
						return true;
					}
				}
			}

			return false;
		}

		private boolean hydrate(World world, int x, int y, int z) {
			for (int l = x - 4; l <= x + 4; ++l) {
				for (int i1 = y; i1 <= y + 1; ++i1) {
					for (int j1 = z - 4; j1 <= z + 4; ++j1) {
						if (world.getBlock(l, i1, j1).getMaterial() == Material.water) {
							return true;
						}
					}
				}
			}

			return false;
		}

		public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction,
				IPlantable p) {
			if (p.getPlant(world, x, y, z) instanceof BlockCrops || p.getPlant(world, x, y, z) instanceof BlockPotato
					|| p.getPlant(world, x, y, z) instanceof BlockCarrot
					|| p.getPlant(world, x, y, z) instanceof BlockReed
					|| p.getPlant(world, x, y, z) instanceof BlockStem) {
				return true;
			} else {
				return false;
			}
		}

		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			super.onNeighborBlockChange(world, x, y, z, block);
			Material material = world.getBlock(x, y + 1, z).getMaterial();

			if (material.isSolid()) {
				world.setBlock(x, y, z, Blocks.dirt);
			}
		}

		public IIcon getIcon(int side, int meta) {
			return side == 1 ? (meta > 0 ? this.wet : this.dry) : Blocks.dirt.getBlockTextureFromSide(side);
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			return Blocks.dirt.getItemDropped(0, rand, meta);
		}

		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(Blocks.dirt);
		}

		public void registerBlockIcons(IIconRegister reg) {
			this.wet = reg.registerIcon("farmland_wet");
			this.dry = reg.registerIcon("farmland_dry");
		}
	}

	public static class FlameStone extends Block {
		public String[] types = { "activated", "deactivated", "burnMobs", "burnPlayers" };
		boolean activated, deactivated, burnMobs, burnPlayers;

		public FlameStone(Material mat, boolean activated, boolean deactivated, boolean burnMobs, boolean burnPlayers) {
			super(mat);
			this.activated = activated;
			this.deactivated = deactivated;
			this.burnMobs = burnMobs;
			this.burnPlayers = burnPlayers;
		}

		public void onEntityWalking(World world, int x, int y, int z, Entity e) {
			if (activated == true) {
				e.setFire(8);
			}

			else if (burnMobs == true) {
				if (!(e instanceof EntityPlayer)) {
					e.setFire(8);
				} else {
				}
			}

			else if (burnPlayers == true) {
				if (e instanceof EntityPlayer) {
					e.setFire(8);
				} else {
				}
			} else {
			}
		}

		public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity e) {
			if (activated == true) {
				e.setFire(8);
			}

			else if (burnMobs == true) {
				if (!(e instanceof EntityPlayer)) {
					e.setFire(8);
				} else {
				}
			}

			else if (burnPlayers == true) {
				if (e instanceof EntityPlayer) {
					e.setFire(8);
				} else {
				}
			} else {
			}
		}

		public boolean isFlammable(IBlockAccess world, int x, int y, int z, int meta, ForgeDirection face) {
			return true;
		}

		public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side) {
			if (side == ForgeDirection.UP)
				return true;
			else
				return false;
		}

		public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction,
				IPlantable p) {
			if (activated == true && p.getPlant(world, x, y, z) == mod_ebm.pyreFlower) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static class BoneBlock extends Block {
		public BoneBlock(Material mat) {
			super(mat);
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
			return true;
		}

		public int quantityDropped(Random rand) {
			return 1 + rand.nextInt(3);
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			int i = rand.nextInt(10);
			if (i >= 5 && i <= 10) {
				return Items.bone;
			} else {
				return null;
			}
		}
	}

	public static class BloodBoneBlock extends Block {
		public BloodBoneBlock(Material mat) {
			super(mat);
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
			return true;
		}

		public int quantityDropped(Random rand) {
			return 1 + rand.nextInt(3);
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			int i = rand.nextInt(10);
			if (i >= 5 && i <= 10) {
				return Items.bone;
			} else {
				return null;
			}
		}
	}

	public static class AutilBlock extends Block {
		public AutilBlock(Material mat) {
			super(mat);
		}

		public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction,
				IPlantable p) {
			if (p.getPlant(world, x, y, z) == Blocks.tallgrass) {
				return true;
			} else {
				return false;
			}
		}

		public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
			float f = .5F;
			return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) (x + 1),
					(double) ((float) (y + 1) - f), (double) (z + 1));
		}

		public int quantityDropped(Random rand) {
			return 1 + rand.nextInt(2);
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			return mod_ebm.autil;
		}

		public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
			entity.motionX *= 0.5D;
			entity.motionZ *= 0.5D;
		}
	}

	public static class AutilRod extends BlockRotatedPillar {
		public String type[] = { "autil" };

		protected IIcon[] side;
		protected IIcon[] top;

		public AutilRod(Material mat) {
			super(mat);
		}

		public void setBlockBoundsBasedOnState(IBlockAccess b, int x, int y, int z) {
			boolean flag = (b.getBlockMetadata(x, y, z) & 8) != 0;

			boolean flagV1 = b.getBlockMetadata(x, y, z) == 1;
			boolean flagV2 = b.getBlockMetadata(x, y, z) == 2;
			boolean flagV3 = b.getBlockMetadata(x, y, z) == 3;
			boolean flagV4 = b.getBlockMetadata(x, y, z) == 4;

			if (flag) {
				this.setBlockBounds(0.0f, 0.375f, 0.375f, 1.0f, 0.625f, 0.625f);
			}

			else if (flagV1) {
				this.setBlockBounds(0f, 0.43f, 0.43f, 1f, .57f, 0.57f);
			}

			else if (flagV2) {
				this.setBlockBounds(0.375f, 0.0f, 0.375f, 0.625f, 1.0f, 0.625f);
			}

			else if (flagV3) {
				this.setBlockBounds(0f, 0f, .5f, 1f, 1f, 1f);
			}

			else if (flagV4) {
				this.setBlockBounds(0f, 0f, 0f, .5f, 1f, 1f);
			}

			else {
				this.setBlockBounds(0.43f, 0.0f, 0.43f, 0.57f, 1.0f, 0.57f);
			}
		}

		public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ,
				int meta) {
			int j1 = meta;

			if (side == 1 /* && this.func_150107_m(world, x, y - 1, z) */) {
				j1 = 5;
			}

			if (side == 2 && world.isSideSolid(x, y, z + 1, NORTH, true)) {
				j1 = 4;
			}

			if (side == 3 && world.isSideSolid(x, y, z - 1, SOUTH, true)) {
				j1 = 3;
			}

			if (side == 4 && world.isSideSolid(x + 1, y, z, WEST, true)) {
				j1 = 2;
			}

			if (side == 5 && world.isSideSolid(x - 1, y, z, EAST, true)) {
				j1 = 1;
			}

			return j1;
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			if (world.getBlockMetadata(x, y, z) == 0) {
				if (world.isSideSolid(x - 1, y, z, EAST, true)) {
					world.setBlockMetadataWithNotify(x, y, z, 1, 2);
				} else if (world.isSideSolid(x + 1, y, z, WEST, true)) {
					world.setBlockMetadataWithNotify(x, y, z, 2, 2);
				} else if (world.isSideSolid(x, y, z - 1, SOUTH, true)) {
					world.setBlockMetadataWithNotify(x, y, z, 3, 2);
				} else if (world.isSideSolid(x, y, z + 1, NORTH, true)) {
					world.setBlockMetadataWithNotify(x, y, z, 4, 2);
				}
			}
		}

		public void registerBlockIcons(IIconRegister icon) {
			this.side = new IIcon[type.length];
			this.top = new IIcon[type.length];

			for (int i = 0; i < this.side.length; ++i) {
				this.side[i] = icon.registerIcon("mod_ebm:autil_block");
				this.top[i] = icon.registerIcon("mod_ebm:autil_block");
			}
		}

		protected IIcon getSideIcon(int p_150163_1_) {
			return this.side[p_150163_1_ % this.side.length];
		}

		protected IIcon getTopIcon(int p_150161_1_) {
			return this.top[p_150161_1_ % this.top.length];
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public boolean renderAsNormalBlock() {
			return false;
		}
	}

	public static class AmethystCrust extends Block {
		public AmethystCrust(Material mat) {
			super(mat);
		}

		public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction,
				IPlantable p) {
			if (p.getPlant(world, x, y, z) == Blocks.tallgrass || p.getPlant(world, x, y, z) == Blocks.brown_mushroom
					|| p.getPlant(world, x, y, z) == Blocks.red_mushroom_block) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static class AmethystDirt extends Block {
		public AmethystDirt(Material mat) {
			super(mat);
		}

		public int quantityDropped(Random rand) {
			return 1 + rand.nextInt(2);
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			return mod_ebm.amethystGrit;
		}

		public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction,
				IPlantable p) {
			if (p.getPlant(world, x, y, z) == Blocks.tallgrass || p.getPlant(world, x, y, z) == Blocks.brown_mushroom
					|| p.getPlant(world, x, y, z) == Blocks.red_mushroom_block) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static class Honeycomb extends Block {
		public Honeycomb(Material mat) {
			super(mat);
		}

		public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction,
				IPlantable p) {
			if (p.getPlant(world, x, y, z) == mod_ebm.beehive) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static class Beeswax extends Block {
		public Beeswax(Material mat) {
			super(mat);
		}

		public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction,
				IPlantable p) {
			if (p.getPlant(world, x, y, z) == mod_ebm.beehive) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static class DeadDirt extends Block {
		public DeadDirt(Material mat) {
			super(mat);
			this.setHarvestLevel("pickaxe", 0);
		}
	}

	public static class CrimsonStone extends Block {
		public CrimsonStone(Material mat) {
			super(mat);
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			return Item.getItemFromBlock(mod_ebm.crimsonCobblestone);
		}
	}
}
