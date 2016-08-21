/*
 * Copyright (c) 2016. This program is licensed under GPL 3.0 ShareAlike Attribution. No version of this program may be sold or given away without attributing the work to the original creator, Otmas. This program is designed for use with Minecraft Forge 1.8. The developer is not responsible for any harm caused by misuse of the program.
 */

package com.camp.item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.camp.ExampleMod;

import static com.camp.ExampleMod.otmasTab;

public class CustomItem extends Item {
	public static final String name = "CustomItem";
	public CustomItem() {
		super();
		this.setUnlocalizedName(ExampleMod.MODID + "_" + this.name);
		this.setCreativeTab(otmasTab);
		
	}
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		 worldIn.createExplosion(playerIn, pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 10.0f, true);
		// TODO Auto-generated method stub
		return super.onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
	}

}
