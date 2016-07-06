package com.camp.entity;
 
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.camp.ExampleMod;
 
public class RenderOtmasBiped extends RenderBiped {
 
    
    public RenderOtmasBiped(ModelBiped model,
            float scale) {
        super(Minecraft.getMinecraft().getRenderManager(), model, scale);
        // TODO Auto-generated constructor stub
    }
 
    
 
    @Override
    protected ResourceLocation getEntityTexture(Entity var1) {
    	return new ResourceLocation(ExampleMod.MODID, "textures/entity/otmas_biped.png");
    	
        // TODO Auto-generated method stub
    }
 
}


