package com.bottersnike.uphillstepassist;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)

public class TickHandler {
    private boolean setLast = false;
    private float   lastHeight = 0.6F;

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        EntityPlayer player = event.player;

        if (ConfigurationHandler.stepAssistEnabled) {
            if (player.stepHeight != ConfigurationHandler.stepHeight) {
                lastHeight = player.stepHeight;
            }
            setStepHeight(player, ConfigurationHandler.stepHeight);
            setLast = true;
        } else if (setLast) {
            setStepHeight(player, lastHeight);
            setLast = false;
        }

    }

    public void setStepHeight(EntityPlayer player, Float height)
    {
        if (player.stepHeight != height)
        {
            player.stepHeight = height;

            UphillStepAssist.logger.info("Step height changed... Setting step height to " + ConfigurationHandler.stepHeight);
        }
    }

}
