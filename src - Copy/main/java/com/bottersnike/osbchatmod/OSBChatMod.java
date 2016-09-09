package com.bottersnike.osbchatmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.bottersnike.osbchatmod.event.EventHandlerCommon;
import com.bottersnike.osbchatmod.proxy.CommonProxy;

@Mod(modid = OSBChatMod.modId, name = OSBChatMod.name, version = OSBChatMod.version, acceptedMinecraftVersions = "[1.10.2]")
public class OSBChatMod {

    @SidedProxy(serverSide = "com.bottersnike.osbchatmod.proxy.CommonProxy", clientSide = "com.bottersnike.osbchatmod.proxy.ClientProxy")
    public static CommonProxy proxy;

    EventHandlerCommon events = new EventHandlerCommon();

    public static final String modId = "osbchatmod";
    public static final String name = "OSB Chat Mod";
    public static final String version = "0.0.0a";

    @Mod.Instance(modId)
    public static OSBChatMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(name + " is loading!");
        FMLCommonHandler.instance().bus().register(events);
        MinecraftForge.EVENT_BUS.register(events);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}