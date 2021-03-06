package emt.tile.solar.compressed;

import emt.init.EMTBlocks;
import emt.tile.DefinitelyNotAIC2Source;
import emt.tile.solar.TileEntitySolarBase;
import emt.util.EMTConfigHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class TileEntityCompressedSolar extends TileEntitySolarBase {

	public TileEntityCompressedSolar() {
		super();
		energySource = new DefinitelyNotAIC2Source(this, 10000, 3);
		output = EMTConfigHandler.compressedSolarOutput;
		this.maxstorage=this.getEUCapacity();
	};

	@Override
	public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
		return new ItemStack(EMTBlocks.emtSolars, 1, 0);
	}
	
	@Override
	public float calc_multi() {
		return 1F;
	}
	
	@Override
	public String getInventoryName() {
		return "Compressed Solar";
	}
}
