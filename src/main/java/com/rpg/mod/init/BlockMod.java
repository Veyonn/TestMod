package com.rpg.mod.init;

import com.rpg.mod.Reference;
import com.rpg.mod.mrpg;
import com.rpg.mod.Block.BlockModFence;
import com.rpg.mod.Block.BlockStairsMod;
import com.rpg.mod.Block.BlocksMod;
import com.rpg.mod.Block.RPGBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockMod 
{
	public static Block blockModBasic, block3d, blockStairsModBasic, RPGBlock, blockFenceModBasic;
	
	public static void init()
	{
		/**Variable*/
		Block block100 = (new BlocksMod(Material.rock));
		
		/**Block*/
		blockModBasic = new BlocksMod(Material.rock).setUnlocalizedName("blockModBasic").setCreativeTab(mrpg.tabRPG);
		block3d = new BlocksMod(Material.glass).setUnlocalizedName("block3d").setCreativeTab(mrpg.tabRPG);
        blockStairsModBasic = new BlockStairsMod(block100.getDefaultState()).setUnlocalizedName("blockStairsModBasic").setCreativeTab(mrpg.tabRPG);	
        RPGBlock = new RPGBlock(Material.rock).setUnlocalizedName("RPGBlock").setCreativeTab(mrpg.tabRPG);
        blockFenceModBasic = new BlockModFence(Material.rock).setUnlocalizedName("blockFenceModBasic").setCreativeTab(mrpg.tabRPG);
        
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(blockModBasic, blockModBasic.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block3d, block3d.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockStairsModBasic, blockStairsModBasic.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(RPGBlock, RPGBlock.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockFenceModBasic, blockFenceModBasic.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(blockModBasic);
		registerRender(block3d);
        registerRender(blockStairsModBasic);
		registerRender(RPGBlock);
		registerRender(blockFenceModBasic);
		
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
