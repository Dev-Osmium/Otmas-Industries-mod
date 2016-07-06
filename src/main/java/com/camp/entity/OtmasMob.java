package com.camp.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.camp.item.ItemManager;

public class OtmasMob extends EntityMob {

	public OtmasMob(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
		
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
       
         
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
	}
	
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(208.0d);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5d);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10d);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0d);
    }
	
	public boolean isAIEnabled() {
        return true;
    }
	
	public void dropFewItems(boolean recentlyHit, int lootLevel) {
		
			int quantity = this.rand.nextInt(4) + 1;
		 
	    	for (int i = 0; i < quantity; i++) {
	    		this.dropItem(ItemManager.customItem, 1);
	    		this.dropItem(ItemManager.otmasiniumingot, 1);
	 
	    	}

	}
}
