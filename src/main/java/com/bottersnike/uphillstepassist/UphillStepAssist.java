package com.bottersnike.uphillstepassist;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = "[1.10.2]", guiFactory = Reference.GUI_FACTORY_CLASS)
public class UphillStepAssist {

    static Logger logger;

    @Mod.Instance(Reference.MOD_ID)
    public static UphillStepAssist instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new TickHandler());

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());

        logger = LogManager.getLogger();

        logger.info(Reference.MOD_NAME + " is loading!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}