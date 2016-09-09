package com.bottersnike.osbchatmod.event;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.script.*;
import java.util.*;
import java.util.regex.*;

public class EventHandlerCommon {

    private Minecraft mc = Minecraft.getMinecraft();
    //private Pattern extractMessage = Pattern.compile("[(.*?)] (.*)");
    private Pattern extractSolve = Pattern.compile("\\[OSB-Games\\] Solve (.*) first to get a reward\\!");
    private Pattern typeFirst = Pattern.compile("\\[OSB-Games\\] Type \"(.*)\" first to win\\!");

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

        Matcher matcher;

        matcher = this.extractSolve.matcher(message);

        if (matcher.find()) {
            try {
                reply = this.evaluateEquation(matcher.group(1)).toString();

                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                sendChatMessage(reply, true);
                            }
                        },
                        2000
                );
            } catch (Exception e) {
                System.out.println("Error parsing chat: " + e.getMessage());
            }
        }

        matcher = this.typeFirst.matcher(message);

        if (matcher.find()) {
            reply = matcher.group(1);

            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            sendChatMessage(reply, true);
                        }
                    },
                    2000
            );
        }
    }
}