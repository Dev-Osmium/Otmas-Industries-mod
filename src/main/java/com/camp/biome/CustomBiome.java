/*
 * Copyright (c) 2016. This program is licensed under GPL 3.0 ShareAlike Attribution. No version of this program may be sold or given away without attributing the work to the original creator, Otmas. This program is designed for use with Minecraft Forge 1.8. The developer is not responsible for any harm caused by misuse of the program.
 */

package com.camp.biome;
 
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
 
import com.camp.entity.CustomMob;
 
public class CustomBiome extends BiomeGenBase {
 
    public CustomBiome(int p_i1971_1_, boolean register) {
        super(p_i1971_1_, register);
        // TODO Auto-generated constructor stub
        this.fillerBlock = Blocks.obsidian.getDefaultState();
        this.topBlock = Blocks.netherrack.getStateFromMeta(1);
        this.waterColorMultiplier = 0x11FF11;
        this.theBiomeDecorator.cactiPerChunk = 8;
        this.theBiomeDecorator.generateLakes = true;
         
        this.spawnableMonsterList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(CustomMob.class, 100, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityBlaze.class, 100, 1, 4));
    }
 
 
}