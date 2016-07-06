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
