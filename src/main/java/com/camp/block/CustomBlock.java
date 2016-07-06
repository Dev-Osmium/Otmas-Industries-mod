package com.camp.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

import com.camp.ExampleMod;

public class CustomBlock extends Block {

	 public static final String name = "CustomBlock";
	 
	protected CustomBlock(Material materialIn) {
		super(Material.rock);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
		float hardness = 18000000;
		this.setHardness(hardness);
		this.setLightLevel(1.0f);
		this.setBlockUnbreakable();
	}
	
	public CustomBlock() {
        super(Material.rock);
        this.setUnlocalizedName(ExampleMod.MODID + "_" + name);
        this.setCreativeTab(ExampleMod.otmasTab);
    }

}
