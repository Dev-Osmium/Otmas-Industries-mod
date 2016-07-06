package com.camp.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.camp.ExampleMod;

public class OtmasiniumIngot extends Item {
	
	public static final String name = "OtmasiniumIngot";
	
	public OtmasiniumIngot() {
		
		this.setUnlocalizedName(ExampleMod.MODID + "_" + this.name);
		 
        this.setCreativeTab(ExampleMod.otmasTab);
	}

}
