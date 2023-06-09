package dev.vince.nocrop.block.impl;

import dev.vince.nocrop.block.AbstractBlockHandler;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent;

public final class PumpkinStemHandler extends AbstractBlockHandler {
    public PumpkinStemHandler() {
        super(Blocks.pumpkin_stem);
    }
    @Override
    public void execute(final BlockEvent.BreakEvent event) {
        if (event.state.getBlock() == block) {
            cancelBreak(event);
        }
    }
}
