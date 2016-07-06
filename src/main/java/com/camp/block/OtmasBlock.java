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