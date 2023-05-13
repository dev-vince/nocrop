package dev.vince.nocrop.util;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.vince.nocrop.NoCropMod;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public final class ChatUtil {
    private ChatUtil() {}

    private static final String PREFIX = ChatFormatting.DARK_PURPLE + "[" + ChatFormatting.BOLD + ChatFormatting.AQUA + NoCropMod.MODID + ChatFormatting.RESET + ChatFormatting.DARK_PURPLE + "]" + ChatFormatting.AQUA + " ";

    public static void addChatMessage(final String message) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(PREFIX + message));
    }
}
