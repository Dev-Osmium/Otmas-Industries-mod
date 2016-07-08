/*
 * Copyright (c) 2016. This program is licensed under GPL 3.0 ShareAlike Attribution. No version of this program may be sold or given away without attributing the work to the original creator, Otmas. This program is designed for use with Minecraft Forge 1.8. The developer is not responsible for any harm caused by misuse of the program.
 */

package com.camp.item;

import com.camp.ExampleMod;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemManager {
	
	public static CustomItem customItem;
	public static ShrineOfOtmas otmasshrine;
	public static OtmasiniumIngot otmasiniumingot;
	public static CustomSword otmasSword;
	
    
	public static void mainRegistry() {
        initializeItem();
        registerItem();
    }
 
    public static void initializeItem() {
    	customItem = new CustomItem();
    	otmasshrine = new ShrineOfOtmas();
    	otmasiniumingot = new OtmasiniumIngot();
    	otmasSword = new CustomSword(ExampleMod.customToolMaterial);
    }
 
    public static void registerItem() {
    	GameRegistry.registerItem(customItem, customItem.name);
    	GameRegistry.registerItem(otmasshrine, otmasshrine.name);
    	GameRegistry.registerItem(otmasiniumingot, otmasiniumingot.name);
    	GameRegistry.registerItem(otmasSword, otmasSword.name);
    }
}
