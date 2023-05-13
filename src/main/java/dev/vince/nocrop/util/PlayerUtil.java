package dev.vince.nocrop.util;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemTool;

public final class PlayerUtil {
    private PlayerUtil() {
    }

    public static boolean isPlayerHoldingTool() {
        if (Minecraft.getMinecraft().thePlayer == null || Minecraft.getMinecraft().thePlayer.getHeldItem() == null)
            return false;

        return !(Minecraft.getMinecraft().thePlayer.getHeldItem().getItem() instanceof ItemTool);
    }
}
