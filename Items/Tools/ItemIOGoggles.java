/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2013
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.RotaryCraft.Items.Tools;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Reika.RotaryCraft.RotaryCraft;
import Reika.RotaryCraft.API.ShaftMachine;
import Reika.RotaryCraft.Base.ItemRotaryArmor;
import Reika.RotaryCraft.Base.TileEntityIOMachine;

public class ItemIOGoggles extends ItemRotaryArmor {

	public ItemIOGoggles(int ID, int tex, int render) {
		super(ID, RotaryCraft.IOGM, render, 0, tex);
		this.setNoRepair();
	}

	@Override
	public void onArmorTickUpdate(World world, EntityPlayer ep, ItemStack is) {
		int x = (int)ep.posX;
		int y = (int)ep.posY;
		int z = (int)ep.posZ;
		for (int i = -6; i <= 6; i++) {
			for (int j = -6; j <= 6; j++) {
				for (int k = -6; k <= 6; k++) {
					TileEntity te = world.getBlockTileEntity(x+i, y+j, z+k);
					if (te instanceof TileEntityIOMachine) {
						TileEntityIOMachine io = (TileEntityIOMachine)te;
						io.iotick = 512;
					}
					else if (te instanceof ShaftMachine) {
						ShaftMachine sm = (ShaftMachine)te;
						sm.setIORenderAlpha(512);
					}
				}
			}
		}
	}

	@Override
	public void onUpdate(ItemStack is, World par2World, Entity par3Entity, int par4, boolean par5) {}

	public String getArmorTextureFile(ItemStack itemstack) {
		return "/Reika/RotaryCraft/Textures/Misc/IOGoggles.png";
	}
}
