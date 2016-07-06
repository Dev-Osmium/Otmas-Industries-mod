package com.camp.block;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockManager {
	
	public static CustomBlock customBlock;
	public static OtmasBlock otmasBlock;
	public static OtmasiniumOre otmasinium;
	
	public static void mainRegistry() {
        initializeBlock();
        registerBlock();
    }
 
    public static void initializeBlock() {
    	 customBlock = new CustomBlock();
    	 otmasBlock = new OtmasBlock();
    	 otmasinium = new OtmasiniumOre();
    }
 
    public static void registerBlock() {
    	GameRegistry.registerBlock(customBlock, customBlock.name);
    	GameRegistry.registerBlock(otmasBlock, otmasBlock.name);
    	GameRegistry.registerBlock(otmasinium, otmasinium.name);
    }
 
}
