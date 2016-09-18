package com.bottersnike.uphillstepassist.tickHandler;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;

import com.bottersnike.uphillstepassist.handler.ConfigurationHandler;


@SideOnly(Side.CLIENT)
public class TickHandler
{
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        EntityPlayer player = event.player;

        setStepHeight(player, ConfigurationHandler.stepHeight);
    }

    public void setStepHeight(EntityPlayer player, Float height)
    {
        if (player.stepHeight != height)
        {
            player.stepHeight = height;
        }
    }
}