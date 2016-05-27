package com.rpg.mod.proxy;

import java.io.File;

import org.lwjgl.input.Keyboard;

import com.rpg.mod.Reference;
import com.rpg.mod.init.BlockMod;
import com.rpg.mod.init.ItemMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class ClientProxy extends CommonProxy
{
	private static KeyBinding keyBinding;
	
	//rendu en jeux ect coter client !!
	@Override
	public void registerRenders()
	{
		ItemMod.registerRenders();
		BlockMod.registerRenders();
	}
	
    @Override
    public void preInit(File configFile)
    {
        super.preInit(configFile);
        System.out.println("pre init côté client");
    }

    @Override
    public void init()
    {
        super.init();
    }
    
    public ClientProxy()
    {
    	FMLCommonHandler.instance().bus().register(this);
    	keyBinding = new KeyBinding(Reference.MOD_ID + ".keyTuto", Keyboard.KEY_M, "key.categories.gameplay");
    	ClientRegistry.registerKeyBinding(keyBinding);

    }
    
    @SubscribeEvent
    public void onEvent(KeyInputEvent event)
    {
    	if(keyBinding.isPressed())
    	{
    		keyPressed();
    	}
    }
    
    private void keyPressed()
    {
    	Minecraft.getMinecraft().thePlayer.addExperience(150);
    }
}
