package com.bottersnike.uphillstepassist;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.bottersnike.uphillstepassist.handler.ConfigurationHandler;
import com.bottersnike.uphillstepassist.tickHandler.TickHandler;
import com.bottersnike.uphillstepassist.reference.Reference;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = "[1.10.2]", guiFactory = Reference.GUI_FACTORY_CLASS)
public class UphillStepAssist {

    @Mod.Instance(Reference.MOD_ID)
    public static UphillStepAssist instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(Reference.MOD_NAME + " is loading!");

        FMLCommonHandler.instance().bus().register(new TickHandler());

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