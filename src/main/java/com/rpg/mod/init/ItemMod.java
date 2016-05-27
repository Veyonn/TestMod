package com.rpg.mod.init;

import com.rpg.mod.Reference;
import com.rpg.mod.mrpg;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemMod 
{
	//Declaration des item Exemple: L'item, un autre Item, le dernier Item;
	public static Item itemModBasic;
	
	public static void init()
	{
		//Caracteristique de chaque item
		itemModBasic = new Item().setUnlocalizedName("itemModBasic").setCreativeTab(mrpg.tabRPG);
	}
	
	public static void register()
	{
		//Gameregistry + craft
		GameRegistry.registerItem(itemModBasic, "itemModBasic");
	}
	
	public static void registerRenders()
	{
		//Texture
		registerRender(itemModBasic);
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
