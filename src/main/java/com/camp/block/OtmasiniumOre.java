package com.camp.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.camp.ExampleMod;

public class OtmasiniumOre extends Block {
	
	public static final String name = "OtmasiniumOre";

	protected OtmasiniumOre() {
		super(Material.rock);
		this.setUnlocalizedName(ExampleMod.MODID + "_" + name);
		this.setCreativeTab(ExampleMod.otmasTab);
		// TODO Auto-generated constructor stub
	}
	


}
