package dev.vince.nocrop.block.impl;

import dev.vince.nocrop.block.AbstractBlockHandler;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent;

public final class WheatHandler extends AbstractBlockHandler {
    public WheatHandler() {
        super(Blocks.wheat);
    }

    @Override
    public void execute(final BlockEvent.BreakEvent event) {
        if (event.state.getBlock() == block) {
            cancelBreak(event);
        }
    }
}
