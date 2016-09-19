package com.bottersnike.uphillstepassist;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = "[1.10.2]", guiFactory = Reference.GUI_FACTORY_CLASS)
public class UphillStepAssist {
    @SidedProxy(serverSide = "com.bottersnike.uphillstepassist.CommonProxy", clientSide = "com.bottersnike.uphillstepassist.ClientProxy")
    public static CommonProxy proxy;

    static Logger logger;

    @Mod.Instance(Reference.MOD_ID)
    public static UphillStepAssist instance;

    @SideOnly(Side.CLIENT)
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);

        logger = LogManager.getLogger();

        logger.info(Reference.MOD_NAME + " is loading!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

}