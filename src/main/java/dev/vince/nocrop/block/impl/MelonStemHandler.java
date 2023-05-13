package dev.vince.nocrop.block.impl;

import dev.vince.nocrop.block.AbstractBlockHandler;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent;

public final class MelonStemHandler extends AbstractBlockHandler {
    public MelonStemHandler() {
        super(Blocks.melon_stem);
    }

    @Override
    public void execute(final BlockEvent.BreakEvent event) {
        if (event.state.getBlock() == block) {
            cancelBreak(event);
        }
    }
}
