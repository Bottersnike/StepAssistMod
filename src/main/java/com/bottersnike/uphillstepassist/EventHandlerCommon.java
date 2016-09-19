package com.bottersnike.uphillstepassist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventHandlerCommon {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class)) {
            if (ClientProxy.keyBindings[0].isPressed()) {
                if (ConfigurationHandler.stepAssistEnabled) {
                    ConfigurationHandler.stepAssistEnabled = false;
                    sendChatMessage("Uphill step assist is §4OFF§4!");
                } else {
                    ConfigurationHandler.stepAssistEnabled = true;
                    sendChatMessage("Uphill step assist is §2ON§2!");
                }
            }
        }
    }

    private void sendChatMessage(String msg)
    {
        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new TextComponentString(msg));
    }
}
