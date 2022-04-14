package com.artl.hithack.Utils;

import com.artl.hithack.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class ChatUtils {
    private static final String prefix = "[" + Client.cName + "]";

    public static void sendMessage(String msg) {
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString(prefix + msg));
    }
}
