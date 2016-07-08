/*
 * Copyright (c) 2016. This program is licensed under GPL 3.0 ShareAlike Attribution. No version of this program may be sold or given away without attributing the work to the original creator, Otmas. This program is designed for use with Minecraft Forge 1.8. The developer is not responsible for any harm caused by misuse of the program.
 */

package com.camp;

import com.camp.biome.CustomBiome;
import com.camp.block.BlockManager;
import com.camp.entity.CustomMob;
import com.camp.entity.OtmasMob;
import com.camp.entity.RenderCustomBiped;
import com.camp.entity.RenderOtmasBiped;
import com.camp.item.ItemManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.Height;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;


@Mod (modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {
    public static final String MODID = "otmasindustries";
    public static final String VERSION = "0.96b";
    private static int lastBiomeID = 0;
    public static BiomeGenBase customBiome;
    public static ToolMaterial customToolMaterial;

    public static CreativeTabs otmasTab = new CreativeTabs("Otmas Industries Mod") {

        @Override
        public Item getTabIconItem () {
            return Items.skull;
        }

    };

    @EventHandler
    public void preinit (FMLPreInitializationEvent event) {
        customToolMaterial = EnumHelper.addToolMaterial("Otmasinium", 3, 10, 4, 100, 0);

        ItemManager.mainRegistry();
        BlockManager.mainRegistry();
        System.out.println("loading mobs...");

        createEntity(CustomMob.class, "CustomMob", 0x00FF00, 0xFF0000);
        createEntity(OtmasMob.class, "OtmasMob", 0x0000FF, 0xFF0000);
        System.out.println("Done.");

    }

    @EventHandler
    public void init (FMLInitializationEvent event) {
        // some example code
        System.out.println("Otmas Industries mod version" + VERSION + " loaded");
        // render entity
        RenderingRegistry.registerEntityRenderingHandler(CustomMob.class, new RenderCustomBiped(new ModelBiped(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler(OtmasMob.class, new RenderOtmasBiped(new ModelBiped(), 0.5f));

        // Crafting Recipes
        System.out.println("Loading Crafting Recipes");
        //Shaped Recipes
        GameRegistry.addShapedRecipe(new ItemStack(BlockManager.customBlock, 1), "rwr", "wbw", "rwr", 'r', new ItemStack(Blocks.wool, 1, 14), 'w', new ItemStack(Blocks.wool, 1, 0), 'b', new ItemStack(Blocks.wool, 1, 11));
        GameRegistry.addShapedRecipe(new ItemStack(BlockManager.otmasBlock, 1), "ooo", "oco", "ooo", 'o', Blocks.obsidian, 'c', BlockManager.customBlock);
        GameRegistry.addShapedRecipe(new ItemStack(ItemManager.otmasshrine, 1), "  e", " b ", "b  ", 'e', Items.emerald, 'b', Items.blaze_rod);
        //Shapeless Recipes
        GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 64), Blocks.dirt);
        
        ItemStack dirtStack = new ItemStack(Blocks.dirt);
        ItemStack sandStack = new ItemStack(Blocks.sand);

        GameRegistry.addShapelessRecipe(new ItemStack(Items.emerald, 64), dirtStack, dirtStack, dirtStack, dirtStack, sandStack, sandStack);

        //Smelting Recipes
        GameRegistry.addSmelting(new ItemStack(BlockManager.otmasinium), new ItemStack(ItemManager.otmasiniumingot, 1), 1f);
        System.out.println("Done");
        // Item Rendering
        System.out.println("Rendering Items");
        if (event.getSide() == Side.CLIENT) {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

            renderItem.getItemModelMesher().register(ItemManager.customItem, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.customItem.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.customBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.customBlock.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.otmasBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.otmasBlock.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.otmasshrine, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.otmasshrine.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.otmasinium), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.otmasinium.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.otmasSword, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.otmasSword.name, "inventory"));

        }
        System.out.println("Done");
        // Entity Spawns
        addSpawn(CustomMob.class, 1000, 1, 5, EnumCreatureType.MONSTER);
        int biomeID = getEmptyBiomeID();
        if (biomeID != -1) {
            customBiome = new CustomBiome(biomeID, true).setBiomeName("Otmas Industries").setHeight(new Height(1.5f, 0.05f));
        }
    }


    public static void createEntity (Class entityClass, String entityName, int solidColor, int spotColor) {
        int entityId = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, entityName, entityId);
        EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, solidColor, spotColor));
    }
    
    public static void addSpawn (Class entityClass, int probability, int min, int max, EnumCreatureType type) {

        for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++) {

            if (BiomeGenBase.getBiomeGenArray()[i] != null) {
                EntityRegistry.addSpawn(entityClass, probability, min, max, type, BiomeGenBase.getBiomeGenArray()[i]);
            }

        }

    }
    
    @SubscribeEvent
    public void spawnWithEffect (EntityJoinWorldEvent event) {

    }
    
    @SubscribeEvent
    public void serverCommands (ICommand command, ICommandSender sender, String parameters, Throwable exception) {
    }
    
    public static int getEmptyBiomeID () {
        int i;
        BiomeGenBase[] array = BiomeGenBase.getBiomeGenArray();
        //loop through biome array to find an empty id.
        for (i = lastBiomeID; i < array.length; i++) {
            if (array[i] == null) {
                // Found an empty spot
                // Set lastBiomeID then return index.
                lastBiomeID = i;
                return i;
            }
        }
        // didn't find an empty spot
        return -1;
    }

}