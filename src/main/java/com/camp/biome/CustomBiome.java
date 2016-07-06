package com.camp.biome;
 
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
 
import com.camp.entity.CustomMob;
 
public class CustomBiome extends BiomeGenBase {
 
    public CustomBiome(int p_i1971_1_, boolean register) {
        super(p_i1971_1_, register);
        // TODO Auto-generated constructor stub
        this.fillerBlock = Blocks.sandstone.getDefaultState();
        this.topBlock = Blocks.sand.getStateFromMeta(1);
        this.waterColorMultiplier = 0x11FF11;
        this.theBiomeDecorator.cactiPerChunk = 8;
        this.theBiomeDecorator.generateLakes = true;
         
        this.spawnableMonsterList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(CustomMob.class, 100, 1, 4));
         
    }
 
 
}