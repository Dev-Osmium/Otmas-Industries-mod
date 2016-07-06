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
