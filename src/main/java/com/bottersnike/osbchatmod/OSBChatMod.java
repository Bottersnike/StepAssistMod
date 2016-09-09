package com.bottersnike.osbchatmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.bottersnike.osbchatmod.handler.ConfigurationHandler;

import com.bottersnike.osbchatmod.reference.Reference;
import com.bottersnike.osbchatmod.event.EventHandlerCommon;
import com.bottersnike.osbchatmod.proxy.CommonProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = "[1.10.2]", guiFactory = Reference.GUI_FACTORY_CLASS)
public class OSBChatMod {

    @SidedProxy(serverSide = "com.bottersnike.osbchatmod.proxy.CommonProxy", clientSide = "com.bottersnike.osbchatmod.proxy.ClientProxy")
    public static CommonProxy proxy;

    EventHandlerCommon events = new EventHandlerCommon();

    @Mod.Instance(Reference.MOD_ID)
    public static OSBChatMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(Reference.MOD_NAME + " is loading!");
        FMLCommonHandler.instance().bus().register(events);
        MinecraftForge.EVENT_BUS.register(events);

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}