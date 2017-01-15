package emt.item.focus;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emt.EMT;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.ItemFocusBasic;
import thaumcraft.common.items.wands.ItemWandCasting;

public class ItemChristmasFocus extends ItemBaseFocus {

	private static final AspectList visCost = new AspectList().add(Aspect.ORDER, 500).add(Aspect.AIR, 500);

	public ItemChristmasFocus() {
		super("christmas");
	}

	@Override
	public int getFocusColor(ItemStack stack) {
		return 0x00FFFF;
	}

	@Override
	public AspectList getVisCost(ItemStack stack) {
		return visCost;
	}

	@Override
	public String getSortingHelper(ItemStack itemstack) {
		return "CHRISTMAS";
	}

	@Override
	public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition mop) {
		ItemWandCasting wand = (ItemWandCasting) itemstack.getItem();
		if ((mop != null) && (mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)) {
			int x = mop.blockX;
			int y = mop.blockY + 1;
			int z = mop.blockZ;
			if (player.capabilities.isCreativeMode || wand.consumeAllVis(itemstack, player, getVisCost(itemstack), true, true)) {
				if (!world.isRemote) {
					EntitySnowman snowman;
					snowman = new EntitySnowman(world);
					snowman.setPosition(x, y, z);
					world.spawnEntityInWorld(snowman);
				}
			}
			player.swingItem();
		}
		return itemstack;
	}
}
