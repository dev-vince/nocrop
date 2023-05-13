package dev.vince.nocrop.util;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.vince.nocrop.NoCropMod;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public final class ChatUtil {
    private ChatUtil() {}

    private static final String PREFIX = ChatFormatting.WHITE + "[" + ChatFormatting.BOLD + ChatFormatting.AQUA + NoCropMod.MODID + ChatFormatting.RESET + ChatFormatting.WHITE + "]" + ChatFormatting.GRAY + " ";

    public static void addChatMessage(final String message) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(PREFIX + message));
    }
}
