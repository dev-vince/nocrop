package dev.vince.nocrop.block;

import dev.vince.nocrop.util.ChatUtil;
import net.minecraft.block.Block;
import net.minecraftforge.event.world.BlockEvent;

public abstract class AbstractBlockHandler {
    protected final Block block;

    public AbstractBlockHandler(final Block block) {
        this.block = block;
    }

    public abstract void execute(final BlockEvent.BreakEvent event);

    protected void cancelBreak(final BlockEvent.BreakEvent event) {
        ChatUtil.addChatMessage("A feature has prevented you from breaking " + this.block.getRegistryName() + "!");
        event.setCanceled(true);
    }
}
