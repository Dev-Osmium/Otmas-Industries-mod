/*
 * Copyright (c) 2016. This program is licensed under GPL 3.0 ShareAlike Attribution. No version of this program may be sold or given away without attributing the work to the original creator, Otmas. This program is designed for use with Minecraft Forge 1.8. The developer is not responsible for any harm caused by misuse of the program.
 */

package com.camp.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.camp.ExampleMod;

public class ShrineOfOtmas extends Item {
	
	public static final String name = "Scepter Of Otmas";
	
	public ShrineOfOtmas() {
		
		super();
        
		 
        this.setUnlocalizedName(ExampleMod.MODID + "_" + this.name);
 
        this.setCreativeTab(ExampleMod.otmasTab);
        
        this.setMaxStackSize(1);
        
		
    }    

}
