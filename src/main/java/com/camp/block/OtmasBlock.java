/*
 * Copyright (c) 2016. This program is licensed under GPL 3.0 ShareAlike Attribution. No version of this program may be sold or given away without attributing the work to the original creator, Otmas. This program is designed for use with Minecraft Forge 1.8. The developer is not responsible for any harm caused by misuse of the program.
 */

package com.camp.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.camp.ExampleMod;

public class OtmasBlock extends Block {

	 public static final String name = "OtmasBlock";
	 
	protected OtmasBlock(Material materialIn) {
		super(Material.rock);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
		float hardness = 50;
		this.setHardness(hardness);
		this.setLightLevel(1.0f);
	}
	
	public OtmasBlock() {
        super(Material.rock);
        this.setUnlocalizedName(ExampleMod.MODID + "_" + name);
        this.setCreativeTab(ExampleMod.otmasTab);
    }

}