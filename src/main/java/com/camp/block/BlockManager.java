/*
 * Copyright (c) 2016. This program is licensed under GPL 3.0 ShareAlike Attribution. No version of this program may be sold or given away without attributing the work to the original creator, Otmas. This program is designed for use with Minecraft Forge 1.8. The developer is not responsible for any harm caused by misuse of the program.
 */

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
