
/*
 * Copyright (c) 2016. This program is licensed under GPL 3.0 ShareAlike Attribution. No version of this program may be sold or given away without attributing the work to the original creator, Otmas. This program is designed for use with Minecraft Forge 1.8. The developer is not responsible for any harm caused by misuse of the program.
 */

package com.camp.world;
 
import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.camp.block.BlockManager;
 
public class CustomWorldGenerator implements IWorldGenerator{
/*
 *  Generate will be called each time a 16x16 chunk is generated
 *  Be careful how much code you add here - it gets slow very quickly!
 * 
 */
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
         
        // Code to run during world generation here
         
         
         
        // Check what dimension is being generated
        switch(world.provider.getDimensionId()){
        case -1:
        // Dim -1 Nether
            break;
        case 0:
            // Dim 0 Surface
            generateSurface(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
            break;
        case 1:
            // Dim 1 End
            break;
 
        }
         
         
         
    }
     
    public static WorldGenMinable oreGen = new WorldGenMinable (BlockManager.customBlock.getDefaultState(), 4);
     
    public void generateSurface(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
        // Code called to generate surface blocks
         
        // For loop runs 5 times - this will be how many chances to generate a vein of our ore we'll have
            for (int i = 0; i < 16; i++){
                // Randomize coordinates for ore starting position
                 
                int startX = chunkX + random.nextInt(16);
                // Vertical position - this sets how deep down your ore will generate. Lower numbers are deeper
                int startY = random.nextInt(16) + 50;
                int startZ = chunkZ + random.nextInt(16);
                 
                // Store the coordinates in a BlockPos
                BlockPos start = new BlockPos(startX, startY, startZ);
             
         
                // Create a new WorldGenMinable with custom block. This will create and place an ore vein    .
                (new WorldGenMinable(BlockManager.customBlock.getDefaultState(), random.nextInt(5) + 1)).generate(world, random, start);
                // If you want to specify a special block type that your ore must start in use this instead:
                //oreGen.generate(world, random, start);
            }
         
    }
    
    public void generateCustom(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
         
        // Code to run during world generation here
         if(random.nextInt(100) == 0) {
        	 int startX = chunkX *16 + random.nextInt(16);
             // Vertical position - get the top of the world
             int startY = world.getActualHeight()-1;
             int startZ = chunkZ *16 + random.nextInt(16);
              
             BlockPos pos = new BlockPos(startX, startY, startZ);
              
             while(world.getBlockState(pos) == Blocks.air.getDefaultState()){
                 pos = pos.down();
                 // go down until we find something that isn't air.
             }
              
             // set blocks
             world.setBlockState(pos, Blocks.obsidian.getDefaultState());
             for(int i = 0 ; i < 5; i++){
                 world.setBlockState(pos.up(i), Blocks.obsidian.getDefaultState());
             }
         }
         
         
        // Check what dimension is being generated
        switch(world.provider.getDimensionId()){
        case -1:
        // Dim -1 Nether
            break;
        case 0:
            // Dim 0 Surface
            generateSurface(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
            break;
        case 1:
            // Dim 1 End
            break;
        case 2:
        	generateCustom(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        	break;
 
        }
         
         
         
    }
     
     
     
 
}
