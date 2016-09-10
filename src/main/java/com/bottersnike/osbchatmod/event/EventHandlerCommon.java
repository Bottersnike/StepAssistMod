package com.bottersnike.osbchatmod.event;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import com.bottersnike.osbchatmod.handler.ConfigurationHandler;

import javax.script.*;
import java.util.*;
import java.util.regex.*;

public class EventHandlerCommon {

    private Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onPlayerLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event) {
        System.out.println("OUTPUT!!!");

        event.player.stepHeight += 16.0F;
    }

    /* OSB_CHAT_BOT CODE:

    //private Pattern extractMessage = Pattern.compile("[(.*?)] (.*)");

    private ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");
    private String reply;

    private Object evaluateEquation(String equation) throws Exception
    {
        return this.scriptEngine.eval(equation);
    }

    private void sendChatMessage(String msg, boolean addToChat)
    {
        if (addToChat)
        {
            this.mc.ingameGUI.getChatGUI().addToSentMessages(msg);
        }
        if (net.minecraftforge.client.ClientCommandHandler.instance.executeCommand(mc.thePlayer, msg) != 0) return;

        this.mc.thePlayer.sendChatMessage(msg);
    }

    @SubscribeEvent
    public void onClientChatRecieved(ClientChatReceivedEvent event) throws Exception {
        String message = event.getMessage().getUnformattedText();
        message = message.replaceAll("§.", "");

        Matcher matcher;

        matcher = Pattern.compile(ConfigurationHandler.solveExtract).matcher(message);

        if (matcher.find()) {
            try {
                reply = this.evaluateEquation(matcher.group(1)).toString();
                reply = reply.indexOf(".") < 0 ? reply : reply.replaceAll("0*$", "").replaceAll("\\.$", "");

                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                sendChatMessage(reply, true);
                            }
                        },
                        ConfigurationHandler.solveDelay
                );
            } catch (Exception e) {
                System.out.println("Error parsing chat: " + e.getMessage());
            }
        }

        matcher = Pattern.compile(ConfigurationHandler.typeFirst).matcher(message);

        if (matcher.find()) {
            reply = matcher.group(1);

            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            sendChatMessage(reply, true);
                        }
                    },
                    ConfigurationHandler.repeatDelay
            );
        }
    }

    */
}