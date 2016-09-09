package com.bottersnike.osbchatmod.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import com.bottersnike.osbchatmod.handler.ConfigurationHandler;
import com.bottersnike.osbchatmod.reference.Reference;

public class ModGuiConfig extends GuiConfig {

    public ModGuiConfig(GuiScreen screen) {
        super(screen, new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()),
                "OSB Chat Cheater Settings");
    }
}