package com.camp.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

import com.camp.ExampleMod;

public class CustomSword extends ItemSword {
	
	public static final String name = "OtmasiniumSword";
	
	public CustomSword(ToolMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(ExampleMod.MODID + "_" + name);
		this.setCreativeTab(ExampleMod.otmasTab);
	}

}
