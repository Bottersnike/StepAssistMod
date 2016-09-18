package com.bottersnike.uphillstepassist.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.bottersnike.uphillstepassist.reference.Reference;

public class ConfigurationHandler {

    public static Configuration configuration;
    public static float stepHeight = 1.25F;


    public static void init(File configFile) {

        if(configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {

        if(event.getModID().equalsIgnoreCase(Reference.MOD_ID)) {
            loadConfiguration();
        }
    }

    private static void loadConfiguration() {

        stepHeight = configuration.getFloat("Step Height", Configuration.CATEGORY_GENERAL, 1.25F, 0.5F, 32.25F, "Number of block to step up");

        if(configuration.hasChanged()) {
            configuration.save();
        }
    }
}