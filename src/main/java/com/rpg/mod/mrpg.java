package com.rpg.mod;

import com.rpg.mod.init.BlockMod;
import com.rpg.mod.init.ItemMod;
import com.rpg.mod.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class mrpg 
{
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static CreativeTabs tabRPG = new CreativeTabs("tabRPG")
	{
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			//Pour un block : return Item.getItemFromBlock(BlockMod.blockModBasic);
			return ItemMod.itemModBasic;
		}
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
        proxy.preInit(event.getSuggestedConfigurationFile());
		BlockMod.init();
		BlockMod.register();
		ItemMod.init();
		ItemMod.register();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
        proxy.init();
		proxy.registerRenders();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
