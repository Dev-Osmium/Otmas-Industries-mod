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
		 worldIn.createExplosion(playerIn, pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 100.0f, true);
		// TODO Auto-generated method stub
		return super.onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
	}

}
