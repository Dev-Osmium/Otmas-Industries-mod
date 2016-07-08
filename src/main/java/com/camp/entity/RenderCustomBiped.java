/*
 * Copyright (c) 2016. This program is licensed under GPL 3.0 ShareAlike Attribution. No version of this program may be sold or given away without attributing the work to the original creator, Otmas. This program is designed for use with Minecraft Forge 1.8. The developer is not responsible for any harm caused by misuse of the program.
 */

package com.camp.entity;
 
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.camp.ExampleMod;
 
public class RenderCustomBiped extends RenderBiped {
 
    
    public RenderCustomBiped(ModelBiped model,
            float scale) {
        super(Minecraft.getMinecraft().getRenderManager(), model, scale);
        // TODO Auto-generated constructor stub
    }
 
     
 
    @Override
    protected ResourceLocation getEntityTexture(Entity var1) {
    	return new ResourceLocation(ExampleMod.MODID, "textures/entity/custom_biped.png");
    	
        // TODO Auto-generated method stub
    }
 
}

