package com.bottersnike.uphillstepassist;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.MinecraftDummyContainer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {

    public static Configuration configuration;
    public static float stepHeight = 1.25F;
    public static boolean stepAssistEnabled = true;

    public static void init(File configFile) {

        if(configuration == null) {
            configuration = new Configuration(configFile);
            syncConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {

        if(event.getModID().equalsIgnoreCase(Reference.MOD_ID)) {
            syncConfiguration();
        }
    }

    public static void syncConfiguration() {

        stepHeight = configuration.getFloat("Step Height", Configuration.CATEGORY_GENERAL, 1.25F, 0.6F, 32.25F, "Number of block to step up");
        stepAssistEnabled = configuration.getBoolean("Uphill Step Assist Enabled", Configuration.CATEGORY_GENERAL, true, "Is uphill step assist enabled or not");

        if(configuration.hasChanged()) {
            configuration.save();
        }
    }
}