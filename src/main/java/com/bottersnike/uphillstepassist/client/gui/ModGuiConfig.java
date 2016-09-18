package com.bottersnike.uphillstepassist.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import com.bottersnike.uphillstepassist.handler.ConfigurationHandler;
import com.bottersnike.uphillstepassist.reference.Reference;

public class ModGuiConfig extends GuiConfig {

    public ModGuiConfig(GuiScreen screen) {
        super(screen, new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()),
                "Uphill Step Assist Settings");
    }
}