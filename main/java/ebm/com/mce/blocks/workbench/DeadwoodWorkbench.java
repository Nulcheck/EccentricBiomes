package ebm.com.mce.blocks.workbench;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.entity.tile.block.TECT;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class DeadwoodWorkbench extends BlockContainer {
	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon side;

	public DeadwoodWorkbench() {
		super(Material.wood);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 1 ? this.top
				: (side == 0 ? mod_ebm.deadPlanks.getBlockTextureFromSide(side)
						: (side != 2 && side != 4 ? this.blockIcon : this.side));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon("mod_ebm:workbench_dead" + "_side");
		this.top = icon.registerIcon("mod_ebm:workbench_dead" + "_top");
		this.side = icon.registerIcon("mod_ebm:workbench_dead" + "_front");
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX,
			float hitY, float hitZ) {
		player.openGui(mod_ebm.instance, mod_ebm.deadCTableGUI, player.worldObj, x, y, z);
		return true;
	}

	public TileEntity createNewTileEntity(World world, int id) {
		return new TECT();
	}
}
