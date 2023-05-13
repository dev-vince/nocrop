package dev.vince.nocrop.block.impl;

import dev.vince.nocrop.block.AbstractBlockHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent;

public final class SugarCaneHandler extends AbstractBlockHandler {
    public SugarCaneHandler() {
        super(Blocks.reeds);
    }

    @Override
    public void execute(final BlockEvent.BreakEvent event) {
        Block below = event.world.getBlockState(event.pos.down()).getBlock();

        if (below == Blocks.reeds)
            return;

        if (event.state.getBlock() == block) {
            cancelBreak(event);
        }
    }
}
