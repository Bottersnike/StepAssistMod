package com.bottersnike.uphillstepassist;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy {
    public static KeyBinding[] keyBindings;
    EventHandlerCommon events = new EventHandlerCommon();

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
        MinecraftForge.EVENT_BUS.register(events);

        MinecraftForge.EVENT_BUS.register(new TickHandler());
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

        keyBindings = new KeyBinding[1];

        // instantiate the key bindings
        keyBindings[0] = new KeyBinding("Toggle uphill step assist", Keyboard.KEY_GRAVE, "Uphill Step Assist");

        // register all the key bindings
        for (int i = 0; i < keyBindings.length; ++i)
        {
            ClientRegistry.registerKeyBinding(keyBindings[i]);
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
