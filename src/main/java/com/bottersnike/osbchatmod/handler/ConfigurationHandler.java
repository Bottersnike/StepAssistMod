package com.bottersnike.osbchatmod.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.bottersnike.osbchatmod.reference.Reference;

public class ConfigurationHandler {

    public static Configuration configuration;
    public static int solveDelay = 3250;
    public static int repeatDelay = 3250;
    public static String solveExtract = "\\[OSB-Games\\] Solve (.*) first to get a reward\\!";
    public static String typeFirst = "\\[OSB-Games\\] Type \"(.*)\" first to win\\!";


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

        solveDelay = configuration.getInt("Solve x first delay", Configuration.CATEGORY_GENERAL, 3250, 0, 10000, "Set the delay before submitting an answer.");
        repeatDelay = configuration.getInt("Type x first delay", Configuration.CATEGORY_GENERAL, 3250, 0, 10000, "Set the delay before submitting an answer.");
        solveExtract = configuration.getString("Solve x first regex", Configuration.CATEGORY_GENERAL, "\\[OSB-Games\\] Solve (.*) first to get a reward\\!", "Set the regex used to extract the maths sum.");
        typeFirst = configuration.getString("Type x first regex", Configuration.CATEGORY_GENERAL, "\\[OSB-Games\\] Type \"(.*)\" first to win\\!", "Set the regex used to extract the string to repeat.");

        if(configuration.hasChanged()) {
            configuration.save();
        }
    }
}