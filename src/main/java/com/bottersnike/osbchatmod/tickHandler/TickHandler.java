package com.bottersnike.osbchatmod.tickHandler;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;


@SideOnly(Side.CLIENT)
public class TickHandler
{
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        EntityPlayer player = event.player;

        setStepHeight(player, 1.25F);
    }

    public void setStepHeight(EntityPlayer player, Float height)
    {
        if (player.stepHeight != height)
        {
            player.stepHeight = height;
        }
    }
}